package com.soham.quizapp.dao;

import com.soham.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuizDao extends JpaRepository<Quiz, Integer> {
    // List<Quiz> findByCategoryIgnoreCase(String category);

}
