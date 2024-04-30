{
  // 사이드바 열고 닫기 이벤트
  let $sidebarCloseBtn = document.querySelector(".main__sidebar--close-btn");
  let $sidebarDetail = document.querySelector(".main__sidebar-conten-detail");

  // console.log($sidebarCloseBtn);
  // console.log($sidebarDetail);
  $sidebarCloseBtn.addEventListener("click", function () {
    if ($sidebarDetail.classList.contains("sidebar-none")) {
      $sidebarDetail.classList.remove("sidebar-none");
      this.src = "/imgs/administrator/fragment/left_arrow.png";
    } else {
      $sidebarDetail.classList.add("sidebar-none");
      this.src = "/imgs/administrator/fragment/right_arrow.png";
    }
  });
}

{
  //검색 결과 전체 선택
  //전체 취소 이벤트
  let $checkAllBtn = document.querySelector('.main__result-checkall');
  let $checkonebtnList = document.querySelectorAll('.main__result-checkone');

  console.log($checkAllBtn);
  console.log($checkonebtnList);

  $checkAllBtn.addEventListener('click', function () {
    console.log('hi');
    console.log($checkAllBtn.checked);
    if ($checkAllBtn.checked) {
      $checkonebtnList.forEach((ele) => {
        ele.checked = true;
      });
    } else {
      $checkonebtnList.forEach((ele) => {
        ele.checked = false;
      });
    }
  });
}
