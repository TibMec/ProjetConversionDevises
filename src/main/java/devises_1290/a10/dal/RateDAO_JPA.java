package devises_1290.a10.dal;

import devises_1290.a10.data.EntityManagerProvider;
import devises_1290.a10.model.Currency;
import devises_1290.a10.model.Rate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class RateDAO_JPA implements IRate_DAO {
    EntityManager em = null;

    public RateDAO_JPA() {
        this.em = EntityManagerProvider.getInstance().getEntityManager();
    }

    @Override
    public boolean updateRate(double rateValue, int id) {
        boolean updated = false;
        TypedQuery<Rate> query;

        try {
            EntityTransaction transaction = this.em.getTransaction();
            Rate r = this.em.find(Rate.class, id);
            r.setValue(rateValue);
            transaction.commit();
            this.em.merge(r);
            if (em.find(Rate.class, id).getValue() == rateValue) {
                updated = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return updated;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        TypedQuery<Rate> query = this.em.createQuery(SQL_BOX.FIND_RATE_BY_CURRENCY_NAME, Rate.class);
        query.setParameter("name", name);
        int d = query.executeUpdate();
        System.out.println("lignes changees "+d);
        return query.getSingleResult();
    }


}
