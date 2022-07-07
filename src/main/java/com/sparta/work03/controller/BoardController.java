package com.sparta.work03.controller;

import com.sparta.work03.domain.Board;
import com.sparta.work03.domain.BoardRepository;
import com.sparta.work03.domain.BoardRequestDto;
import com.sparta.work03.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/boards") // 전체 게시글 목록 조회
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/boards/create") // 게시글 작성
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards/{id}") // 게시글 조회
    public Optional<Board> getBoard(@PathVariable Long id){
        return boardRepository.findById(id);
    }

    @PutMapping("/api/boards/{id}") // 게시글 수정
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        boardService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/boards/{id}") // 게시글 삭제
    public Long deleteMemo(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!board.getPassword().equals(requestDto.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        boardRepository.deleteById(id);
        return id;
    }
}
