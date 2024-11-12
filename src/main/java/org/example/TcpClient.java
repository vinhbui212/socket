package org.example;

import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) {
        try (Socket tcpSocket = new Socket("localhost", 12345)) {
            PrintWriter out = new PrintWriter(tcpSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));

            // Gửi tin nhắn đến TCP server
            String message = "Hello TCP Server!";
            out.println(message);
            System.out.println("Gửi tới TCP server: " + message);

            // Nhận phản hồi từ server
            String response = in.readLine();
            System.out.println("Nhận từ TCP server: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
