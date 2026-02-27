package Networking;

import java.util.HashMap;
import java.util.Map;

public abstract class NetworkDevice {
    protected String name;
    protected Map<String, String> interfaces; // interface_name: ip

    public NetworkDevice(String name) {
        this.name = name;
        this.interfaces = new HashMap<>();
    }

    public String getName() { return name; }

    public void connect(NetworkDevice otherDevice, String localInterface, String remoteInterface) {
        // Implementation for physical/logical connection
    }
}
