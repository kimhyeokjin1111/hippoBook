package com.example.hippobookproject.dto.feed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter @ToString
@NoArgsConstructor
public class CardDto {
    private Long feedId;
    private Long userId;
    private Long bookId;
    private String userNickname;
    private String feedTitle;
    private String feedContent;
    private LocalDate feedDate;
    private Long likeCnt;
    private Long feedFileId;
    String feedFileName;
    String feedUploadPath;
    String feedUuId;


}
