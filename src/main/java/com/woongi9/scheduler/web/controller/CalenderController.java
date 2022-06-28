package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.service.posts.PostsService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/calender")
@RequiredArgsConstructor
@Log4j2
public class CalenderController {

    private final PostsService postsService;

    @GetMapping("/timesort")
    public void timeSort(){
    }

    @GetMapping("/prioritysort")
    public void prioritySort(){
    }
}
