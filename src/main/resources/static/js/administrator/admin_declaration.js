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
  let $declContent = document.querySelector('.main__declarationDate-input');
  let $declStDecl = document.querySelector('.startDeclDate');
  let $declEdDecl = document.querySelector('.endDeclDate');
  let $declStPDecl = document.querySelector('.startPDate');
  let $declEdPDecl = document.querySelector('.endPDate');
  let $declType = document.querySelector('.main__declaration-type-td');
  let $declPType = document.querySelector('.main__process-type-td');
  let $declSearchBtn = document.querySelector('.decl-search-btn');
  let $

  $declSearchBtn.addEventListener('click', function (){
    let searchDeclInfo = {
      declarationContent : $declContent.value,
      startDeclarationDate : $declStDecl.value,
      endDeclarationDate : $declEdDecl.value,
      startPocecssDate : $declStPDecl.value,
      endPocecssDate : $declEdPDecl.value,
      declarationType : $declType.dataset.type,
      processType : $declPType.dataset.ptype
    };

    console.log(searchDeclInfo)

    fetch(`/v1/declarations?declarationContent=${$declContent.value}&startDeclarationDate=${$declStDecl.value}&endDeclarationDate=${$declEdDecl.value}&startPocecssDate=${$declStPDecl.value}&endPocecssDate=${$declEdPDecl.value}&declarationType=${$declType.dataset.type || ''}&processType=${$declPType.dataset.ptype}`, {
      method : 'GET',
    }).then(resp => resp.json())
        .then(list => {
          let declTags = ``;
          let $declResultBox = document.querySelector('.main__result-list-container');

          for (let i = 0; i < list.length; i++) {
            declTags += `
                    <ul>
                      <li>${list.declarationDate}</li>
                      <li>
                        <div class="declaration-content-text">
                          ${list.declarationContent}
                        </div>
                      </li>
                      <li>${list.userId}</li>
                      <li>${list.declProcessDate}</li>
                      <li>${list.declarationCheck}</li>
                    </ul>
        `
          }

          $declResultBox.innerHTML = declTags;


    });
  })

}
