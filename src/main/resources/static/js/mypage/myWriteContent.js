{
    let $myRivewView = document.querySelector(".review-content-btn")
    let $myPostView = document.querySelector(".post-content-btn")
    
    $myPostView.addEventListener("click", function () {
        $myRivewView.style.color = "gray";
        $myRivewView.style.backgroundColor = "white";
        $myPostView.style.color = "white";
        $myPostView.style.backgroundColor ="#2bc1bf";
      });

    $myRivewView.addEventListener("click",function(){
      $myRivewView.style.color = "white";
        $myRivewView.style.backgroundColor = "#2bc1bf";
        $myPostView.style.color = "gray";
        $myPostView.style.backgroundColor ="white";
    })
    
      
}