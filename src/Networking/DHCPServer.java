package Networking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DHCPServer {
    private List<String> pool;
    private Map<String, String> assigned;

    public DHCPServer(List<String> ipRange) {
        this.pool = new ArrayList<>(ipRange);
        this.assigned = new HashMap<>();
    }

    public String getIp(String mac) {
        if (assigned.containsKey(mac)) {
            return assigned.get(mac);
        }
        if (!pool.isEmpty()) {
            String ip = pool.remove(0);
            assigned.put(mac, ip);
            return ip;
        }
        return null;
    }
}
