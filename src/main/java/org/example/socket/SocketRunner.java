package org.example.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketRunner{
    public static void main(String[] args) throws UnknownHostException {

        var inetAdress = Inet4Address.getByName("localhost");

        try(var socket = new Socket(inetAdress, 7777);
            var outputStream = new DataOutputStream(socket.getOutputStream());
            var inputStream = new DataInputStream(socket.getInputStream());
            var scanner = new Scanner(System.in)){

            while (scanner.hasNextLine()){
                var request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println("Response from server: "+inputStream.readUTF());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}