import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class TaskActiveObject implements ActiveObject {
    private final Servant servant;
    private final BlockingQueue<String> taskQueue;

    public TaskActiveObject(Servant servant) {
        this.servant = servant;
        this.taskQueue = new ArrayBlockingQueue<>(10);
        start();
    }

    private void start() {
        // Worker thread to asynchronously execute tasks
        new Thread(() -> {
            while (true) {
                try {
                    String task = taskQueue.take();
                    servant.performTask(task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void request(String task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}