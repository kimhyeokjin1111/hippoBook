import * as module from '../mypage/module/bookContainerModule.js'

{
    let $bookContainerSet = document.querySelectorAll(".my-book-get-list-image");
    let $modalBox = document.querySelector(".book-container-modal-bg");
    let $xBox = document.querySelector(".x-box");
    let $bestBook = document.querySelector(".best-book")
    let $bookInfoDetail = document.querySelector(".book-info-detail")
    let $bookListDelete = document.querySelector(".book-list-delete")
    let $bookContainerSort = document.querySelector(".book-Container-cate-list-setting")
    let $bookContainerSortImage = document.querySelector("#list-setting-image")
    let $bestBookImg = document.querySelector("#best-book-img")
    console.log($bookContainerSet);
  
    if ($bookContainerSet.length > 0) {
        $bookContainerSet.forEach(function(bookImage) {
          bookImage.addEventListener("click", function () {
            $modalBox.style.display = "flex";
              let id = this.dataset.id;
            $modalBox.querySelector('.book-list-delete').dataset.id = id;
          });
        });
      }
  
    $xBox.addEventListener("click", function () {
      $modalBox.style.display = "none";
    });




    $bestBook.addEventListener("click", function(){

        
        $modalBox.style.display = "none";
    });
  
    $bookInfoDetail.addEventListener("click", function(){

        $modalBox.style.display = "none";
    });

    $bookListDelete.addEventListener("click", function(){
        module.remove(this.dataset.id, function (){
            location.reload();
        });

        $modalBox.style.display = "none";
    });



    
    let sortStatus = false;

    $bookContainerSort.addEventListener("click", function(){
      if(sortStatus){
        $bookContainerSortImage.style.transform = "scaleY(1)";
      }else{
        $bookContainerSortImage.style.transform = "scaleY(-1)";
      }

      sortStatus = !sortStatus;
      
    });
  
    

  }
  