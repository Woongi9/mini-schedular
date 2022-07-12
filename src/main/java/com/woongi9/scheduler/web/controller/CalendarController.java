package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.service.posts.PostsService;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@RequestMapping("/calendar")
@Log4j2
@RequiredArgsConstructor
@RestController
public class CalendarController {

    private final PostsService postsService;

    @GetMapping("/calendar/timesort")
    public void timeSort(){
    }

    @GetMapping("/calendar/prioritysort")
    public void  prioritySort(){
    }

    @GetMapping("/calendar/register")
    public void register() {
    }

    @PostMapping("/calendar/register")
    public Long register(@RequestBody PostsSaveRequestDTO postDTO) {
        log.info("postDTO : " + postDTO);
        return postsService.save(postDTO);
    }

    @GetMapping("/calendar/calendar")
    public void calendar() {
    }

    @GetMapping("/calendar/events")
    public void events(){
    }
}
