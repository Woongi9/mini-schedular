package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.service.posts.PostsService;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public void register(){
    }

    @PostMapping("/register")
    public String register(PostsSaveRequestDTO postDTO, RedirectAttributes redirectAttributes) {

        log.info("postDTO : " + postDTO);

        Long pno = postsService.save(postDTO);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/calendar/calendar";
    }
//    @PostMapping("/register")
//    public String register(@ModelAttribute("posts") @Valid PostsSaveRequestDTO postDTO) {
//
//        postsService.save(postDTO);
//
//        return "redirect:/calendar/calendar";
//    }

    @GetMapping("/calendar")
    public void calendar() {
    }

    @GetMapping("/events")
    public void events(){
    }
}
