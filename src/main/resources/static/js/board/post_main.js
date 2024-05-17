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

  $postMenu.forEach((menu) => {
    menu.addEventListener('click', function () {
      let $postNow = document.querySelector('.post-menu-active-info');
      let postNow = $postNow.dataset.postnow;
      let $postTitle = document.querySelector('.main__title-box > span');

      let clickedPost = this.dataset.postnow;
      console.log(clickedPost);

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
