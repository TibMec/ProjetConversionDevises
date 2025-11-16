package devises_1290.a10.dal;

import devises_1290.a10.model.Rate;

import devises_1290.a10.model.Currency;
import java.util.List;

public interface ICurrency_DAO {
    Currency getCurrencyByName(String name);
//    Rate findAssociatedRate();

}
