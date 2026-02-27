package Networking;

import java.util.HashMap;
import java.util.Map;

public class DNSServer {
    private Map<String, String> records;

    public DNSServer() {
        this.records = new HashMap<>();
    }

    public void addRecord(String domain, String ip) {
        records.put(domain, ip);
    }

    public String resolve(String domain) {
        return records.get(domain);
    }
}
