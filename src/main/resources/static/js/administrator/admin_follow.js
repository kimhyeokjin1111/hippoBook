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
  let $followCheck = document.querySelector('.main__followgoal-td');
  let $permission = document.querySelectorAll('.permission');

  $permission.forEach(p => {
    p.addEventListener('click', function (){
      $followCheck.dataset.check = p.value;
    })
  })
}

{
  let $searchBtn = document.querySelector('.main__user-search-btn');
  let $followUserName = document.querySelector('.main__userInfo-input');
  let $fStartDate = document.querySelector('.startDate');
  let $fEndDate = document.querySelector('.endDate');
  let $followCheck = document.querySelector('.main__followgoal-td');
  let $rownum = document.querySelector('.main__rownum-select');

  $searchBtn.addEventListener('click', function (){
    let followStikerInfo = {
      followUserName : $followUserName.value,
      fStartDate : $fStartDate.value,
      fEndDate : $fEndDate.value,
      followCheck : $followCheck.dataset.check || ""
    }

    let params = new URLSearchParams(followStikerInfo);
    let rowValue = document.querySelector('.main__rownum-select').value;
    console.log(rowValue)
    console.log(params.toString())
    fetch(`/v1/admin/follow?${params.toString()}&amount=${rowValue}`)
        .then(list => list.json())
        .then(l => {
          let tags = '';
          let resultSticker = document.querySelector('.main__result-list-container');

          for (let i = 0; i < l.followList.length; i++) {
            console.log(l.followList[i])
            let name = l.followList[i].userName;
            let loginId = l.followList[i].userNickname;
            let gender = l.followList[i].userGender;
            let age = l.followList[i].userAge;
            let followCnt = l.followList[i].followCnt;
            let skickerDate = l.followList[i].skickerDate

            console.log(name)
            console.log(loginId)
            console.log(gender)
            console.log(age)
            console.log(followCnt)
            console.log(skickerDate)

            tags += `<ul>
                      <li>
                        <label>
                          <input
                            type="checkbox"
                            name="checkOne"
                            class="main__result-checkone"
                          />
                        </label>
                      </li>
                      <li>${name}</li>
                      <li>${loginId}</li>
                      
                      <li>${gender}</li>
                      <li>${age}</li>
                      <li>${followCnt}</li>
                      <li>${skickerDate}</li>
                    </ul>
                    `
          }

          resultSticker.innerHTML = tags;
        })
  })
}
