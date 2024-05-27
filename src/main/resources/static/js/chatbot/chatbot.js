{
    console.log("chatbot jssssssssssssssss");

    let chatInput = document.querySelector("#chat-input");
    let chatBtn = document.querySelector('#chat-btn');
    let chatViewBox = document.querySelector('.chatbot-viewer-box');

    console.log('chatInput : ', chatInput)
    console.log('chatBtn : ', chatBtn)
    console.log('chatViewBox : ',chatViewBox)
    chatBtn.addEventListener('click', function (){
        console.log('chat btn click !!')

        let chatValue = chatInput.value;
        let tags =
            `
            <div class="user-chat-box"><div class="chat-div">${chatValue}</div></div>
            `

        chatViewBox.insertAdjacentHTML("beforeend", tags);
        chatInput.value = '';
    })
}