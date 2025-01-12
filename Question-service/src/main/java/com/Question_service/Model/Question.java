package com.Question_service.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "category")
    private String category;
    @Column(name = "difficulty_level")
    private String difficulty_level;
    @Column(name = "option1")
    private String option1;
    @Column(name = "option2")
    private String option2;
    @Column(name = "option3")
    private String option3;
    @Column(name = "option4")
    private String option4;
    @Column(name = "question_title")
    private String question_title;
    @Column(name = "right_answer")
    private String right_answer;

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public String getOption4() {
        return option4;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public Question(String difficulty_level, String category, int id, String option1, String option2, String option3, String option4, String question_title, String right_answer) {
        this.difficulty_level = difficulty_level;
        this.category = category;
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.question_title = question_title;
        this.right_answer = right_answer;
    }

    public Question() {

    }
}
