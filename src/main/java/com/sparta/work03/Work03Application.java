package com.sparta.work03;

import com.sparta.work03.domain.Board;
import com.sparta.work03.domain.BoardRepository;
import com.sparta.work03.domain.BoardRequestDto;
import com.sparta.work03.service.BoardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing // 수정일자가 스프링에 반영 -> 날짜가 자동으로 업데이트
@SpringBootApplication
public class Work03Application {

    public static void main(String[] args) {
        SpringApplication.run(Work03Application.class, args);
    }

}


