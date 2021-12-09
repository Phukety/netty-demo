package com.phukety.netty.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 未使用netty的阻塞式客户端
 */
public class OIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());
    }
}
