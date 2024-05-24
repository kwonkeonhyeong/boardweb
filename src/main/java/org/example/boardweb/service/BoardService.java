package org.example.boardweb.service;

import lombok.RequiredArgsConstructor;
import org.example.boardweb.domain.Board;
import org.example.boardweb.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<Board> findAll(Pageable pageable) {
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Direction.DESC, "id"));
        return boardRepository.findAll(sortedByDescId);
    }

    @Transactional(readOnly = true)
    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    
}
