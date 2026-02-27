package Networking;

public class Host extends NetworkDevice {
    private String ip;
    private String gateway;
    private String dnsServer;

    public Host(String name) {
        super(name);
    }

    public Host(String name, String ip) {
        super(name);
        this.ip = ip;
    }

    public void setIp(String ip) { this.ip = ip; }
    public String getIp() { return ip; }
    public void setGateway(String gateway) { this.gateway = gateway; }
    public void setDnsServer(String dnsServer) { this.dnsServer = dnsServer; }

    public Packet sendPacket(String destIp, String protocol, String data) {
        Packet packet = new Packet(this.ip, destIp, protocol, data);
        System.out.println(String.format("[%s] Sending %s", name, packet));
        return packet;
    }

    public boolean receivePacket(Packet packet) {
        System.out.println(String.format("[%s] Received %s", name, packet));
        if (packet.getDestIp().equals(this.ip)) {
            System.out.println(String.format("[%s] Processing packet: %s", name, packet.getData()));
            return true;
        }
        return false;
    }
}
