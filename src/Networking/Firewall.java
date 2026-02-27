package Networking;

import java.util.ArrayList;
import java.util.List;

public class Firewall extends NetworkDevice {
    private List<Rule> rules;

    public Firewall(String name) {
        super(name);
        this.rules = new ArrayList<>();
    }

    public void addRule(String source, String dest, String protocol, String action) {
        rules.add(new Rule(source, dest, protocol, action));
    }

    public boolean filterPacket(Packet packet) {
        for (Rule rule : rules) {
            if ((rule.source.equals("*") || packet.getSourceIp().equals(rule.source)) &&
                (rule.dest.equals("*") || packet.getDestIp().equals(rule.dest)) &&
                (rule.protocol.equals("*") || packet.getProtocol().equals(rule.protocol))) {
                System.out.println(String.format("[%s] Rule matched: %s for %s", name, rule.action, packet));
                return rule.action.equalsIgnoreCase("ALLOW");
            }
        }
        System.out.println(String.format("[%s] Default DENY for %s", name, packet));
        return false;
    }

    private static class Rule {
        String source;
        String dest;
        String protocol;
        String action;

        Rule(String source, String dest, String protocol, String action) {
            this.source = source;
            this.dest = dest;
            this.protocol = protocol;
            this.action = action;
        }
    }
}
