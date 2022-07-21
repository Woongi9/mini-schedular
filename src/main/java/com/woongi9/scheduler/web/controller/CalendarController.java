package com.woongi9.scheduler.web.controller;

import com.woongi9.scheduler.domain.user.User;
import com.woongi9.scheduler.domain.user.UserRepository;
import com.woongi9.scheduler.service.posts.PostsService;
import com.woongi9.scheduler.web.dto.PageRequestDTO;
import com.woongi9.scheduler.web.dto.PostsResponseDTO;
import com.woongi9.scheduler.web.dto.PostsSaveRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/calendar")
@Log4j2
@RequiredArgsConstructor
@Controller
//@RestController
public class CalendarController {

    private final UserRepository userRepository;
    private final PostsService postsService;

    @GetMapping("/timesort")
    public void timeSort(Model model,
                         Principal principal){
        List<PostsResponseDTO> prevPosts = postsService.findTimesortPage();

        //user = email 찾기
        String name = principal.getName();
        log.info("principal name : " + name);

        List<PostsResponseDTO> timePosts = new ArrayList<>();

        for (PostsResponseDTO postDTO : prevPosts) {
            log.info("postDTO Name :" + postDTO.getName());
            if (name.equals(postDTO.getName()))
                timePosts.add(postDTO);
        }

        log.info("find TimeSort List : " + timePosts);
        model.addAttribute("result", timePosts);
    }

    @GetMapping("/prioritysort")
    public void prioritySort(Model model,
                             Principal principal){
        List<PostsResponseDTO> prevPosts = postsService.findTimesortPage();

        //user = email 찾기
        String name = principal.getName();
        log.info("principal name : " + name);

        List<PostsResponseDTO> priorityPosts = new ArrayList<>();

        for (PostsResponseDTO postDTO : prevPosts) {
            log.info("postDTO Name :" + postDTO.getName());
            if (name.equals(postDTO.getName()))
                priorityPosts.add(postDTO);
        }

        log.info("find TimeSort List : " + priorityPosts);
        model.addAttribute("result", priorityPosts);
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("postsSaveRequestDTO", new PostsSaveRequestDTO());

        return "/calendar/register";
    }

    @PostMapping("/register")
    public String  register(@RequestBody PostsSaveRequestDTO postDTO,
                            RedirectAttributes redirectAttributes,
                            Principal principal) {
        log.info("postDTO : " + postDTO);

        postDTO.setName(principal.getName());

        Long pno = postsService.save(postDTO);

        log.info("PNO : " + pno);

        redirectAttributes.addFlashAttribute("msg", pno);

        return "redirect:/";
    }

    @GetMapping("/read")
    public void read(long pno,
                     Model model) {
        log.info("read pno : " + pno);

        PostsResponseDTO postDTO = postsService.findById(pno);

        model.addAttribute("dto", postDTO);
    }

    @GetMapping("/update")
    public void update(long pno,
                     Model model) {
        log.info("update pno : " + pno);

        PostsResponseDTO postDTO = postsService.findById(pno);

        model.addAttribute("dto", postDTO);
    }

    @PostMapping("/update")
    public void update(@RequestBody PostsSaveRequestDTO postDTO, RedirectAttributes redirectAttributes) {

    }

    @GetMapping("/calendar")
    public void calendar() {
    }

    @GetMapping("/events")
    public void events(){
    }
}
