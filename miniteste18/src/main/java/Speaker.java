public class Speaker extends Person implements User {
    private int  fee;

    public Speaker(String name) {
        super(name);
    }
    public Speaker(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Speaker "+ getName() +" as a fee value of "+ fee +".";
    }


    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String getUsername() {
        return getName()+ getAge();
    }
    public boolean equals(Object object){
        return (getName() == ((Person) object).getName());
    }
}
