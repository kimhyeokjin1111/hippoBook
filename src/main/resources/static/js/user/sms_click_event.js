document.getElementById("sendSMSButton").addEventListener("click", function(event) {
    let $phoneNumber = document.getElementById("01098999423");

    console.log(event.target);
    if ($phoneNumber !== null && $phoneNumber.trim() !== "") {
        fetch("/user/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                phoneNumber: $phoneNumber,
            })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Failed to send SMS");
                }
                alert("SMS가 발송되었습니다.");
            })
            .catch(error => {
                console.error("Error sending SMS:", error);
                alert("SMS 발송에 실패했습니다.");
            });
    }
});

// {
//     document.getElementById("sendSMSButton").addEventListener("submit", function(event) {})
//
//     let phoneNumber = document.getElementById("01098999423");
//
//     let xhr = new XMLHttpRequest();
//     xhr.open("POST", "/user/register", true);
//     xhr.setRequestHeader("Content-Type", "application/json");
//     xhr.onreadystatechange = function() {
//         if(xhr.readyState === XMLHttpRequest.DONE){
//             if(xhr.status === 200) {
//                 alert("SMS 인증번호가 발송되었습니다.");
//             }else {
//                 alert("SMS 인증번호 발송에 실패하였습니다. 다시 시도해주세요.");
//             }
//         }
//     };
//     xhr.send(JSON.stringify({phoneNumber: phoneNumber}));
// }