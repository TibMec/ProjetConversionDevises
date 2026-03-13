package devises_1290.a10.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {

    private static EntityManagerProvider instance = null;
    private EntityManagerFactory emf = null;
    private EntityManager em;

    private void setUpEMFUsingXML() {
        this.emf = Persistence
                .createEntityManagerFactory("MariaDBPU_UsingXML");
    }

    private EntityManagerProvider() {
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
