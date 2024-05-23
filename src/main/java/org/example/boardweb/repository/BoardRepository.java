package org.example.boardweb.repository;

import org.example.boardweb.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
