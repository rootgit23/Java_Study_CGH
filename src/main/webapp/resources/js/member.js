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
    else if(id.value == "" && pw.value != ""){
       error.innerText = '아이디를 입력하세요';
    }
    else if(id.value != "" && pw.value == ""){
       error.innerText = '비밀번호를 입력하세요';
    }
    else if(id.value == "" && pw.value == ""){
       error.innerText = '아이디,비밀번호를 입력하세요';
    }
});
});
