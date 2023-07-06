package com.company.summative_one.Controllers;

import com.company.summative_one.Models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class Magic8Controller {

    List<Answer> questAndAnswers;// not needed for the assignment but helpful for checking question history with GET
    private static int idCounter = 1;
    public Magic8Controller(){
        questAndAnswers = new ArrayList<>();

    }
    List<String> magicBallAnswers = Arrays.asList( // random answer pool
            "Yes.","No.","Perhaps.",
            "Try asking me again.",
            "For once, I don't know.",
            "Ask another magic 8 ball."
    );


    // POST
    // URI: /magic
    // Request Body: Answer obj
    // Response Body: Answer obj
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer formNewQuestionAndAnswer(@RequestBody Answer newQuestion) {
        newQuestion.setId(idCounter++);
        questAndAnswers.add(newQuestion);

        // Choosing an answer from the pool
        Random random = new Random();
        int index = random.nextInt(magicBallAnswers.size());

        // Set the answer
        newQuestion.setAnswer(magicBallAnswers.get(index));

        return newQuestion;
    }

    // GET /magic returns all asked questions (not a part of the assignment)
    @RequestMapping(value = "/magic", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Answer> returnAllAskedQuestions(){
        return questAndAnswers;
    }
}
