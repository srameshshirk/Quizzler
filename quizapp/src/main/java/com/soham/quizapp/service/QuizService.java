package com.soham.quizapp.service;

import com.soham.quizapp.model.Question;
import com.soham.quizapp.model.QuestionWrapper;
import com.soham.quizapp.model.Quiz;
import com.soham.quizapp.dao.QuestionDao;
import com.soham.quizapp.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numberOfQuestions, String title) {

        List<Question> question = questionDao.findRandomQuestionsByCategory(category, numberOfQuestions);


        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestions(question);
        quizDao.save(quiz);

        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getAllQuizzes(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsfromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question question: questionsfromDb){
            QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
            questionsForUser.add(questionWrapper);

        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
