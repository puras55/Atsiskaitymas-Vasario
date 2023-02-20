package Exam;

import Exam.User.Login;
import Exam.User.Registracija;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPasirinkite vieną iš meniu punktų:\n");

        Menu menu = new Menu();
        Registracija registration = new Registracija();
        Login login = new Login();
        FailIn testProgram = new FailIn();
        Compare compare = new Compare();

        String menuAction;
        try {

            do {
                menu.menu();
                menuAction = String.valueOf(scanner.nextInt());

                menu.selectmenuAction(menuAction, registration, testProgram, compare, login);
            } while (!menuAction.equals("5"));
        } catch (NoSuchElementException e) {
            System.out.println("Testo pabaiga");
        }
    }

    private void selectmenuAction(String menuAction, Registracija registration, FailIn testProgram, Compare compare, Login Login) throws IOException {
        switch (menuAction) {
            case "1" -> registration.registarcija();
            case "2" -> Login.login();
            case "3" -> testProgram.test();
            case "4" -> compare.readComapare();
            case "5" -> System.out.println("Programa baigia darbą");
            default -> System.out.println("Šis veiksmas nėra numatytas.");
        }
    }

    private void menu() {
        System.out.println("""
                1. - Registracija
                2. - Prisijungimas
                3. - Pradėti testas
                4. - Testo Rezultatai
                5. - Išeiti  
                """);


    }


}

