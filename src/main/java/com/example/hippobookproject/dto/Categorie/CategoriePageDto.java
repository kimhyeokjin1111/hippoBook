package com.example.hippobookproject.dto.Categorie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter@Setter@ToString
@NoArgsConstructor
public class CategoriePageDto {
private String title;
private String content;
private Long bookId;
private Long publisherId;
private String bookName;
private String bookWriter;
private LocalDate bookDate;
private Long cateDate;
private Long cateId;
private Long bookcateId;
}
