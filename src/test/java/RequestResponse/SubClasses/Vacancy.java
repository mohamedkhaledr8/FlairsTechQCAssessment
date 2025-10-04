package RequestResponse.SubClasses;

public class Vacancy {

    public int id;
    public String name;
    public boolean status;
    public HiringManager hiringManager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public HiringManager getHiringManager() {
        return hiringManager;
    }

    public void setHiringManager(HiringManager hiringManager) {
        this.hiringManager = hiringManager;
    }
}
