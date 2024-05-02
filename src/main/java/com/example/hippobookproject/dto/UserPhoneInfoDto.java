package com.example.hippobookproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class UserPhoneInfoDto {
    private String phoneInfoName;
    private String phoneInfoBirthDate;
    private String phoneInfoPhoneNumber;
//    PHONEINFO_NAME, PHONEINFO_BIRTH_DATE, PHONEINFO_PHONENUMBER
}
