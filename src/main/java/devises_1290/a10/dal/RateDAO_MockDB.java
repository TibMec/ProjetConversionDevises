package devises_1290.a10.dal;

import devises_1290.a10.data.MockDB;
import devises_1290.a10.model.Currency;
import devises_1290.a10.model.Rate;

public class RateDAO_MockDB implements IRate_DAO {
    MockDB datastore;

    public RateDAO_MockDB() {
        this.datastore = MockDB.getInstance();
    }


    @Override
    public boolean updateRate(double rateValue, int id) {
        boolean updated = false;
        datastore.getRates();
        for(Rate r : datastore.getRates()){
            if(r.getId() == id){
                r.setValue(rateValue);
                System.out.println("Rate updated: " + rateValue);
                updated = true;
            }
        }
        return updated;
    }

    @Override
    public Rate getRateByCurrencyName(String name) {
        datastore.getCurrencies();
        datastore.getRates();
        Rate rate = null;
        int rate_id = 0;
        for(Currency c : datastore.getCurrencies()){
            if(c.getName().equals(name) ){
                rate_id = c.getId();
                for(Rate r : datastore.getRates()){
                    if(r.getId() == rate_id){
                        rate = r;
                    }
                }
            }
        }
        return rate;
    }

}
