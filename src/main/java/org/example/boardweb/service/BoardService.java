package org.example.boardweb.service;

import lombok.RequiredArgsConstructor;
import org.example.boardweb.domain.Board;
import org.example.boardweb.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Iterable<Board> findAll() {
        return boardRepository.findAll();
    }

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }
}
