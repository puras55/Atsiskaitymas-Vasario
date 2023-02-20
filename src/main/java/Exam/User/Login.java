package Exam.User;


import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Login {
    public void login() {
        Scanner scanner = new Scanner(System.in);

        String usersJsonString = null;
        try {
            usersJsonString = FileUtils.readFileToString(new File("users.json"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Nepavyko nuskaityti vartotojų failo!");
            return;
        }

        JSONArray users = new JSONArray(usersJsonString);


        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Prisijungimas");
            System.out.println("Įveskite savo el. paštą:");
            String email = scanner.nextLine();
            System.out.println("Įveskite slaptažodį:");
            String password = scanner.nextLine();


            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                if (user.getString("email").equals(email) && user.getString("password").equals(password)) {
                    System.out.println("Sveiki atvykę, " + user.getString("firstName") + " " + user.getString("lastName") + "!");
                    loggedIn = true;
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("Neteisingi prisijungimo duomenys, bandykite dar kartą.");
            }
        }

        scanner.close();
    }
}
