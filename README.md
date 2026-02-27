# Network Configuration Project (Java)

This project simulates a small-scale computer network involving routers, switches, and firewalls. It demonstrates the configuration of TCP/IP, DHCP, and DNS to enable communication across multiple systems, along with security filtering via a firewall.

## Features

- **Network Device Simulation**: Classes for Hosts, Routers, and Firewalls implemented in Java.
- **DHCP Service**: Automated IP address assignment from a pool.
- **DNS Service**: Domain name resolution to IP addresses.
- **Firewall Logic**: Rule-based packet filtering (Allow/Deny).
- **TCP/IP Communication**: Simulated packet sending and receiving between hosts.

## Project Structure

- `src/com/networksim/`: Java source files.
  - `Packet.java`: Data structure for network packets.
  - `NetworkDevice.java`: Abstract base class for all network devices.
  - `Host.java`: Represents end-user systems.
  - `Router.java`: Handles packet routing.
  - `Firewall.java`: Implements security rules.
  - `DHCPServer.java`: Manages dynamic IP allocation.
  - `DNSServer.java`: Handles domain name resolution.
  - `NetworkSimulation.java`: Main entry point for the simulation.

## How to Run

Ensure you have Java JDK installed.

1.  **Compile the project**:
    ```bash
    mkdir out
    javac -d out src/com/networksim/*.java
    ```

2.  **Run the simulation**:
    ```bash
    java -cp out Networking.NetworkSimulation
    ```

## Simulation Details

The simulation performs the following steps:
1.  **Initialize Services**: Sets up a DNS server with records and a DHCP server with an IP pool.
2.  **Configure Firewall**: Defines rules to allow HTTP traffic and deny SSH traffic to a web server.
3.  **Host Setup**: A PC (PC1) requests an IP address via DHCP.
4.  **Communication**:
    - PC1 resolves `webserver.local` via DNS.
    - PC1 sends an HTTP request to the web server (Allowed).
    - PC1 attempts an SSH connection to the web server (Blocked by Firewall).

## Optimization and Troubleshooting

The simulation includes logging of packet movements and firewall decisions, which helps in troubleshooting network reachability and security issues. In a real-world scenario, this would involve:
- Monitoring bandwidth and latency.
- Auditing firewall logs for unauthorized access attempts.
- Verifying DHCP lease times and DNS propagation.
