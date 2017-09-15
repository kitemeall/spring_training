import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }


    private Client client;

    private EventLogger eventLogger;

    public void logEvent(Event event){
        eventLogger.logEvent(event);
    }

    public static void main(String[] args){


        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App)ctx.getBean("app");

        Event event = (Event) ctx.getBean("event");
        Event event1 = (Event) ctx.getBean("event");
        Event event2 = (Event) ctx.getBean("event");

        event.setMsg("тело сообщения");
        event1.setMsg("тело сообщения1");
        event2.setMsg("тело сообщения2");



        App fileApp = (App)ctx.getBean("fileApp");

        fileApp.logEvent(event);
        fileApp.logEvent(event1);
        fileApp.logEvent(event2);
        fileApp.logEvent(event1);
        fileApp.logEvent(event2);
        fileApp.logEvent(event1);

    }
}
