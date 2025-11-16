package devises_1290.a10.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class EntityManagerProvider {

    private static EntityManagerProvider instance = null;
    private EntityManagerFactory emf = null;
    private EntityManager em;


    private void setUpEMFUsingXML() {
        this.emf = Persistence
                .createEntityManagerFactory("MariaDBPU_UsingXML");
    }

    private void setUpEMFUsingCode() {
        PersistenceUnitInfo pui = new SAAQ_PUI();
        this.emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(pui, new HashMap());
    }

    private EntityManagerProvider() {
        //this.setUpEMFUsingCode();
        this.setUpEMFUsingXML();
        this.em= this.emf.createEntityManager();
    }

    public static EntityManagerProvider getInstance() {
        if (EntityManagerProvider.instance == null)
            EntityManagerProvider.instance = new EntityManagerProvider();
        return EntityManagerProvider.instance;
    }

    public  EntityManager getEntityManager() {
        return this.em;
    }

}
