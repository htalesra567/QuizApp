package com.Quiz_service.service;

import com.Quiz_service.Model.QuestionWrapper;
import com.Quiz_service.Model.Quiz;
import com.Quiz_service.Model.Response;
import com.Quiz_service.feign.QuizInterface;
import com.Quiz_service.repo.QuizRepo;
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
        QuizRepo quizRepo;

        @Autowired
    QuizInterface quizInterface;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizInterface.getQuestionForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepo.save(quiz);

    return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity< List<QuestionWrapper>> questionForUser =quizInterface.getQuestionFromId(questionIds);


        return questionForUser;
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {

        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
