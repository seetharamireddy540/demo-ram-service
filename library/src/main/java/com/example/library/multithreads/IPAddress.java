package com.example.library.multithreads;

import java.net.*;

public class IPAddress {
    public static void main(String[] args) {
        try {
            InetAddress myIP = InetAddress.getLocalHost();
            System.out.println("My IP address is: " + myIP.getHostAddress());

            String hostName = "herd-work-storage-alpha-01.corp.amazon.com"; // replace with your desired hostname
            InetAddress address = InetAddress.getByName(hostName);
            System.out.println("IP address of " + hostName + ": " + address.getHostAddress());
        } catch (UnknownHostException ex) {
            System.out.println("Could not find IP address of the host.");
        }
    }
}
