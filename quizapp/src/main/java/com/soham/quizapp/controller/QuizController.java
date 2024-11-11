package com.soham.quizapp.controller;


import com.soham.quizapp.model.QuestionWrapper;
import com.soham.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numberOfQuestions, @RequestParam String title) {
        return quizService.createQuiz(category, numberOfQuestions, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getAllQuizzes(@PathVariable Integer id) {
        return quizService.getAllQuizzes(id);
    }
}
