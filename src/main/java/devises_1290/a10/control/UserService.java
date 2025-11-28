package devises_1290.a10.control;

import devises_1290.a10.dal.ICurrency_DAO;
import devises_1290.a10.dal.IRate_DAO;
import devises_1290.a10.model.Currency;
import devises_1290.a10.model.Rate;

public class UserService {
    ICurrency_DAO currDAO;
    IRate_DAO rateDAO;

    public UserService(ICurrency_DAO currDAO, IRate_DAO rateDAO) {
        this.currDAO = currDAO;
        this.rateDAO = rateDAO;
    }

    public double convert(double montant, String source, String destination) {
        double result = (double)0.0F;
        Rate rSource = this.rateDAO.getRateByCurrencyName(source);
        Rate rDestination = this.rateDAO.getRateByCurrencyName(destination);
        result = montant * (rDestination.getValue() / rSource.getValue());
        return result;
    }

    public Currency getCurrencyByName(String name) {
        return this.currDAO.getCurrencyByName(name);
    }

    public Rate getRateByName(String currencyName) {
        return this.rateDAO.getRateByCurrencyName(currencyName);
    }

    public boolean changeRate(String source, double rateValue) {
        boolean updated = false;
        Rate rSource = this.rateDAO.getRateByCurrencyName(source);
        int id = rSource.getId();
        updated = this.rateDAO.updateRate(rateValue, id);
        return updated;
    }
}
