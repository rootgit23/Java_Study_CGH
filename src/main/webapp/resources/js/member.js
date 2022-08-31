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
            error.innerHTML += '<label>아이디를 입력하세요</label>';
        }
        else if(id.value != "" && pw.value == ""){
            error.innerHTML += '<label>비밀번호를 입력하세요</label>';
        }
        else{
            error.innerHTML += '<label>아이디,비밀번호를 입력하세요</label>';
        }
    });
}
join();
function join(){
    const all = document.getElementById("all");
    const check = document.getElementsByClassName("check");
    const btn = document.getElementById("btn");
    const joinfrm = document.getElementById("joinfrm");
    const check2 = document.getElementById("check2");

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

    //for(let i=0;i<check2.length;i++){
        //check2[i].addEventListener("click",function(){
            //let result2 = true;
            //for(let j=0; j<check2.length; j++){
                //if(check2[j].checked == false){
                    //result2 = false;
                    //break;
                //}
            //}
            //all.checked = result2;
        //});

    //}

    btn.addEventListener("click",function(){
        if(all.checked == true){
            joinfrm.submit();
        }
        else
            alert("약관에 동의하세요");
    });
}