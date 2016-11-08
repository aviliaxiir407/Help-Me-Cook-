package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

/**
 * Created by user_ on 11/8/2016.
 */

public class person {
    //name and address string
    private String name;
    private String address;

    public person() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
