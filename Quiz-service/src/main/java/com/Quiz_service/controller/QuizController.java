package com.Quiz_service.controller;


import com.Quiz_service.Model.QuestionWrapper;
import com.Quiz_service.Model.QuizDto;
import com.Quiz_service.Model.Response;
import com.Quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

        @Autowired
        QuizService quizService;

        @PostMapping("/create")
        public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto ){
                return quizService.createQuiz(quizDto.getCategoryname(),quizDto.getNumQuestions(),quizDto.getTitle());
        }

        @GetMapping("get/{id}")
        public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
                return quizService.getQuizQuestion(id);
        }

        @PostMapping("submit/{id}")
        public ResponseEntity<Integer> submitQuiz(@PathVariable ("id") int id,@RequestBody List<Response> responses){
                return quizService.calculateResult(id,responses);
        }
}
