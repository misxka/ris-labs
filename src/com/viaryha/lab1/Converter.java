package com.viaryha.lab1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Converter extends Remote {
    String replaceVowels(String str) throws RemoteException;
}
