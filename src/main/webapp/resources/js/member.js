function logincheck(){

    let btn = document.getElementById("btn");
    let frm = document.getElementById("frm");
    let id = document.getElementById("id");
    let pw = document.getElementById("pw");
    let error = document.getElementById("error");
    btn.addEventListener("click",function(){
        if(id.value != "" && pw.value != ""){
            frm.submit();
        }
        else if(id.value == "" && pw.value != ""){
            error.innerText = '아이디를 입력하세요';
        }
        else if(id.value != "" && pw.value == ""){
            error.innerText = '비밀번호를 입력하세요';
        }
        else{
            error.innerText = '아이디,비밀번호를 입력하세요';
        }
    });
}

//member.js

function joinCheck(){
    //선택자
    const joinForm = document.getElementById("joinForm");
    const joinButton = document.getElementById("joinButton");
    const inputUserName = document.getElementById("inputUserName");
    const inputUserNameResult = document.getElementById("inputUserNameResult");
    const inputPassword= document.getElementById("inputPassword");
    const inputPasswordResult = document.getElementById("inputPasswordResult");
    const inputPasswordCheck = document.getElementById("inputPasswordCheck");
    const inputPasswordCheckResult = document.getElementById("inputPasswordCheckResult");

    //Check 결과
    let idCheck=false;
    let pwCheck=false;
    let pwEqualCheck=false;
    let nameCheck=false;
    let emailCheck=false;
    let phoneCheck=false;

    //idCheck
    inputUserName.addEventListener("blur", function(){
        idCheck=false;
        const xHttp = new XMLHttpRequest();
        xHttp.open("POST","./idCheck");
        xHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xHttp.send("user_name="+inputUserName.value);
        xHttp.onreadystatechange=function(){
            if(this.readyState == 4 && this.status == 200){
                let result = xHttp.responseText.trim();
                if(result == 0 && inputUserName.value.length > 1){
                        alert("사용할수 있는 아이디 입니다");
                        inputUserNameResult.innerHTML = "멋진 아이디 입니다.";
                        idCheck=true;
                }
                else if(result == 0 && inputUserName.value.length <= 1){
                    inputUserNameResult.innerHTML="ID는 최소 2글자 이상 이어야 합니다."
                }
                else{
                        inputUserNameResult.innerHTML = "중복된 아이디 입니다.";
                    }
            }
        }
    });

    //pw길이 Check
    inputPassword.addEventListener("change", function(){
        if(inputPassword.value.length>5){
            pwCheck=true;
            inputPasswordResult.innerHTML="";
            inputPasswordCheck.value="";
        }else {
            pwCheck=false;
            inputPasswordResult.innerHTML="패스워드는 6자 글자 이상이어야 합니다";

        }
    });

    //pw가 같은지 check
    inputPasswordCheck.addEventListener("blur", function(){
        console.log("pwEqual");
        if(inputPassword.value == inputPasswordCheck.value){
            pwEqualCheck=true;
            inputPasswordCheckResult.innerHTML="";
        }else {
            pwEqualCheck=false;
            inputPasswordCheck.value="";
            inputPasswordCheckResult.innerHTML="패스워드가 일치하지 않습니다"
        }
    });



    //joinButton CLICK!!
    joinButton.addEventListener("click", function(){
        if(idCheck&&pwCheck&&pwEqualCheck){
            alert("서버 전송 합니다");
            //joinForm.submit();
        }else {
            alert("필수 입력 사항은 다 입력 해야 함");
        }

    })




}

//약관 동의 부분
function check(){
    // const all = document.getElementById("all");
    const all = document.querySelector("#all");
    // const cb = document.getElementsByClassName("cb");
    const cb = document.querySelectorAll(".cb");
    const join = document.getElementById("join");
    const frm = document.getElementById("frm");
    const req = document.getElementsByClassName("req");

    console.log("foreach");
    cb.forEach(function(v, i, ar){
        console.log(v);
    });
    

    join.addEventListener("click", function(){
        let result=true;
        for(let i=0;i<req.length;i++){
            if(!req[i].checked){
                result=false;
                break;
            }
        }
        if(result){
            frm.submit();
        }else {
            alert("필수 약관에 동의 해야 합니다");
        }

        // if(all.checked){
        //     frm.submit();
        // }else {
        //     alert("약관에 동의 해야 합니다");
        // }
    });

    all.addEventListener("click", function(){
        for(let i=0;i<cb.length;i++){
            cb[i].checked=all.checked;
        }
    })

    for(let i=0;i<cb.length;i++){
        cb[i].addEventListener("click", function(){
            let result=true;
            for(let j=0;j<cb.length;j++){
                if(!cb[j].checked){
                    result = false;
                    break;
                }
            }    
            all.checked=result;    
        });
    }


}
