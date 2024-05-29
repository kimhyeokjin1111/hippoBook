// showTitleWait()
let $bookSearchInput = document.querySelector('.search_input > input');

let inter = null;
$bookSearchInput.addEventListener('keyup', function () {
    console.log('keyup stop')
    clearInterval(inter);
    inter = setTimeout(showTitle,2000);
})

{
    let $bookSearchWordBox = document.querySelector('.main__book-search-word-container');
    $bookSearchInput.addEventListener('focus', function (){

        if($bookSearchInput.dataset.focus === 'F') {
            $bookSearchInput.dataset.focus = 'T'
            let inter = null;
            console.log('$bookSearchInput.value : ', $bookSearchInput.value)
            showTitle()
            $bookSearchWordBox.classList.remove('active-search-focus-block');
        }
    })

    $bookSearchInput.addEventListener("keyup", function (e){
        // console.log('e.keyCode : ', e.keyCode)
        if(e.keyCode === 13){
            clearInterval(inter);
            // let postReqList = {
            //     postType : $typeRealBox.dataset.type,
            //     type : $etcRealBox.dataset.etc,
            //     keyword : $postSearchBtn.value,
            //     orderType : 'recent',
            //     page : 1,
            // }
            //
            // postShow(postReqList);
            console.log('e.keyCode : ', e.keyCode)
            // showTitle($bookSearchInput.value);
            showTitle2($bookSearchInput.value, showBookReq);
        }
    })
}

function showBookReq(jsonList){
    console.log('jsonList : ', jsonList)
    let $bookSearchResultContainer = document.querySelector('.main__book-search-result-container');
    let $bookSearchContentBox = document.querySelector('.main__book-result-link-content-box');
    let $bookSearchWordBox = document.querySelector('.main__book-search-word-container');
    let tags = ''

    for (let i = 0; i < jsonList.length; i++) {
        tags += `
                        <li>
                            <a href="/book/info?bookId=${jsonList[i].bookId}">
                                <img class="book-result-thumbnail" src="${jsonList[i].cover}" alt="">
                                <div class="book-result-title-writer-box">
                                    <p class="book-result-title">${jsonList[i].bookName}</p>
                                    <p class="book-result-writer">${jsonList[i].bookWriter}</p>
                                </div>
                            </a>
                        </li>
        `
    }

    $bookSearchContentBox.innerHTML = tags;
    $bookSearchWordBox.classList.remove('active-search-focus-block');
    $bookSearchResultContainer.classList.add('active-search-enter-block')
    $bookSearchInput.blur()
    $bookSearchInput.dataset.focus = 'F'
}


function showTitle(){
    //검색 키워드에 맞는 책제목 표시
    fetch(`/v1/search/book/${$bookSearchInput.value}`,
        {method : "GET"})
        .then(resp => resp.json())
        .then(json => {
            console.log('json', json)
            let $bookSearchWordBox = document.querySelector('.main__book-search-word-container');
            let $searchBox = $bookSearchWordBox.querySelector('ul');
            let tags = '';

            for (let i = 0; i < 10; i++) {
                tags += `<li>
                    <span class="search-content-title">
                        ${json[i].bookName}
                    </span>
                </li>`
            }

            $searchBox.innerHTML = tags;
            $bookSearchWordBox.classList.add('active-search-focus-block');

        });
}

function showTitle2(keyword, callback){
    console.log('keyword : ', keyword)

    //검색 키워드에 맞는 책제목 표시
    fetch(`/v1/search/book/${keyword}`,
        {method : "GET"})
        .then(resp => resp.json())
        .then(json => {
            callback(json);
        });
}

{
    let $searchBox = document.querySelector('.main__book-search-word-container > ul');
    $searchBox.addEventListener('click', function (e){
        console.log(e.target)
        if(e.target.classList.contains('search-content-title')){
            console.log('e.target : ', e.target)
            showTitle2(e.target.innerText, showBookReq)
            $bookSearchInput.value = e.target.innerText;
            $bookSearchInput.blur();
            $bookSearchInput.dataset.focus = 'F'
        }
    })
}




