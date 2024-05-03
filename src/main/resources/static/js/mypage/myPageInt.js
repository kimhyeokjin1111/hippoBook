{
  let $introduceBtn = document.querySelector(".introduce-save-btn");
  let $introduceText = document.querySelector(".introduce-text-content");
  let $intTextBox = document.querySelector(".int-Text-Box-All")
  $introduceText.addEventListener("click",function (){
    $introduceBtn.style.display = "flex";
  });

  $introduceBtn.addEventListener("click",function (){
    $introduceBtn.style.display = "none";
  });

  $intTextBox.addEventListener("mouseover", function (){
    $introduceBtn.style.display = "none";
  })

}
  