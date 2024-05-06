package com.example.hippobookproject.service.mypage;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.mapper.user.MypageBookContainerMapper;
import com.example.hippobookproject.mapper.user.MypageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MypageService {
   private final MypageMapper mypageMapper;
   private final MypageBookContainerMapper mypageBookContainerMapper;

   public IntProfileDto findProfile(Long userId ){
       return mypageMapper.selectProfile(userId)
               .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원 번호"));

   }

   public void registerIntBoardText(IntBoardDto intBoardDto){
       if (intBoardDto.getUserId() == null){
           mypageMapper.insertIntBoardText(intBoardDto);
       }else {
           mypageMapper.updateIntBoardText(intBoardDto);
       }


   }

    public IntBoardDto findIntBoardText(Long userId){
       return mypageMapper.selectIntBoardText(userId)
               .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원 번호"));
    }

    public List<BookContainerDto> findBookContainer(Long userId){

       return mypageBookContainerMapper.selectBookContainer(1L);
    }

    public void removeBookContainer(Long bookHasId,Long userId){
       List<BookContainerDto> bookContainerDtoList = mypageBookContainerMapper.selectBookContainer(userId);
       mypageBookContainerMapper.deleteBookHas(bookHasId);

    }

}
