package com.Question_service.service;


import com.Question_service.Model.Question;
import com.Question_service.Model.QuestionDto;
import com.Question_service.Model.QuestionWrapper;
import com.Question_service.Model.Response;
import com.Question_service.repo.QuestionRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<QuestionDto>> fetchAllQuestion(){
         List<Question> list = questionRepo.findAll();
         List<QuestionDto> finalList = new ArrayList<>();
try{
         for(Question question : list){
             QuestionDto questionDto = new QuestionDto();
             BeanUtils.copyProperties(question,questionDto);
             finalList.add(questionDto);
         }

        return new ResponseEntity<>(finalList, HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
    }
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionDto>> questionByCategory(String category) {
        List<Question> list = questionRepo.findByCategory(category);
        List<QuestionDto> finalList = new ArrayList<>();
        try {
            for (Question question : list) {
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(question, questionDto);
                finalList.add(questionDto);
            }
            return new ResponseEntity<>(finalList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Boolean> addQuestion(QuestionDto questionDto) {

            Question question = new Question();
            BeanUtils.copyProperties(questionDto, question);
            questionRepo.save(question);


        return new ResponseEntity<>(true,HttpStatus.CREATED);
    }



    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numQuestions) {
        List<Integer>  questions = questionRepo.findRandomQuestionByCategory(categoryName,numQuestions);
        return  new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {

        List<QuestionWrapper> wrapper = new ArrayList<>();
        List<Question> question = new ArrayList<>();

        for(Integer id: questionIds){
            question.add(questionRepo.findById(id).get());
        }

        for(Question q : question){
            QuestionWrapper questionWrapper = new QuestionWrapper();
            questionWrapper.setId(q.getId());
            questionWrapper.setQuestion_title(q.getQuestion_title());
            questionWrapper.setOption1(q.getOption1());
            questionWrapper.setOption2(q.getOption2());
            questionWrapper.setOption3(q.getOption3());
            questionWrapper.setOption4(q.getOption4());
            wrapper.add(questionWrapper);
        }
        return new ResponseEntity<>(wrapper,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int right=0;

        for(Response response:responses){
            Question question = questionRepo.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRight_answer())){
                right++;
            }
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
