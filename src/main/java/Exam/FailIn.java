package Exam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class FailIn {



        private static String[] questions = {
                "Kas yra mėnulis?",
                "Kiek dienu turi vasario mėnesis?",
                "Koks yra didžiausias kūnas saulės sistemoje?",
                "Kas yra pirmasis žmogus kosmose?",
                "Koks elementas yra dažniausiai pasitaikantis Žemės plutosje?"
        };

        private static String[][] answers = {
                {"Paukštis", "Žuvis", "Žemės palydovas", "Krokodilas"},
                {"28", "29", "32", "33"},
                {"Saulė", "Merkurijus", "Jupiteris", "Saturnas"},
                {"Jurijus Gagarinas", "Neilas Armstrongas", "Buzz Aldrin", "Michael Collins"},
                {"Vandenilis", "Deguonis", "Anglis", "Geležis"}
        };

        private static JSONArray answersArray = new JSONArray();

       public void test() {


            Scanner scanner = new Scanner(System.in);
            int totalQuestions = questions.length;

            for (int i = 0; i < totalQuestions; i++) {
                System.out.println(questions[i]);
                for (int j = 0; j < answers[i].length; j++) {
                    System.out.println((j + 1) + ") " + answers[i][j]);
                }
                System.out.print("Įveskite atsakymą (1-" + answers[i].length + "): ");
                int userAnswer = scanner.nextInt();

                JSONObject answerObj = new JSONObject();
                answerObj.put("question", questions[i]);
                answerObj.put("userAnswer", answers[i][userAnswer - 1]);
                answersArray.put(answerObj);
            }

            // Įrašome atsakymus į failą
            try (FileWriter file = new FileWriter("UserAnswers.json")) {
                file.write(answersArray.toString());
                System.out.println("Jūsų atsakymai įrašyti į Useranswers.json failą.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            scanner.close();


        }

    }
