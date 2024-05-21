{
  let $optionSpanBtn = document.querySelectorAll('.option-span');
  let $postUl = document.querySelector('.post');
  let $etcUl = document.querySelector('.etc');

  console.log($postUl);
  console.log($etcUl);

  $optionSpanBtn.forEach((ele) => {
    // console.log(ele);
    ele.addEventListener('click', function () {
      console.log('this : ', this);
      if (this.dataset.search_type == 'post') {
        if ($postUl.classList.contains('search-option-ul-block')) {
          $postUl.classList.remove('search-option-ul-block');
          return;
        }
        $postUl.classList.add('search-option-ul-block');
      } else {
        if ($etcUl.classList.contains('search-option-ul-block')) {
          $etcUl.classList.remove('search-option-ul-block');
          return;
        }
        $etcUl.classList.add('search-option-ul-block');
      }
    });
  });
}

{
  //게시판 타입 메뉴 클릭 이벤트

  let $postMenu = document.querySelectorAll('.post-menu-li');

  console.log($postMenu);

  let postReqList = {
    postType : $postMenu[0].querySelector('a').dataset.type,
    type : null,
    keyword : null,
    page : 1,
    amount : 10
  }

  postShow(postReqList);

  $postMenu.forEach((menu) => {
    menu.addEventListener('click', function () {
      let $postNow = document.querySelector('.post-menu-active-info');
      let postNow = $postNow.dataset.postnow;
      let $postTitle = document.querySelector('.main__title-box > span');

      let clickedPost = this.dataset.postnow;
      console.log(clickedPost);

      let postReqList = {
        postType : this.querySelector('a').dataset.type,
        type : null,
        keyword : null,
        page : 1,
        amount : 10
      }

      postShow(postReqList);

      if (postNow != clickedPost) {
        $postNow.dataset.postnow = clickedPost;

        $postMenu[postNow - 1].classList.remove('post-menu-select-li');
        $postMenu[clickedPost - 1].classList.add('post-menu-select-li');

        $postMenu[postNow - 1]
          .querySelector('span')
          .classList.remove('post-menu-select-span');
        $postMenu[clickedPost - 1]
          .querySelector('span')
          .classList.add('post-menu-select-span');

        $postTitle.innerText =
          $postMenu[clickedPost - 1].querySelector('a').innerText + '게시판';

      }
    });
  });
}

{
    let $typeRealBox = document.querySelector('.option-span');
    let $typeOpts = document.querySelectorAll('.post > li')
    let $typeText = $typeRealBox.querySelector('span');
    console.log('$typeOpts : ', $typeOpts);
    console.log('$typeText : ', $typeText)

    $typeOpts.forEach(li => {
        li.addEventListener('click', function (){
            $typeRealBox.dataset.type = this.dataset.type;
            $typeText.innerText = this.innerText;
        })
    })

    let $etcRealBox = document.querySelector('.option-span:nth-child(2)');
    let $etcOpts = document.querySelectorAll('.etc > li')
    let $etcText = $etcRealBox.querySelector('span');
    // console.log('$typeOpts : ', $typeOpts);
    // console.log('$typeText : ', $typeText)

    $etcOpts.forEach(li => {
        li.addEventListener('click', function (){
            $etcRealBox.dataset.type = this.dataset.type;
            $etcText.innerText = this.innerText;
        })
    })
}

function postShow(postReqList){
  fetch(`/v1/board/${postReqList.postType}/posts?type=${postReqList.type}&keyword=${postReqList.keyword}&page=${postReqList.page}&amount=${postReqList.amount}`,
      {method : "GET"})
      .then(resp => resp.json())
      .then(post => {
        console.log(post)

        let tags = ``;

        for (let i = 0; i < post.post.length; i++) {
          let postTitle = post.post[0].postTitle;
          let userNickname = post.post[0].userNickname;
          let likeCount = post.post[0].likeCount;
          let postDate = post.post[0].postDate;
          let postView = post.post[0].postView;

          tags += `
               <li class="main__post-result-li">
                  <p class="main__post-titie-info-box">
                    <span>${postTitle}</span>
                    <img src="" alt="" />
                  </p>
                  <div class="main__post-detail-info-box">
                    <span>${userNickname}</span>
                    <ul>
                      <li>${likeCount}</li>
                      <li>${postDate}</li>
                      <li>${postView}</li>
                    </ul>
                  </div>
                </li>
                  `
        }

        let $postBox = document.querySelector('.main__post-search-result-box > ul');

        $postBox.innerHTML = tags;

        let tags2 = ``;
        console.log('post.postPage.prev : ', post.postPage.prev)
        console.log('post.postPage.startPage : ', post.postPage.startPage)
        console.log('post.postPage.endPage : ', post.postPage.endPage)

        if(post.postPage.prev){
          tags2 += `
            <span
              ><a href="/v1/board/${postReqList.postType}/posts?type=${postReqList.type}&keyword=${postReqList.keyword}&amount=${postReqList.amount}" data-page="${post.postPage.startPage -1}"><img src="/imgs/administrator/fragment/left_sh.png" alt="" /></a
            ></span>`
        }

        for (let i = post.postPage.startPage; i < post.postPage.endPage + 1; i++) {


          tags2 +=
              `
            <a href="/v1/board/${postReqList.postType}/posts?type=${postReqList.type}&keyword=${postReqList.keyword}&amount=${postReqList.amount}" data-page="${i}">${i}</a>
              `
        }
        if(post.postPage.next) {
          tags2 += `
            <span
              ><a href="/v1/board/${postReqList.postType}/posts?type=${postReqList.type}&keyword=${postReqList.keyword}&amount=${postReqList.amount}" data-page="${post.postPage.endPage + 1}"><img src="/imgs/administrator/fragment/right-sh.png" alt="" /></a
            ></span>
            `
        }
        let $pageBox = document.querySelector('.main__post-page-btn-box')
        console.log('pageBox : ', $pageBox)
        console.log('tags2 : ', tags2)
        $pageBox.innerHTML = tags2;
      })
}

{
    let $keyPeress = document.querySelector('.search-contnet-input')

    $keyPeress.addEventListener('keyPress' , function (){
        console.log('keyPress')
        alert("dddd")
    })
}
