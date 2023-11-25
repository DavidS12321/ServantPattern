class TaskServant implements Servant {
    @Override
    public void performTask(String task) {
        System.out.println("Performing task: " + task);
    }
}