{
  let $bookLikeBtn = document.querySelector('.book-comment-like-box> button');
}

let $declRadios = document.querySelectorAll(
  '.modal-decl-opt-content-box > label > input'
);

let $declOther = document.querySelector('.decl-reason-other-box-outer');

let $otherReason = document.querySelector('.decl-other-content-box > input');
{
  // 신고하기 모달 박스 이벤트(열기, 닫기)

  let $declIcons = document.querySelectorAll(
    '.main__post-info-decl-box > div > span > img'
  );
  let $declModal = document.querySelector('.modal-decl-req-back');
  let $declClose = document.querySelector('.decl-close-btn');
  let $declProcess = document.querySelector('.decl-process-btn');

  console.log($declIcons);
  console.log($declModal);

  $declIcons.forEach((declI) => {
    declI.addEventListener('click', function () {
      console.log('hi');
      console.log($declModal.style.display);
      if ($declModal.style.display == '') {
        $declModal.style.display = 'flex';
      }
    });
  });

  let $declIcons2 = document.querySelectorAll(
    '.main__post-comment-result-box > li > div > p > img'
  );

  $declIcons2.forEach((declI) => {
    declI.addEventListener('click', function () {
      console.log('hi');
      console.log($declModal.style.display);
      if ($declModal.style.display == '') {
        $declModal.style.display = 'flex';
      }
    });
  });

  let $declReason = document.querySelector(
    '.modal-decl-opt-content-box > input'
  );
  let $alertReason = document.querySelector('.modal-decl-req-box > p');

  $declClose.addEventListener('click', function () {
    $declModal.style.display = '';
    declModalExit();
  });

  $declProcess.addEventListener('click', function () {
    let $declRadios = document.querySelectorAll(
      '.modal-decl-opt-content-box > label > input'
    );
    if ($declReason.dataset.reasonnow == -1) {
      $alertReason.style.display = 'block';
    } else {
      if ($declReason.dataset.reasonnow == 5 && $otherReason.value == '') {
        $alertReason.style.display = 'block';
      } else {
        $declModal.style.display = '';
        declModalExit();
      }
    }
  });

  function declModalExit() {
    $declRadios[$declReason.dataset.reasonnow - 1]
      .closest('label')
      .querySelector('.modal-decl-reason-box > p').style.color = '#8b8b8b';

    $declRadios[$declReason.dataset.reasonnow - 1]
      .closest('label')
      .querySelector('.modal-decl-reason-box > span').style.border =
      '2px solid rgb(233, 229, 229)';

    $alertReason.style.display = '';

    console.log(
      $declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow
    );

    $declRadios[$declReason.dataset.reasonnow - 1].checked = false;

    if ($declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow == 5) {
      $declOther.style.display = 'none';
    }

    $declReason.dataset.reasonnow = -1;
    $otherReason.value = '';
  }
}

{
  // 신고 모달 라디오 선택 이벤트

  console.log($declRadios);

  $declRadios.forEach((rad) => {
    rad.addEventListener('click', function () {
      let $reason = this.closest('label').querySelector(
        '.modal-decl-reason-box > p'
      );

      let $declSpan = this.closest('label').querySelector(
        '.modal-decl-reason-box > span'
      );
      let $declReason = document.querySelector(
        '.modal-decl-opt-content-box > input'
      );

      console.log($declReason);
      // console.log($declReason.dataset.reasonnow);
      if ($declReason.dataset.reasonnow != -1) {
        // console.log($declReason.dataset.reasonnow);
        // console.log(
        //   '현재 끄려는 라벨' +
        //     $declRadios[$declReason.dataset.reasonnow - 1].dataset.reasonnow
        // );

        $declRadios[$declReason.dataset.reasonnow - 1]
          .closest('label')
          .querySelector('.modal-decl-reason-box > p').style.color = '#8b8b8b';

        $declRadios[$declReason.dataset.reasonnow - 1]
          .closest('label')
          .querySelector('.modal-decl-reason-box > span').style.border =
          '2px solid rgb(233, 229, 229)';

        if (this.dataset.reasonnow != 5) {
          $declOther.style.display = 'none';
          $otherReason.value = '';
        }
      }

      if (this.checked == true) {
        $reason.style.color = '#3a3636';
        $declSpan.style.border = '7px solid rgb(119, 111, 111)';
        $declReason.dataset.reasonnow = this.dataset.reasonnow;
        console.log($declReason.dataset.reasonnow);

        if (this.dataset.reasonnow == 5) {
          $declOther.style.display = 'block';
        }
      }
    });
  });
}

{
  // 기타 신고 사유 취소 버튼 이벤트

  let $declCancel = document.querySelector('.decl-other-text-delete > button');
  console.log($declCancel);

  $declCancel.addEventListener('click', function () {
    $otherReason.value = '';
  });
}

{
  //기타 신고 사유 value 업데이트 이벤트
  $otherReason.addEventListener('change', function () {
    console.log($otherReason.value);
    $declRadios[4].value = this.value;
  });
}
