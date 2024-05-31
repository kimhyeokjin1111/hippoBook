// function checkDuplicateId(userLoginId) {
//     fetch('/checkId=' + userLoginId, {
//         method: 'POST'
//     })
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('ERROR');
//             }
//             return response.json();
//         })
//         .then(data => {
//             if(data){
//                 console.log('중복된 아이디입니다.')
//             } else {
//                 console.log('사용 가능한 아이디입니다.');
//             }
//         })
//         .catch(error => {
//             console.error('ERROR2', error);
//         });
// }
//
// document.getElementById('checkUserId').addEventListener('input', function (){
//     const userLoginId = this.value;
//
//     checkDuplicateId(userLoginId);
// })

// id="checkUserId" name="checkDuplicateId"

{
    function checkDuplicateLoginId(userLoginId){

        fetch('user/register ' + userLoginId, {
            method: 'GET'
        })
            .then(response => {
                if(!response.ok){
                    throw new Error('ERROR_ID');
                }
                return response.json();
            })
            .then(data => {
                if(data.userLoginId){
                    document.getElementById('result').innerText = '중복된 아이디 입니다.';
                }else {
                    document.getElementById('result').innerText = '사용 가능한 아이디입니다.';
                }
            })
            .catch(error => {
                console.error('확인하는 중에 오류가 발생했습니다.', error);
            });
    }

    document.getElementById('checkDuplicateBtn').addEventListener("click", function(){
        const checkLoginId = document.getElementById('checkLoginId').value;

        checkDuplicateLoginId(checkLoginId);
    })
}