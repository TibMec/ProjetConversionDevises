package devises_1290.a10.control;

import devises_1290.a10.dal.CurrencyDAO_JDBC;
import devises_1290.a10.dal.ICurrency_DAO;
import devises_1290.a10.dal.IRate_DAO;
import devises_1290.a10.dal.RateDAO_JDBC;
import devises_1290.a10.model.Currency;
import devises_1290.a10.model.Rate;

public class UserService {
    ICurrency_DAO cDaoJDBC = new CurrencyDAO_JDBC();
    IRate_DAO rDaoJDBC = new RateDAO_JDBC();

    public UserService(ICurrency_DAO cDaoJDBC, IRate_DAO rDaoJDBC) {
        this.cDaoJDBC = cDaoJDBC;
        this.rDaoJDBC = rDaoJDBC;
    }

    // Conversion = montant * (destination / source), ref USD
    public double convert(double montant, String source, String destination){
        double result = 0;
        Rate rSource = rDaoJDBC.getRateByCurrencyName(source);
        Rate rDestination = rDaoJDBC.getRateByCurrencyName(destination);
        result = montant * (rDestination.getValue() / rSource.getValue());
        return result;
    }

    //A changer pour le Rate, retourne le getRateByName
    public Currency getCurrencyByName(String name){
        Currency curr = cDaoJDBC.getCurrencyByName(name);
        return curr;
    }

    public boolean updateRate(String source,double rateValue){
        boolean updated = false;
        Rate rSource = rDaoJDBC.getRateByCurrencyName(source);
        int id = rSource.getId();
        rDaoJDBC.updateRate(rateValue, id);
        return updated;
    }

}
