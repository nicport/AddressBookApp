import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BuddyInfo {
    private String name;
    private String phoneNum;
    private String id;

    public BuddyInfo() {
        this.name = "John Doe";
        this.phoneNum = "2587894561";
    }

    public BuddyInfo(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /*
    @Override
    public String toString() {
        return "BuddyInfo{" +
                "name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return Objects.equals(getName(), buddyInfo.getName()) && Objects.equals(getPhoneNum(), buddyInfo.getPhoneNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNum());
    }

    @Id
    @GeneratedValue
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
