package org.example;

import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("TCP Server đang lắng nghe tại cổng 12345...");

            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("Đã kết nối với client: " + clientSocket.getInetAddress());


                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


                String message = in.readLine();
                System.out.println("Nhận từ client (TCP): " + message);


                out.println("Server đã nhận (TCP): " + message);


                clientSocket.close();
                System.out.println("Đã ngắt kết nối với client.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
