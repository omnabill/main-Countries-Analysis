import java.util.List;
//city pojo Class
public class maincity {
    private String no;
    private String city;
    private  double pop;
    private String ID;
    public Object key;

    public String getNo() {
    
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPop() {
        return this.pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public maincity(String no, String city, double pop, String ID) {
        this.no = no;
        this.city = city;
        this.pop = pop;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "{" +
            " no='" + getNo() + "'" +
            ", city='" + getCity() + "'" +
            ", pop='" + getPop() + "'" +
            ", ID='" + getID() + "'" +
            "}"+"\n";
    }

    public List<maincity> read(String string) {
        return null;
    }



    
}
