package com.kozlovnazarov.classes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 8080;

    public Server() {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("The server is started on port " + PORT);
            while (true) {
                clientSocket = serverSocket.accept();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
