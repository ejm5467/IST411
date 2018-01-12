/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karin
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
public class Client {
        public static void main(String[] args) {
            System.out.println("Simple Echo Client");
       
                try {
        System.out.println("Waiting for connection.....");
        InetAddress localAddress = InetAddress.getLocalHost();

        try (Socket clientSocket = new Socket(localAddress, 6000);
                    PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                    BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                        clientSocket.getInputStream()))) {
 
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
