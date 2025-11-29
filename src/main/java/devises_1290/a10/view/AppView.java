package devises_1290.a10.view;

import devises_1290.a10.dal.*;
import devises_1290.a10.data.MockDB;
import devises_1290.a10.model.Rate;

public class AppView {
    public static  void main(String args[]) {
       MockDB mockDB= MockDB.getInstance();

       /* Pour data via MockDB */
        UserViewConsole userViewConsole = new UserViewConsole(new RateDAO_MockDB());

       /* Pour data via connexion JDBC */
//        UserViewConsole userViewConsole = new UserViewConsole(new RateDAO_JDBC());

       /* Pour data via connexion JPA */
//        UserViewConsole userViewConsole = new UserViewConsole(new RateDAO_JPA());

        userViewConsole.operationMenu();

        /* Verifier que les taux ont bien changé dans le MockDB */
        for (Rate r: mockDB
             .getRates()){
             System.out.println(r);
        }
    }
}
