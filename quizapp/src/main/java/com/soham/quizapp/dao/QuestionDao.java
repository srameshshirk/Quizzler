package com.soham.quizapp.dao;

import com.soham.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    List<Question> findByCategoryIgnoreCase(String category);

    @Query(value = "Select * from question q where q.category=:category Order by random() limit :numberOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numberOfQuestions);

    //List<Question> findByCategory(String category);
}
