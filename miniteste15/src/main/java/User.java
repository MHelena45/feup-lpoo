public class User<string> {

    private string name;

    User(string name){
        this.name  = name;
    }

    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public boolean equals(User us) {
        if (this == us) return true;                   // are the references equal
        if (us == null) return false;                  // is the other object null
        //if (getClass() != us.getClass()) return false; // both objects the same class
        if(name == us.getName() )
            return true;
        return false;
    }


}
