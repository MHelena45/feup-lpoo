import java.util.ArrayList;

public class Building implements Facility {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private String name;
    private int minFloor, maxFloor;
    private int capacity ;

    Building(String letter, int mimFloor, int maxFloor) throws IllegalArgumentException {
        this.name = letter;
        if(maxFloor < mimFloor)
            throw new IllegalArgumentException();

        this.minFloor = mimFloor;
        this.maxFloor = maxFloor;
    }

    public void addRoom(Room room) throws DuplicateRoomException {
        rooms.add(room);
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int mimFloor) {
        this.minFloor = mimFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        return "Building(" + name + ")";
    }

    @Override
    public boolean canEnter(User u) {
        for(Room elem : rooms) {
            if(elem.canEnter(u))
                return true;
        }
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public ArrayList<Room> getRooms() {
        ArrayList<Room> clone = (ArrayList<Room>) rooms.clone();
        return clone;
    }
}
