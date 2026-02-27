package Networking;

import java.util.HashMap;
import java.util.Map;

public class Router extends NetworkDevice {
    private Map<String, String> routingTable; // dest_network: next_hop

    public Router(String name) {
        super(name);
        this.routingTable = new HashMap<>();
    }

    public void addRoute(String network, String interfaceIp) {
        routingTable.put(network, interfaceIp);
    }

    public boolean routePacket(Packet packet) {
        System.out.println(String.format("[%s] Routing packet to %s", name, packet.getDestIp()));
        // Simplified routing logic as in original
        return true;
    }
}
