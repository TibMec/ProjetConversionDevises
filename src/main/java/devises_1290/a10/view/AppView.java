package devises_1290.a10.view;

import devises_1290.a10.dal.*;
import devises_1290.a10.data.MockDB;
import devises_1290.a10.model.Rate;

public class AppView {
    public static  void main(String args[]) {
       MockDB mockDB= MockDB.getInstance();
//        UserView userView = new UserView(new CurrencyDAO_JDBC(), new RateDAO_JDBC());
        UserView userView = new UserView(new CurrencyDAO_MockDB(), new RateDAO_MockDB());
//        UserView userView = new UserView(new CurrencyDAO_JPA(), new RateDAO_JPA());
        userView.operationMenu();

        for (Rate r: mockDB
                .getRates()){
            System.out.println(r);
        }
    }
}
