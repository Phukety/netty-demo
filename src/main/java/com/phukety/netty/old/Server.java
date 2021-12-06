package com.phukety.netty.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("等待连接...");
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket clientSocket = serverSocket.accept();
        System.out.println("连接成功");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        // PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        String request;
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            System.out.println(request);
        }
        in.close();
    }
}
