package devises_1290.a10.dal;

import devises_1290.a10.model.Rate;

public class RateDAO_JPA implements IRate_DAO {


    @Override
    public boolean updateRate(double rateValue, int id) {
        return false;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        return null;
    }


}
