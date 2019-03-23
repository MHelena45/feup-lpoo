import java.util.ArrayList;

public class Room implements Facility{
    private Building building;
    private String number, name;
    private int floor;
    private int capacity ;
    private ArrayList<User> users = new ArrayList<User>();

    Room(Building b, String n, int f) throws DuplicateRoomException, IllegalArgumentException {
        this.building = b;
        this.number = n;
        this.name = b.getName() + n;
        this.floor = f;
        if(b.getMaxFloor() < f)
            throw new IllegalArgumentException();

        ArrayList<Room> rooms = b.getRooms();
        for(Room elem : rooms) {
            if(this.equals(elem))
                throw new DuplicateRoomException();
        }

        b.addRoom(this);

    }
    Room(Building b, String n, int f, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        this.building = b;
        this.number = n;
        this.name = b.getName() + n;
        this.floor = f;
        this.capacity = capacity;
        b.setCapacity( b.getCapacity() + capacity);
        if(b.getMaxFloor() < f)
            throw new IllegalArgumentException();

        ArrayList<Room> rooms = b.getRooms();
        for(Room elem : rooms) {
            if(this.equals(elem))
                throw new DuplicateRoomException();
        }

        b.addRoom(this);
    }



    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canEnter(User u) {
        for(User elem : users) {
            if(elem.equals(u))
                return true;
        }

        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public String toString() {
        return "Room(" + building.getName() + "," + number + ")";
    }

    public int getCapacity() {
        return capacity;
    }
    public boolean equals(Object obj) {
        return (building == ((Room) obj).getBuilding()) &&
                number.equals(((Room) obj).getNumber()) &&
                (floor == ((Room) obj).getFloor());
    }

    public void authorize(User u) {
        users.add(u);
    }


}
