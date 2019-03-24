public class Attendee extends Person implements User {
    private boolean paid;

    public Attendee(String name) {
        super(name);
    }
    public Attendee(String name, int age) {
       super(name, age);
    }

    public boolean hasPaid() {
        return paid;
    }

    @Override
    public String toString() {
        if(paid)
            return "Attendee "+ getName() + " has paid its registration.";
        else
            return "Attendee "+ getName() +" hasn't paid its registration.";
    }



    public boolean equals(Object object){
        return ( getName() == ((Person) object).getName());
    }

    @Override
    public String getUsername() {
        return getName() + getAge();
    }
}
