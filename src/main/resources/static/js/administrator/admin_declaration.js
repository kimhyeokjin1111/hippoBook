{
  // 신고내용 뷰 열고 닫기 이벤트
  let $declarationList = document.querySelectorAll(".declaration-content-text");
  let $declarationBox = document.querySelector(
    ".main__declaration-content-view-box"
  );

  $declarationList.forEach((ele) => {
    ele.addEventListener("click", function () {
      // console.log(ele);
      $declarationBox.classList.add("declaration-view-flex");
    });
  });

  let $declarationCloseBtn = document.querySelectorAll(
    ".main__declaration-close_btn"
  );

  // console.log($declarationCloseBtn);
  $declarationCloseBtn.forEach((ele) => {
    ele.addEventListener("click", function () {
      console.log(ele);
      $declarationBox.classList.remove("declaration-view-flex");
    });
  });
}

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
  let $declTypeSelect = document.querySelector('.main__declaration-select');
  let $declType = document.querySelector('.decl-type');
  let $typeBook = document.querySelector('.type-book');

  $declTypeSelect.addEventListener('change', function (){
    if($declTypeSelect.value === 'feed'){
      $declType.classList.add('feed-can-not-see');
    }else{
      $declType.classList.remove('feed-can-not-see');
    }

    if($declTypeSelect.value === 'comment'){
      $typeBook.classList.remove('book-can-see');
    }else {$typeBook.classList.add('book-can-see');}

  })
}

{
  let $declContent = document.querySelectorAll('.main__search-option td');

  console.log($declContent);
}
