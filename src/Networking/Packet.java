package Networking;

public class Packet {
    private String sourceIp;
    private String destIp;
    private String protocol;
    private String data;
    private int ttl;

    public Packet(String sourceIp, String destIp, String protocol, String data) {
        this(sourceIp, destIp, protocol, data, 64);
    }

    public Packet(String sourceIp, String destIp, String protocol, String data, int ttl) {
        this.sourceIp = sourceIp;
        this.destIp = destIp;
        this.protocol = protocol;
        this.data = data;
        this.ttl = ttl;
    }

    public String getSourceIp() { return sourceIp; }
    public String getDestIp() { return destIp; }
    public String getProtocol() { return protocol; }
    public String getData() { return data; }
    public int getTtl() { return ttl; }

    @Override
    public String toString() {
        return String.format("Packet(%s, %s -> %s, data='%s')", protocol, sourceIp, destIp, data);
    }
}
