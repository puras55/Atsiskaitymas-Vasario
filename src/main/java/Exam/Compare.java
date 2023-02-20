package Exam;


import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Compare {
    public void readComapare() throws IOException {

// nuskaitome vartotojo atsakymus iš failo
        String userAnswersString = FileUtils.readFileToString(new File("UserAnswers.json"), StandardCharsets.UTF_8);
        JSONArray userAnswers = new JSONArray(userAnswersString);

        //nuskaitome teisingus atsakymus iš failo
        String correctAnswersString = FileUtils.readFileToString(new File("answers.json"), StandardCharsets.UTF_8);
        JSONArray correctAnswers = new JSONArray(correctAnswersString);

//// palyginame vartotojo atsakymus su teisingais atsakymais
        int numQuestions = userAnswers.length();
        int numCorrect = 0;
        for (int i = 0; i < numQuestions; i++) {
            JSONObject userAnswer = userAnswers.getJSONObject(i);
            JSONObject correctAnswer = correctAnswers.getJSONObject(i);
            if (userAnswer.getString("userAnswer").equals(correctAnswer.getString("answer"))) {
                numCorrect++;
            }
        }
        System.out.println("Number of correct answers: " + numCorrect + " out of " + numQuestions);
    }

}