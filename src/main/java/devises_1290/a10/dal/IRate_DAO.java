package devises_1290.a10.dal;

import devises_1290.a10.model.Rate;

public interface IRate_DAO {
    boolean updateRate(double rateValue, int id);
    Rate getRateByCurrencyName(String name);
}
