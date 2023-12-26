package simpleloadbalancer;

import java.util.ArrayList;
import java.util.List;

// Round-Robin implementation for Load Balancing
class RoundRobinLoadBalancer implements LoadBalancer {
    private List<Server> serverList = new ArrayList<>();
    private int index = 0;

    public void addServer(Server server) {
        serverList.add(server);
    }

    // Returns the next server in a round-robin fashion
    public Server getNextServer() {
        if (serverList.isEmpty()) {
            return null;
        }
        Server server = serverList.get(index);
        index = (index + 1) % serverList.size();
        return server;
    }
}
