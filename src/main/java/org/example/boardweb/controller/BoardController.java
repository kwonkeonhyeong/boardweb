package org.example.boardweb.controller;

import lombok.RequiredArgsConstructor;
import org.example.boardweb.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String showBoardList(Model model) {
        model.addAttribute("boardList",boardService.findAll());
        return "boards/list";
    }
}
