import java.util.LinkedList;

public class CacheFileEventLogger extends  FileEventLogger{

    private LinkedList<Event> eventCache;
    private int cacheSize;


    public CacheFileEventLogger(String filename, int cacheSize){
        super(filename);
        this.cacheSize = cacheSize;
        eventCache = new LinkedList<Event>();
    }

    @Override
    public void logEvent(Event event){
        eventCache.add(event);
        if(eventCache.size() >= cacheSize){
            for(Event e : eventCache){
                super.logEvent(e);
            }
            eventCache.clear();
        }
    }

}
