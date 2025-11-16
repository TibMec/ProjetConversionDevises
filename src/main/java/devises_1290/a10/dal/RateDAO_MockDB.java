package devises_1290.a10.dal;

import devises_1290.a10.data.MockDB;
import devises_1290.a10.model.Rate;

public class RateDAO_MockDB implements IRate_DAO {
    MockDB datastore;

    public RateDAO_MockDB() {
        this.datastore = MockDB.getInstance();
    }

    @Override
    public boolean addRate(Rate rate) {
        datastore.getRates()
                .add(rate);
        return false;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        return null;
    }

}
