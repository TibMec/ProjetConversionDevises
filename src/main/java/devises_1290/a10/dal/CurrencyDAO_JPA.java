package devises_1290.a10.dal;

import devises_1290.a10.data.EntityManagerProvider;
import devises_1290.a10.model.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CurrencyDAO_JPA implements ICurrency_DAO {
    EntityManager em = null;

    public CurrencyDAO_JPA() {
        this.em = EntityManagerProvider.getInstance().getEntityManager();
    }

    @Override
    public Currency getCurrencyByName(String name) {
        TypedQuery<Currency> query = this.em.createQuery(SQL_BOX.FIND_CURRENCY_BY_NAME_JPA, Currency.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    //Pour Test, a enlever
    public Currency findById(int id){
        return this.em.find(Currency.class, id);
    }
    //Pour Test, a enlever
//    public Currency findAll(int id){
//        return this.em.createQuery("");
//    }
}
