public class Client {
    public static void main(String[] args) {
        // Create a concrete Servant
        Servant taskServant = new TaskServant();

        // Create an Active Object with the Servant
        ActiveObject activeObject = new TaskActiveObject(taskServant);

        // Client requests tasks
        activeObject.request("Task 1");
        activeObject.request("Task 2");
        activeObject.request("Task 3");
    }
}