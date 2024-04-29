{
  let $headerIcon = document.querySelectorAll(".header__admin-icon");
  let $adminInfo = document.querySelector(".header__admin-info");
  let $noticeInfo = document.querySelector(".header__notice-info");

  $headerIcon.forEach((ele) => {
    ele.addEventListener("click", function () {
      console.log(this.dataset.name);

      $headerIcon.forEach((e) => {
        e.style.borderBottom = "0";
      });

      if (this.dataset.name == "admin") {
        $noticeInfo.classList.remove("header-flex");
        $adminInfo.classList.add("header-flex");
        this.style.borderBottom = "3px solid #212121";

        if (this.dataset.clicked == "T") {
          $adminInfo.classList.remove("header-flex");
          this.style.borderBottom = "0";
          this.dataset.clicked = "F";
        } else {
          $headerIcon.forEach((e) => {
            e.dataset.clicked = "F";
          });
          this.dataset.clicked = "T";
        }
      } else {
        $adminInfo.classList.remove("header-flex");
        $noticeInfo.classList.add("header-flex");
        this.style.borderBottom = "3px solid #212121";

        if (this.dataset.clicked == "T") {
          $noticeInfo.classList.remove("header-flex");
          this.style.borderBottom = "0";
          this.dataset.clicked = "F";
        } else {
          $headerIcon.forEach((e) => {
            e.dataset.clicked = "F";
          });
          this.dataset.clicked = "T";
        }
      }
    });
  });
}
