package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.service.posts.PostsService;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/calendar")
@Log4j2
@RequiredArgsConstructor
@Controller
//@RestController
public class CalendarController {

    private final PostsService postsService;

    @GetMapping("/timesort")
    public void timeSort(){
    }

    @GetMapping("/prioritysort")
    public void  prioritySort(){
    }

    //Test -> O, html -> X
//    @GetMapping("/register")
//    public void register() {
//    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("postsSaveRequestDTO", new PostsSaveRequestDTO());
        return "/calendar/register";
    }

    @PostMapping("/register")
    public String  register(@RequestBody PostsSaveRequestDTO postDTO, RedirectAttributes redirectAttributes) {
        log.info("postDTO : " + postDTO);

        Long pno = postsService.save(postDTO);

        log.info("PNO : " + pno);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/";
    }

    @GetMapping("/calendar")
    public void calendar() {
    }

    @GetMapping("/events")
    public void events(){
    }
}
