package simpleloadbalancer;

import java.util.LinkedList;
import java.util.Queue;

// Represents a simpleloadbalancer.Server in the cluster
class Server {
    // Each server has a queue to hold tasks
    private Queue<Task> tasks = new LinkedList<>();
    private String name;

    public Server(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Add tasks to server's queue
    public synchronized void addTask(Task task) {
        tasks.add(task);
        notifyAll();
    }

    // Starts the server's processing of tasks
    public void start() {
        // Simulate task processing
        new Thread(() -> {
            while (true) {
                Task task;
                synchronized (this) {
                    while (tasks.isEmpty()) {
                        try {
                            wait(); // Waiting for a task to arrive
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.poll();
                }
                // Execute the task
                task.execute();
            }
        }, name).start();
    }
}
