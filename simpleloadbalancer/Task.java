package simpleloadbalancer;

import java.io.Serializable;

// Defines the simpleloadbalancer.Task that will be executed
class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    // The task's run logic should be implemented here
    public void execute() {
        System.out.println("Executing simpleloadbalancer.Task on " + Thread.currentThread().getName());
        // simpleloadbalancer.Task's complex logic goes here...
    }
}
