import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

    public void performJPA() {

        // Create an object representing address book
        AddressBook addressBook = new AddressBook();

        // Creating objects representing some buddies
        BuddyInfo buddy1 = new BuddyInfo();
        BuddyInfo buddy2 = new BuddyInfo("Nic", "226589245");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the buddy entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        // Once buddy entities are persisted, add them to address book and
        // persist the address book
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        em.persist(addressBook);

        tx.commit();


        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        Collection<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddies\n----------------");

        for (BuddyInfo b : results) {

            System.out.println(b.getName() + ", Phone Number: " + b.getPhoneNum() + " (id=" + b.getId() + ")");
        }

        // Querying the contents of the database using JPQL query
        Query q2 = em.createQuery("SELECT a FROM AddressBook a");


        @SuppressWarnings("unchecked")
        Collection<AddressBook> results2 = q2.getResultList();

        System.out.println("----------------\nList of buddies in address book\n----------------");


        for (AddressBook a : results2) {

            System.out.println(a.getAddrBook() + " (id=" + a.getId() + ")");
            for (BuddyInfo buddy : a.getAddrBook()) {
                System.out.println(buddy.getName() + ", Phone Number: " + buddy.getPhoneNum() + " (id=" + buddy.getId() + ")");
            }

        }




        // Closing connection
        em.close();

        emf.close();
    }
}
