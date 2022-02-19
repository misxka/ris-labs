package com.viaryha.lab1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Converter {

    public Server() {}

    @Override
    public String replaceVowels(String str) throws RemoteException {
        return str.replaceAll("[aeyuioAEYUIOауоиэыяюеёАУОИЭЫЯЮЕЁ]", "*");
    }

    public static void main(String[] args) {
        try {
            Server obj = new Server();
            Converter stub = (Converter) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(1087);
            registry.bind("Converter", stub);
            System.out.println("Server is listening...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
