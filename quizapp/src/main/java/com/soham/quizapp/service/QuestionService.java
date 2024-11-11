package com.soham.quizapp.service;


import com.soham.quizapp.model.Question;
import com.soham.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    // to call the methods
    // using we can fire a method

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK); // this gives the list of question
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategoryIgnoreCase(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question); // this saves the question
        return new ResponseEntity<>("Question added successfully",HttpStatus.CREATED);
    }

    public String deleteQuestion(Long id) {
        questionDao.deleteById(id); // this deletes the question
        return "Question deleted successfully";
    }

    public String updateQuestion(Question question) {
        questionDao.save(question); // this updates the question
        return "Question updated successfully";
    }
}
