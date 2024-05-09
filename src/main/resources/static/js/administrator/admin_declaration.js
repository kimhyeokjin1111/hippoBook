{
  // 신고내용 뷰 열고 닫기 이벤트
  let $declarationList = document.querySelectorAll(".declaration-content-text");
  let $declarationBox = document.querySelector(
    ".main__declaration-content-view-box"
  );

  let $resultBox = document.querySelector('.main__result-list-container');

  $resultBox.addEventListener('click', function (e){
    console.log('e.target : ', e.target)
    console.log('this : ', this)
    console.log('e : ', e)

    let classList = e.target.classList;
    let postId, cate;

    if(classList.contains('decl-content-box')){
      $declarationBox.classList.add("declaration-view-flex");
      postId = e.target.dataset.postid;
      cate = e.target.dataset.cate;
    } else if(classList.contains('declaration-content-text')){
      $declarationBox.classList.add("declaration-view-flex");
      let $target = e.target.closest('.decl-content-box');
      postId = $target.dataset.postid;
      cate = $target.dataset.cate;
    }


  })

  // $declarationList.forEach((ele) => {
  //   ele.addEventListener("click", function () {
  //     // console.log(ele);
  //     $declarationBox.classList.add("declaration-view-flex");
  //   });
  // });

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
  let $declTypeTd = document.querySelectorAll('.main__declaration-type-td');

  $declTypeSelect.addEventListener('change', function (){
    if($declTypeSelect.value === 'feed'){
      $declType.classList.add('feed-can-not-see');
      $declTypeTd.dataset.type = '';
    }else{
      $declType.classList.remove('feed-can-not-see');
    }

    if($declTypeSelect.value === 'comment'){
      $typeBook.classList.remove('book-can-see');
    }else {$typeBook.classList.add('book-can-see');}

  })
}

{
  let $declTypes = document.querySelectorAll('.decl-opt-type');
  let $declPrypes = document.querySelectorAll('.decl-opt-p-type');

  $declTypes.forEach(ele => {
    ele.addEventListener('click', function (){
      ele.closest('.main__declaration-type-td').dataset.type = ele.value;
    })
  })

  $declPrypes.forEach(ele => {
    ele.addEventListener('click', function (){
      ele.closest('.main__process-type-td').dataset.ptype = ele.value;
    })
  })
}

{
  let $nowrowBox = document.querySelector('.main__rownum-select');

  $nowrowBox.addEventListener('change', function (){
    console.log($nowrowBox.value)
  })

}


{
  let $declContent = document.querySelector('.main__declarationDate-input');
  let $declStDecl = document.querySelector('.startDeclDate');
  let $declEdDecl = document.querySelector('.endDeclDate');
  let $declStPDecl = document.querySelector('.startPDate');
  let $declEdPDecl = document.querySelector('.endPDate');
  let $declType = document.querySelector('.main__declaration-type-td');
  let $declPType = document.querySelector('.main__process-type-td');
  let $declSearchBtn = document.querySelector('.decl-search-btn');

  $declSearchBtn.addEventListener('click', function (){
    let searchDeclInfo = {
      declarationContent : $declContent.value,
      startDeclarationDate : $declStDecl.value,
      endDeclarationDate : $declEdDecl.value,
      startPocecssDate : $declStPDecl.value,
      endPocecssDate : $declEdPDecl.value,
      declarationType : $declType.dataset.type || '',
      processType : $declPType.dataset.ptype
    };
    let $nowrowBox = document.querySelector('.main__rownum-select');

    declReq(searchDeclInfo, $nowrowBox.value)
  })



}

function declReq(searchDeclInfo, amount, page){
  console.log(searchDeclInfo)
  let params = new URLSearchParams(searchDeclInfo);

  // console.log(params.toString())

  fetch(`/v1/declarations?${params.toString()}&amount=${amount}`, {
    method : 'GET',
  }).then(resp => resp.json())
      .then(list => {
        console.log('list', list);
        console.log(list.declList)
        let declListTags = ``;
        let declPageTags = ``;
        let $declResultBox = document.querySelector('.main__result-list-container');
        let $declPageBox = document.querySelector('.main__searched-result-page-btn > ul');

        for (let i = 0; i < list.declList.length; i++) {
          let declarationDate = list.declList[i].declarationDate;
          let declarationContent = list.declList[i].declarationContent;
          let userId = list.declList[i].userId;
          let declProcessDate = list.declList[i].declProcessDate;
          let declarationCheck = list.declList[i].declarationCheck;
          let postId = list.declList[i].postId;
          let cate = list.declList[i].cate;

          declListTags += `
                    <ul>
                      <li>${declarationDate}</li>
                      <li class="decl-content-box" data-postid="${postId}" data-cate="${cate}">
                        <div class="declaration-content-text">
                          ${declarationContent}
                        </div>
                      </li>
                      <li>${userId}</li>
                      <li>${declProcessDate}</li>
                      <li>${declarationCheck}</li>
                    </ul>
        `
        }

        $declResultBox.innerHTML = declListTags;
        let $nowrowBox = document.querySelector('.main__rownum-select');

        if(list.declPage.prev){
          declPageTags += `<span class="lf-arrow decl-page-btn"><a  href="/v1/declarations?${params.toString()}&page=${list.declPage.startPage -1}">&lt;</a></span>`
        }
        for (let i = list.declPage.startPage; i < list.declPage.startPage + 1; i++) {
          let prev = list.declPage.prev;

          declPageTags += `   
                      <li class="decl-page-btn"><a href="/v1/declarations?${params.toString()}&page=${i}"><strong>${i}</strong></a></li>    
            `
        }
        if(list.declPage.next) {
          declPageTags += `<span class="rt-arrow decl-page-btn"><a  href="/v1/declarations?${params.toString()}&page=${list.declPage.endPage + 1}">&gt;</a></span>`;
        }

        $declPageBox.innerHTML = declPageTags
      });
}

{
  let $pageBox = document.querySelector('.main__searched-result-page-btn');

  $pageBox.addEventListener('click', function (e){
    console.log(e.target)

    if(e.target.classList.contains('decl-page-btn')){
      let $pageLink = document.querySelector('a');
      console.log('pageLink', $pageLink)
      let $nowrowBox = document.querySelector('.main__rownum-select');

      declReq($pageLink.getAttribute('href'), $nowrowBox.value);
    }

  })

}

