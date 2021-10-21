package data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostalAddress {
    String street;
    int building;
    int floor;
    String door;

    public static final PostalAddress NO_ADDRESS = new PostalAddress();

    public PostalAddress() {
        super();
    }

    public PostalAddress(String street, int building, int floor, String door) {
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.door = door;
    }
}
