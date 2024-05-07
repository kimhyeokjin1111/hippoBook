package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MypageBookContainerMapperTest {
    @Autowired
    MypageBookContainerMapper mypageBookContainerMapper;

    BookContainerDto bookContainerDto;

    IntProfileDto intProfileDto;

    @Test
    void selectBookContainer() {

        List<BookContainerDto> bookContainerList = mypageBookContainerMapper.selectBookContainer(1L);
    }

    @Test
    void deleteBookHas(){
        //given
        List<BookContainerDto> bookContainerDtoList = mypageBookContainerMapper.selectBookContainer(1L);
        //System.out.println("bookContainerDtoList = " + bookContainerDtoList);
        //when

        int oldSize = bookContainerDtoList.size();
        BookContainerDto bookContainerDto = bookContainerDtoList.get(0);
            //System.out.println("bookContainerDto = " + bookContainerDto);
        Long bookHasId = bookContainerDto.getBookHasId();
        mypageBookContainerMapper.deleteBookHas(bookHasId);

        List<BookContainerDto> list = mypageBookContainerMapper.selectBookContainer(1L);
        //then
//        Assertions.assertThat(bookContainerDto).isNull();
        assertThat(list.size()).isEqualTo(oldSize - 1);
    }

    @Test
    void insertBestBook(){

    }
}