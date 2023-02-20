package Exam.User;

import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;

import java.io.FileWriter;


public class Registracija {

    public void registarcija() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Vardas: ");
        String firstName = scanner.nextLine();

        System.out.print("Pavardė: ");
        String lastName = scanner.nextLine();

        System.out.print("E-paštas: ");
        String email = scanner.nextLine();

        System.out.print("Slaptažodis: ");
        String password = scanner.nextLine();

        scanner.close();


        JSONObject user = new JSONObject();
        user.put("vardas", firstName);
        user.put("pavarde", lastName);
        user.put("epastas", email);
        user.put("slaptazodis", password);

        try (FileWriter file = new FileWriter("users.json")) {
            file.write(user.toString());
            System.out.println("Vartotojo duomenys išsaugoti į users.json failą");
        } catch (IOException e) {
            System.out.println("Klaida įrašant vartotojo duomenis į failą: " + e.getMessage());
        }
    }
}

