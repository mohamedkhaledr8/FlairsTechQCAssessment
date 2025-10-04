package RequestResponse.SubClasses;

public class HiringManager {
    public int id;
    public String firstName;
    public String middleName;
    public String lastName;
    public Object terminationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getTerminationId() {
        return terminationId;
    }

    public void setTerminationId(Object terminationId) {
        this.terminationId = terminationId;
    }
}
