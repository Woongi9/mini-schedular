package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.service.posts.PostsService;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calendar")
@RequiredArgsConstructor
@Log4j2
public class CalendarController {

    private final PostsService postsService;

    @GetMapping("/timesort")
    public void timeSort(){
    }

    @GetMapping("/prioritysort")
    public void prioritySort(){
    }

    @GetMapping("/register")
    public String  register(Model model) {
        model.addAttribute("postDTO", new PostsSaveRequestDTO());
        return "/register";
    }

    @PostMapping("/register")
    public String register()

    @GetMapping("/calendar")
    public void calendar() {

    }

    @GetMapping("/events")
    public void events(){
    }
}
