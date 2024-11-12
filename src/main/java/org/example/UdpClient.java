package org.example;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    public static void main(String[] args) {
        try (DatagramSocket udpSocket = new DatagramSocket()) {
            String message = "Hello UDP Server!";
            byte[] buffer = message.getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Gửi gói tin đến UDP server
            DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length, serverAddress, 12346);
            udpSocket.send(requestPacket);
            System.out.println("Gửi tới UDP server: " + message);

            // Nhận phản hồi từ server
            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            udpSocket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Nhận từ UDP server: " + response);
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
