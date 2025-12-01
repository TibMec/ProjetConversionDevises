package devises_1290.a10.control;

import devises_1290.a10.dal.ICurrency_DAO;
import devises_1290.a10.dal.IRate_DAO;
import devises_1290.a10.model.Rate;

public class UserService {
    ICurrency_DAO currDAO;
    IRate_DAO rateDAO;

    // Pour le UserViewConsole
    public UserService(IRate_DAO rateDAO) {
        this.rateDAO = rateDAO;
    }

    // Pour le UserViewGraphique
    public UserService(ICurrency_DAO currDAO, IRate_DAO rateDAO) {
        this.currDAO = currDAO;
        this.rateDAO = rateDAO;
    }

    // Conversion = montant * (destination / source), ref USD
    public double convert(double montant, String source, String destination){
        double result = 0;
        Rate rSource = rateDAO.getRateByCurrencyName(source);
        Rate rDestination = rateDAO.getRateByCurrencyName(destination);
        result = montant * (rDestination.getValue() / rSource.getValue());
        return result;
    }

    public Rate getRateByCurrencyName(String currencyName) {
        return this.rateDAO.getRateByCurrencyName(currencyName);
    }

    public boolean changeRate(String source, double rateValue){
        boolean updated = false;
        Rate rSource = rateDAO.getRateByCurrencyName(source);
        int id = rSource.getId();
        updated = rateDAO.updateRate(rateValue, id);
        return updated ;
    }
}
