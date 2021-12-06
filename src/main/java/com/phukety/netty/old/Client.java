package com.phukety.netty.old;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("连接客户端...");
        Socket socket = new Socket("localhost", 9000);
        System.out.println("连接成功");
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("client: send");
        out.close();
    }
}
