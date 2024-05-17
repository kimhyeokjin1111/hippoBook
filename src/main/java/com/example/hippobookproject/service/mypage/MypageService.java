package com.example.hippobookproject.service.mypage;

import com.example.hippobookproject.dto.mypage.*;
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
               .orElse(new IntBoardDto());
    }

    public List<BookContainerDto> findBookContainer(Long userId){

       return mypageBookContainerMapper.selectBookContainer(1L);
    }

    public void removeBookContainer(Long bookHasId){
//       List<BookContainerDto> bookContainerDtoList = mypageBookContainerMapper.selectBookContainer(userId);
       mypageBookContainerMapper.deleteBookHas(bookHasId);

    }

    public BookContainerDto findBestBook(Long userId){
        return mypageBookContainerMapper.selectBestBook(userId)
                .orElseThrow(()-> new IllegalStateException("존재하지 않는 회원번호"));
    }

    public void modifyBestBook(BookContainerDto bookContainerDto){
        mypageBookContainerMapper.updateBestBook(bookContainerDto);

    }

    public void modifyBookStatus(BookContainerDto bookContainerDto){
        mypageBookContainerMapper.updateBookStatus(bookContainerDto);

    }

    public List<BookContainerDto> findRecentBook(Long userId){
       return mypageMapper.selectRecentBook(userId);
    }

    public List<MyContentDto> findMyContent(Long userId){
       return mypageMapper.selectMyContent(userId);
    }

    public Long findReviewCount(Long userId){
       return mypageMapper.selectReviewCount(userId);
    }

    public Long findPostCount(Long userId){
        return mypageMapper.selectPostCount(userId);
    }

    public IntProfileDto findProfilePhoto(Long userId){
        return mypageMapper.selectProfilePhoto(userId)
                .orElse(new IntProfileDto());
    }

    public void registerSticker(StickerDto stickerDto){
       if (stickerDto.getUserId() != null){
           mypageMapper.insertSticker(stickerDto);
       }


    }




}
