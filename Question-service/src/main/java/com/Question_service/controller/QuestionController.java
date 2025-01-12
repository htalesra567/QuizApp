package com.Question_service.controller;

import com.Question_service.Model.QuestionDto;
import com.Question_service.Model.QuestionWrapper;
import com.Question_service.Model.Response;
import com.Question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("/allQuestion")
    public ResponseEntity<List<QuestionDto>> allQuestion(){
        return questionService.fetchAllQuestion();
    }

    @GetMapping("/questionByCategory/{category}")
    public ResponseEntity<List<QuestionDto>> questionByCategory(@PathVariable("category") String category){
        return questionService.questionByCategory(category);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Boolean> addQuestion(@RequestBody QuestionDto questionDto){
        return questionService.addQuestion(questionDto);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName,@RequestParam Integer numQuestions){
        return questionService.getQuestionForQuiz(categoryName,numQuestions);
    }

    @PostMapping("/getQuestion")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionFromId(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return  questionService.getScore(responses);
    }
}
