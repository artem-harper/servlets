package org.example.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws UnknownHostException {

        var inetAddress = InetAddress.getByName("localhost");

        try(DatagramSocket datagramSocket = new DatagramSocket()){

            var bytes = "hello from UDP clinet".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            datagramSocket.send(datagramPacket);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
