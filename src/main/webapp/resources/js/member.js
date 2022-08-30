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
        error.innerHTML += '<label>아이디를 입력하세요</label>';
    }
    else if(id.value != "" && pw.value == ""){
        error.innerHTML += '<label>비밀번호를 입력하세요</label>';
    }
    else{
        error.innerHTML += '<label>아이디,비밀번호를 입력하세요</label>';
    }
});