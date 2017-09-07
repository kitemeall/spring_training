public class App {


    private Client client;

    private ConsoleEventLogger eventLogger;

    public void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args){
        App app = new App();

        app.client = new Client("1", "Sam");
        app.eventLogger = new ConsoleEventLogger();
        app.logEvent("hello new msg");

    }
}
