package org.example.boardweb.controller;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.boardweb.domain.Board;
import org.example.boardweb.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String showBoardList(
            Model model,
            @RequestParam(name="page",defaultValue = "1") int page,
            @RequestParam(name="size",defaultValue = "5") int size
            ) {
        Pageable pageable = PageRequest.of(page - 1, size);
        model.addAttribute("boardList",boardService.findAll(pageable));
        model.addAttribute("currentPage",page);
        return "boards/list";
    }

    @GetMapping("/writeform")
    public String addForm(Model model) {
        model.addAttribute("board", new Board());
        return "boards/writeform";
    }

    @PostMapping("/write")
    public String addBoard(@ModelAttribute Board board, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message","등록완료");
        board.setCreated_at(LocalDateTime.now());
        boardService.save(board);
        return "redirect:/boards/list";
    }
}
