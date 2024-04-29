{
  let $optionSpanBtn = document.querySelectorAll(".option-span");
  let $postUl = document.querySelector(".post");
  let $etcUl = document.querySelector(".etc");

  console.log($postUl);
  console.log($etcUl);

  $optionSpanBtn.forEach((ele) => {
    // console.log(ele);
    ele.addEventListener("click", function () {
      // console.log(this.dataset.search_type);
      if (this.dataset.search_type == "post") {
        if ($postUl.classList.contains("search-option-ul-block")) {
          $postUl.classList.remove("search-option-ul-block");
          return;
        }
        $postUl.classList.add("search-option-ul-block");
      } else {
        if ($etcUl.classList.contains("search-option-ul-block")) {
          $etcUl.classList.remove("search-option-ul-block");
          return;
        }
        $etcUl.classList.add("search-option-ul-block");
      }
    });
  });
}
