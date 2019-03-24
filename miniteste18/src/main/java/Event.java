import java.util.ArrayList;

public class Event {
    private String title, date, description;
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    private int audienceCount;

    public Event(String name) {
        this.title = name;
        date = "";
        description = "";
    }
    public Event(String name, String Date) {
        this.title = name;
        date = Date;
        description = "";
    }
    public Event(String name, String Date, String des) {
        this.title = name;
        date = Date;
        this.description = des;
    }
    public Event(Event event) {
        this.title = event.getTitle();
        date = event.getDate();
        this.description = event.getDescription();

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public final String toString(){
        return title + " is a " + description + " and will be held at " + date +".";
    }
    public boolean equals(Object object){
        return (title == ((Event) object).getTitle() && description == ((Event) object).getDescription() &&
        date == ((Event) object).getDate());
    }

    public void addPerson(Person person) {
        for(Person per : people){
            if(per.equals(person))
                return;
        }
        audienceCount++;
        people.add(person);

    }


    public int getAudienceCount() {
        return audienceCount;
    }

    public void addEvent(Event e) {
        events.add(e);
        audienceCount += e.getAudienceCount();
    }
}
