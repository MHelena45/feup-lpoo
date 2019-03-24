public abstract class Person implements Comparable {
    private String name;
    private int age;

    Person(String name){
        this.name = name;
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int compareTo(Object o) {
        if(this.equals(o))
            return 0;

        return this.name.compareTo((String)o);
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

}
