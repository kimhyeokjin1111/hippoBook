{
    function checkUserId(){
        var userLoginId = $("#userLoginId").val();
        $.ajax({
            url: "/register",
            type: "GET",
            data: { userLoginId: userLoginId},
            success: function (response){
                $("#userIdMessage").text(response);
            },
            error: function(xhr){
                alert("에러 발생")
            }
        })
    }
}