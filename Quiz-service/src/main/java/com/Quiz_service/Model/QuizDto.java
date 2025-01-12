package com.Quiz_service.Model;

public class QuizDto {
    String categoryname;
    Integer numQuestions;
    String title;
    public QuizDto() {

    }

    public QuizDto(String categoryname, Integer numQuestions, String title) {
        this.categoryname = categoryname;
        this.numQuestions = numQuestions;
        this.title = title;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(Integer numQuestions) {
        this.numQuestions = numQuestions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
