package com.viaryha.lab1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {}

    public static void main(String[] args) {
        //command-line arguments are passed like this: 127.0.0.1 1087
        String host = (args.length < 1) ? null : args[0];
        int port = (args.length < 2) ? 1087 : Integer.parseInt(args[1]);

        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            Converter stub = (Converter) registry.lookup("Converter");
            inputString(stub);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void inputString(Converter stub) throws RemoteException {
        char condition;
        Scanner scanner = new Scanner(System.in);
        do {
            String response = stub.replaceVowels(handleInput());
            System.out.println("Результат: " + response);
            System.out.println("Желаете продолжить ввод? Введите 'н' для выхода");
            String line = scanner.nextLine();
            condition = line.length() > 0 ? line.charAt(0) : 'д';
        } while (condition != 'н');
    }

    private static String handleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");

        String str = scanner.nextLine();
        return str;
    }
}
