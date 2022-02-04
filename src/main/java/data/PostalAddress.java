package data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
public class PostalAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
