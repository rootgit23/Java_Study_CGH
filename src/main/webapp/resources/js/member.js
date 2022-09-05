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

function join(){
    const all = document.getElementById("all");
    //const check = document.getElementsByClassName("check");
    const btn = document.getElementById("btn");
    const joinfrm = document.getElementById("joinfrm");
    const check2 = document.getElementsByClassName("check2");
    const check = document.querySelectorAll(".check");

    check.forEach(function(v,i,ar){
        console.log(v);
    });

    all.addEventListener("click",function(){
        if(all.checked == true){
            for(let i=0; i<check.length; i++){
                check[i].checked = true;
            }
        }
        else{
            for(let i=0; i<check.length; i++){
                check[i].checked = false;
            }
        }
    });
    for(let i=0;i<check.length;i++){
        check[i].addEventListener("click",function(){
            let result = true;
            for(let j=0; j<check.length; j++){
                if(check[j].checked == false){
                    result = false;
                    break;
                }
            }
            all.checked = result;
        });
    }


    btn.addEventListener("click",function(){
        if(all.checked == true){
            joinfrm.submit();
        }
        else
            alert("약관에 동의하세요");
    });
}

function join2(){
    const id = document.getElementById("id");
    const iderror = document.getElementById("iderror");
    const pw = document.getElementById("pw");
    const pwerror = document.getElementById("pwerror");
    const repw = document.getElementById("repw");
    const repwerror = document.getElementById("repwerror");
    const name = document.getElementById("name");
    const nameerror = document.getElementById("nameerror");
    const email = document.getElementById("email");
    const emailerror = document.getElementById("emailerror");
    const phone = document.getElementById("phone");
    const phoneerror = document.getElementById("phoneerror");
    const joinform = document.getElementById("joinform");
    const joinbutton = document.getElementById("joinbutton");

    let idcheck = false;
    let pwcheck = false;
    let pwequalcheck = false;
    let namecheck = false;
    let emailcheck = false;
    let phonecheck = false;

    id.addEventListener("blur",function(){
        idcheck = false;
        if(id.value.length < 3){
            iderror.innerText = 'ID는 2글자 이상이여야 함';
        }
        else{
            iderror.innerText = '';
            idcheck = true;
        }
    });

    pw.addEventListener("change",function(){
        pwcheck = false;
        if(pw.value.length < 6){
            pwerror.innerText = '비밀번호는 최소 6글자 이상이여야 함';

        }
        else{
            pwerror.innerText = '';
            if(pw.value.match(/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$/)){
                pwerror.innerText = '옳은 형식';
                pwcheck = true;
            }
            else
                pwerror.innerText = '틀린 형식';
        }
    });

    repw.addEventListener("blur",function(){
        pwequalcheck = false;
        if(pw.value == repw.value){
            repwerror.innerText = '일치합니다';
            pwequalcheck = true;
        }
        else{
            repw.value = '';
            repwerror.innerText = '일치하지 않습니다';
        }
    });

    name.addEventListener("blur",function(){
        namecheck = false;
        if(name.value.length < 2){
            nameerror.innerText = '최소 1글자 이상이여야 합니다';
        }
        else{
            nameerror.innerText = '';
            namecheck = true;
        }
    });

    email.addEventListener("blur",function(){
        emailcheck = false;
        if(email.value.length < 2){
            emailerror.innerText = '최소 1글자 이상이여야 합니다';
        }
        else{
            emailerror.innerText = '';
        if(email.value.match(/[\w\-\.]+\@[\w\-\.]+/g)){
            emailerror.innerText = '옳은 형식';
            emailcheck = true;
        }
        else
            emailerror.innerText = '틀린형식';
    }
    });

    phone.addEventListener("blur",function(){
        phonecheck = false;
        if(phone.value.length < 2){
            phoneerror.innerText = '최소 1글자 이상이여야 합니다';
        }
        else{
            phoneerror.innerText = '';
            if(phone.value.match(/^\d{3}-\d{4}-\d{4}$/)){
                phoneerror.innerText = '옳은 형식';
                phonecheck = true;
            }
            else
            phoneerror.innerText = '틀린형식';
        }
    });

    joinbutton.addEventListener("click",function(){
        if(idcheck == true && pwcheck == true && pwequalcheck == true && namecheck == true && emailcheck == true && phonecheck == true){
            joinform.submit();
        }
        else
            alert("가입정보를 재확인하세요");
    });


}