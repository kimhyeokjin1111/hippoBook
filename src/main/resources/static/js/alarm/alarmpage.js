{
    let $tabList = document.querySelectorAll('.tab_menu .list li');
    let $btnBox = document.querySelector('.btn_box')

    for (let i = 0; i < $tabList.length; i++) {
        $tabList[i].querySelector('.alarm_btn')
            .addEventListener('click', function (e) {
                e.preventDefault() // 새로 고침 x
                for (let j = 0; j < $tabList.length; j++) {
                    $tabList[j].classList.remove('btn_box');
                }
                // this.classList.add('$btnBox');
                this.parentNode.classList.add('btn_box');

            })
    }
    // let $alarmBtn = document.querySelectorAll('.alarm_btn')
    //
    // for (let i = 0; i < $alarmBtn.length; i++) {
    //     $alarmBtn[i].addEventListener('click')
    // }



}