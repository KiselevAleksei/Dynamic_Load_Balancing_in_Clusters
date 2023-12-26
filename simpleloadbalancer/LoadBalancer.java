package simpleloadbalancer;

// Interface for Load Balancer
interface LoadBalancer {
    void addServer(Server server);

    Server getNextServer();
}
