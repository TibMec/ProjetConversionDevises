package devises_1290.a10.view;

import devises_1290.a10.control.UserService;
import devises_1290.a10.dal.ICurrency_DAO;
import devises_1290.a10.dal.IRate_DAO;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class UserViewConsole {
    UserService userService;
    String devise;
    int id;
    ICurrency_DAO cDAO;
    IRate_DAO rDAO;

    public UserViewConsole(ICurrency_DAO currDAO, IRate_DAO rateDAO) {
        this.userService = new UserService(currDAO, rateDAO);
        this.devise = "";
        this.id = 0;
    }

    Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public void operationMenu() {
        int choix = 0;
        while (true) {
            IO.println("""
                    Choisissez une option:    
                        1. Mettre à jour la devise
                        2. Convertir un montant
                        Autre chiffre pour quitter
                    """);
            try {
                choix = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erreur ! Entier attendu");
                sc.nextLine();
            }
            if (choix == 1)
                changeRateView();
            else if (choix == 2)
                convertView();
            else {
                System.out.println("Fin de programme");
                return;
            }
        }
    }

    public void convertView() {
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

    public void changeRateView() {
        String source = "";
        double rateValue = 0.0;

        IO.println("Saisir la devise à modifier:");
        source = this.menu();
        int id = userService.getCurrencyByName(source)
                .getId();
        IO.println("Saisir le nouveau taux pour cette devise:");
        rateValue = sc.nextDouble();
        boolean updated = userService.changeRate(source, rateValue);
        IO.println(updated ?
                "Le taux a bien été mis à jour"
                : "Erreur dans la mise à jour"
        );
    }

    public String menu() {
        IO.println("""
                    1. US Dollar
                    2. Euro
                    3. British Pound
                    4. Japanese Yen
                    5. Canadian Dollar
                    6. Australian Dollar
                """);
        int choix = sc.nextInt();
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
                devise = "Canadian Dollar";
        }
        return devise;
    }

}
