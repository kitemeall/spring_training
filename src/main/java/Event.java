import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    private  int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.id = (new Random(System.currentTimeMillis())).nextInt(10);
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString(){
        return df.format(date)+" " + id +" "+ msg;
    }
}
