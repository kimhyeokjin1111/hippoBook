

{
  let $open = document.querySelector(".feed_writer");
  let $modal = document.querySelector(".modal");
  let $close = document.querySelector(".modal_sheet");
  
  console.log($open);
  console.log($modal);
  
  $open.addEventListener("click", function(){
      $modal.style.display = "flex";
  });

  $close.addEventListener("click", function(){
    $modal.style.display = "none";
  });
    



       // 모달 띄우는
  let $categoryOpenBtn = document.querySelector(".main_top_category");
  let $getmodal = document.querySelector(".category_popup");

    $categoryOpenBtn.addEventListener("click", function(){
    $getmodal.style.display = "block";
    });

  
    // 모달 닫는
    $getmodal.addEventListener("click", function(){
      $getmodal.style.display = "none";
    })
 

}
