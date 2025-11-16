package devises_1290.a10.dal;

import devises_1290.a10.data.MockDB;
import devises_1290.a10.model.Currency;
import java.util.List;

public class CurrencyDAO_MockDB implements ICurrency_DAO {
    MockDB datastore;

    public CurrencyDAO_MockDB() {
        this.datastore = MockDB.getInstance();
    }

    @Override
    public Currency getCurrencyByName(String name) {
        List<Currency> currencies = datastore.getCurrencies();
        for (Currency currency : currencies) {
            if (currency.getName().equalsIgnoreCase(name)) {
                return currency;
            }
        }
        return null;
    }
}
