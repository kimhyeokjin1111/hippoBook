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
   private Long photoFileId;
   private String fileName;
   private String uploadPath;
   private String UuId;


//    PP.PHOTO_FILE_ID, PP.FILE_NAME, PP.FILE_UPLOAD_PATH, PP.FILE_UUID
}
