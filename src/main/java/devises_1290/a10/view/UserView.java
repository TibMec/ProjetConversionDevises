package devises_1290.a10.view;

import devises_1290.a10.control.UserService;
import devises_1290.a10.dal.CurrencyDAO_JDBC;
import devises_1290.a10.dal.ICurrency_DAO;
import devises_1290.a10.dal.RateDAO_JDBC;

import java.nio.channels.ScatteringByteChannel;
import java.util.InputMismatchException;

import devises_1290.a10.model.*;

import java.util.Locale;
import java.util.Scanner;

public class UserView {
    UserService userService;
    String devise;
    int id;
    CurrencyDAO_JDBC cDAO_JDBC = new CurrencyDAO_JDBC();
    RateDAO_JDBC rDAO_JDBC = new RateDAO_JDBC();

    public UserView() {
        this.userService = new UserService(cDAO_JDBC, rDAO_JDBC);
        this.devise = "";
        this.id = 0;
    }

    Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public void convertView(){
        String source = "", destination = "";

        IO.println("Saisir le montant à convertir:");
        double montant = sc.nextDouble();
        sc.nextLine();

        IO.println("Choisir la devise de départ:");
         source = this.menu();

        IO.println("Saisir la devise d'arrivée:");
         destination = this.menu();

        double conversion = this.userService.convert(montant, source, destination);

        IO.println(String.format("%.2f %s vaut %.2f %s", montant, source, conversion, destination));
    }

    public void changeRate(){
        String source = "";
        double rateValue = 0.0;

        IO.println("Saisir la devise à modifier:");
        source = this.menu();
       int id = userService.getCurrencyByName(source)
                            .getId();
        IO.println("Saisir le nouveau taux pour cette devise:");
        rateValue= sc.nextDouble();
        boolean updated = rDAO_JDBC.updateRate(rateValue, id);
        IO.println(updated ?
                "Le taux a bien été mis à jour"
                : "Erreur dans la mise à jour"
                );
    }
    private String menu() {
        int choix = 0;
        while (true) {
            try {
                IO.println("Veuillez entrer votre choix (1-6):");
                choix = sc.nextInt();
                switch (choix) {
                    case 1:
                        devise = "US Dollar";
                        break;
                    case 2:
                        devise = "Euro";
                        break;
                    case 3:
                        devise = "British Pound";
                        break;
                    case 4:
                        devise = "Japanese Yen";
                        break;
                    case 5:
                        devise = "Canadian Dollar";
                        break;
                    case 6:
                        devise = "Australian Dollar";
                        break;
                    default:
                        IO.println("Veuillez saisir un entier parmi les options !");
    }
                    if ( choix < 1 && choix > 6) {
                        break;
                    }
} catch (InputMismatchException e) {
                    IO.println("Entrée non valide, veuillez entrer un choix valide !");
                    sc.next();
    }
}
   sc.close();
        return devise;
    }
}