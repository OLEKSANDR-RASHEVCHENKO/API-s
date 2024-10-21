package API.createDiffrenceTypeOfBody.pojoPostReq;

public class Pojo {
    String name;
    String locations;
    String phone;
    String courses[];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String location) {
        this.locations = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }
}
