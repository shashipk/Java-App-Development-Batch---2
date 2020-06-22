package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(4001);
            while(true) {
                Socket clientSocket = socket.accept();

                Messaging obj = new Messaging(clientSocket);
                obj.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
