package devises_1290.a10.dal;

import devises_1290.a10.data.EntityManagerProvider;
import devises_1290.a10.model.Rate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RateDAO_JPA implements IRate_DAO {
    EntityManager em = null;

    public RateDAO_JPA() {
        this.em = EntityManagerProvider.getInstance().getEntityManager();
    }

    @Override
    public boolean updateRate(double rateValue, int id) {
        boolean updated = false;

        try {
            EntityTransaction transaction = this.em.getTransaction();
            transaction.begin();
            Rate r = this.em.find(Rate.class, id);
            r.setValue(rateValue);
            this.em.merge(r);
            transaction.commit();
            updated = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        try {
            return em.createNamedQuery("Rate.findRateByCurrencyName", Rate.class).setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
