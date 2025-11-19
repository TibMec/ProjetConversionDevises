package devises_1290.a10.dal;

import devises_1290.a10.data.EntityManagerProvider;
import devises_1290.a10.model.Rate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RateDAO_JPA implements IRate_DAO {
    EntityManager em = null;

    public RateDAO_JPA(EntityManager em) {
        this.em = EntityManagerProvider.getInstance().getEntityManager();
    }

    @Override
    public boolean updateRate(double rateValue, int id) {
        boolean updated = false;
        /*EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        // retrieved the target entity
        Make m = this.findByBrand(brand);
        // update the desired information
        m.setCountry(newCountry);
        // merge between the object in memory
        // and the counterpart row in the database
        this.em.merge(m);
        transaction.commit();
        */
        EntityTransaction transaction = this.em.getTransaction();
        Rate r = this.em.find(Rate.class, id);
        r.setValue(rateValue);
        transaction.commit();
        //int affectedRows = pStmt.executeUpdate();
        //if (affectedRows == 1)
          //  updated = true;
        return updated;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        return null;
    }


}
