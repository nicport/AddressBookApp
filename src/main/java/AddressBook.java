import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
public class AddressBook {
    private Long id;
    private Collection<BuddyInfo> buddies;

    public AddressBook() {
        buddies = new HashSet();
    }

    @OneToMany
    public Collection<BuddyInfo> getAddrBook() {
        return this.buddies;
    }

    public void setAddrBook(Collection<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void addBuddy(BuddyInfo buddy){
        buddies.add(buddy);
    }

    /*
     * Gets the id of this AddressBook.
     * @return the id
     */
    @Id
    @GeneratedValue
    public Long getId() {
        return this.id;
    }

    /*
     * Sets the id of this AddressBook to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    public static void main(String args[]) {


        JPATest test = new JPATest();
        test.performJPA();
    }
}
