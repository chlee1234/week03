package com.sparta.work03.domain;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;
}
