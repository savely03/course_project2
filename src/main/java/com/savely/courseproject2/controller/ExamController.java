package com.savely.courseproject2.controller;


import com.savely.courseproject2.model.Question;
import com.savely.courseproject2.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/examiner")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getJavaQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }

}
