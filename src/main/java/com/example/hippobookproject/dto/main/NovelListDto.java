package com.example.hippobookproject.dto.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class NovelListDto {
   private String novelTitle;
   private String novelContent;
   private Long userId;
   private String userNickName;
}
