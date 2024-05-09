package com.example.hippobookproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class UserJoinDto {
    private Long joinId;
    private String joinLoginId;
    private String joinPassword;
}
