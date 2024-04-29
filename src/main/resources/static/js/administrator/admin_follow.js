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
