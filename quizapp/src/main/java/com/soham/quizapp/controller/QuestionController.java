package com.soham.quizapp.controller;


import com.soham.quizapp.model.Question;
import com.soham.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Long id){
        return questionService.deleteQuestion(id);
    }

    @PutMapping("updateQuestion")
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }
}
