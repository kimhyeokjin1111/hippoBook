// const usernameInput = document.querySelector("#userLoginId");
// const showIfDuplication = document.querySelector(".userLoginId");
//
// usernameInput.onblur = () => {
//     let tmpId = usernameInput.value;
//
//     const httpRequest = new XMLHttpRequest();
//
//     httpRequest.onreadystatechange = function () {
//         if(httpRequest.readyState == 4 && httpRequest.status == 200){
//             const response = httpRequest.responseText;
//             showIfDuplication.innerHTML = `
//             <span>${tmpId} is ${response === "true" ? " invalid!"`
//         }
//     }
// }