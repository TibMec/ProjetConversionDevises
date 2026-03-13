package devises_1290.a10.data;

import devises_1290.a10.model.*;
import java.util.ArrayList;
import java.util.List;

public class MockDB {
    private static MockDB instance;
    private List<Currency> currencies;
    private List<Rate> rates;

    public MockDB() {
        seed_data();
    }

    private void seed_data() {
        this.currencies = new ArrayList<Currency>();
        this.rates = new ArrayList<Rate>();

        currencies.add(new Currency(1, "US Dollar", "United States"));
        currencies.add(new Currency(2, "Euro", "European Union"));
        currencies.add(new Currency(3, "British Pound", "United Kingdom"));
        currencies.add(new Currency(4, "Japanese Yen", "Japan"));
        currencies.add(new Currency(5, "Canadian Dollar", "Canada"));
        currencies.add(new Currency(6, "Australian Dollar", "Australia"));

        rates.add(new Rate(1, 1.0000));
        rates.add(new Rate(2, 0.8602));
        rates.add(new Rate(3, 0.7593));
        rates.add(new Rate(4, 154.4930));
        rates.add(new Rate(5, 1.4020));
        rates.add(new Rate(6, 1.5400));
    }

    public static MockDB getInstance() {
        if (MockDB.instance == null) {
            MockDB.instance = new MockDB();
        }
        return MockDB.instance;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Rate> getRates() {
        return rates;
    }

}
