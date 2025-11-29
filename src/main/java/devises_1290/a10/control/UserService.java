package devises_1290.a10.control;

import devises_1290.a10.dal.IRate_DAO;
import devises_1290.a10.model.Rate;

public class UserService {
    IRate_DAO rateDAO;

    public UserService(IRate_DAO rateDAO) {
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

    public boolean changeRate(String source, double rateValue){
        boolean updated = false;
        Rate rSource = rateDAO.getRateByCurrencyName(source);
        int id = rSource.getId();
        updated = rateDAO.updateRate(rateValue, id);
        return updated ;
    }

}
