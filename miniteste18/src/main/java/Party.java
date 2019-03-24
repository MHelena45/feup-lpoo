import java.lang.reflect.Array;
import java.util.ArrayList;

public class Party extends Event{
    public Party(String name) {
        super(name);
    }

    public Party(String name, String Date) {
        super(name, Date);
    }

    public Party(String name, String Date, String des) {
        super(name, Date, des);
    }

    public Party(Event event) {
        super(event);
    }


}
