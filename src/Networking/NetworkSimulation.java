package Networking;

import java.util.Arrays;

public class NetworkSimulation {
    public static void main(String[] args) {
        System.out.println("--- Network Configuration Simulation (Java) ---");

        // Setup DNS
        DNSServer dns = new DNSServer();
        dns.addRecord("webserver.local", "192.168.1.10");

        // Setup DHCP
        DHCPServer dhcp = new DHCPServer(Arrays.asList("192.168.1.101", "192.168.1.102", "192.168.1.103"));

        // Setup Firewall
        Firewall fw = new Firewall("MainFirewall");
        fw.addRule("192.168.1.101", "192.168.1.10", "HTTP", "ALLOW");
        fw.addRule("*", "192.168.1.10", "SSH", "DENY");

        // Setup Hosts
        String pc1Ip = dhcp.getIp("00:11:22:33:44:55");
        Host pc1 = new Host("PC1", pc1Ip);

        Host webServer = new Host("WebServer", "192.168.1.10");

        System.out.println(String.format("PC1 IP assigned via DHCP: %s", pc1.getIp()));

        // Simulate Communication
        System.out.println("\n--- Simulating Allowed Traffic ---");
        String targetIp = dns.resolve("webserver.local");
        Packet packet1 = pc1.sendPacket(targetIp, "HTTP", "GET /index.html");
        if (fw.filterPacket(packet1)) {
            webServer.receivePacket(packet1);
        } else {
            System.out.println("Packet blocked by firewall.");
        }

        System.out.println("\n--- Simulating Blocked Traffic ---");
        Packet packet2 = pc1.sendPacket("192.168.1.10", "SSH", "Connect");
        if (fw.filterPacket(packet2)) {
            webServer.receivePacket(packet2);
        } else {
            System.out.println("Packet blocked by firewall.");
        }
    }
}
