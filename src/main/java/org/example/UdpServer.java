package org.example;

import java.io.IOException;
import java.net.*;

public class UdpServer {
    public static void main(String[] args) {
        try (DatagramSocket udpSocket = new DatagramSocket(12346)) {
            System.out.println("UDP Server đang lắng nghe tại cổng 12346...");

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);

                // Nhận gói tin từ client
                udpSocket.receive(requestPacket);
                String message = new String(requestPacket.getData(), 0, requestPacket.getLength());
                System.out.println("Nhận từ client (UDP): " + message);

                // Gửi phản hồi đến client
                String responseMessage = "Server đã nhận (UDP): " + message;
                byte[] responseBytes = responseMessage.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseBytes,
                        responseBytes.length,
                        requestPacket.getAddress(),
                        requestPacket.getPort()
                );
                udpSocket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
