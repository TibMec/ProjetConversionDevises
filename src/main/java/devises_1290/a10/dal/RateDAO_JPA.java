package devises_1290.a10.dal;

import devises_1290.a10.data.EntityManagerProvider;
import devises_1290.a10.model.Rate;
import jakarta.persistence.EntityManager;

public class RateDAO_JPA implements IRate_DAO {
    EntityManager em = null;

    public RateDAO_JPA(EntityManager em) {
        this.em = EntityManagerProvider.getInstance().getEntityManager();
    }

    @Override
    public boolean updateRate(double rateValue, int id) {
        return false;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        return null;
    }


}
