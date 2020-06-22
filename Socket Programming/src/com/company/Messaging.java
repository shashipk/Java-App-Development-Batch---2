package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Messaging extends Thread{

    Socket clientSocket;

    Messaging(Socket socket){
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = null;
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            while (true) {
                String msg = null;
                try {
                    msg = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Client sent: " + msg);
                out.println("Server acknowledge this message : " + msg + " in thread " + currentThread().getName());

                if (msg.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
