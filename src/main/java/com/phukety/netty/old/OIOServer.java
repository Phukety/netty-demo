package com.phukety.netty.old;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 未使用netty的阻塞式服务端
 */
public class OIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true) {
            final Socket clientSocket = server.accept();
            System.out.println("Accepted connection from " + clientSocket);
            new Thread(new Runnable() {
                public void run() {
                    OutputStream out;
                    try {
                        out = clientSocket.getOutputStream();
                        out.write("Hi".getBytes());
                        out.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            clientSocket.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }

                }
            }).start();
        }
    }
}
