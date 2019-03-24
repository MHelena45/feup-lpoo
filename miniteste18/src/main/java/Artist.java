public class Artist extends Person implements User {

    public Artist(String name) {
        super(name);
    }
    public Artist(String name, int age) {
        super(name, age);
    }

    public String getUsername() {
        return getName() + getAge();
    }
    public boolean equals(Object object){
        return (getName() == ((Person) object).getName());
    }
}
