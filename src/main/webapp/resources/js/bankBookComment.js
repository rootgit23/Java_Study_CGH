const button = document.getElementById("button");
const writer = document.getElementById("writer");
const contents = document.getElementById("contents");
const commentList = document.getElementById("commentList");
const more = document.getElementById("more");
let page = 1;
const book_Num = button.getAttribute("data-bookNum");

getCommentList(page,book_Num);

button.addEventListener("click",function(){
    //console.log(writer.value);
    //console.log(contents.value);
    //console.log(button.data-bookNum);
    //console.log(button.getAttribute("data-bookNum"));
    //let book_Num = button.getAttribute("data-bookNum");
    let wv = writer.value;
    let cv = contents.value;

    
    //1. XMLHttpRequest() 객체 생성
    const xHttp = new XMLHttpRequest();

    //2. 메서드타입 , url 준비
    xHttp.open("POST","./commentAdd")

    //3. encType (post일 경우)
    xHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 전송 post일 경우 파라미터 추가
    xHttp.send("book_Num="+book_Num+"&writer="+wv+"&contents="+cv);

    //5. 응답 시간
    xHttp.onreadystatechange=function(){
        if(this.readyState == 4 && this.status == 200){
            let result = xHttp.responseText;
            result = result.trim();
            console.log(result.trim());
            result = JSON.parse(result);
            writer.value = "";
            contents.value = "";

            if(result.result == 1){
                alert("성공");
                if(commentList.children.length != 0){
                    for(let i=0;i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                }
                page = 1
                getCommentList(page,book_Num);
            }
        }
    }

});

function getCommentList(p,bn){
    const xHttp = new XMLHttpRequest();
    xHttp.open("GET","./commentList?page="+p+"&book_Num="+bn);
    xHttp.send();
    xHttp.addEventListener("readystatechange",function(){
        if(this.readyState == 4 && this.status == 200){
            //console.log(xHttp.responseText);
            //commentList.innerHTML = xHttp.responseText.trim();
            let result = JSON.parse(xHttp.responseText.trim());
            //let result = document.createElement("table");
            //let resultAttr = document.createAttribute("class")
            //resultAttr.value="table table-dark table-hover";
            //result.setAttributeNode(resultAttr);  //<table class="table table-dark table-hover"></table>
            //resultAttr.value="table-dark table-hover";
            //result.setAttributeNode(resultAttr);  //<table class="table table-dark table-hover"></table>
            //resultAttr.value="table-hover";
            //result.setAttributeNode(resultAttr);  //<table class="table table-dark table-hover"></table>
            
            let pager = result.pager;
            let ar = result.list;

            for(let i=0;i<ar.length;i++){
                let tr = document.createElement("tr"); // <tr></tr>

                let td = document.createElement("td"); // <td></td>
                let tdText = document.createTextNode(ar[i].contents);//dfd
                td.appendChild(tdText);           
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer)
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].regDate)
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("수정")
                let attr = document.createAttribute("class")
                attr.value = "update"
                td.setAttributeNode(attr); 
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("삭제")
                attr = document.createAttribute("class")
                attr.value = "delete"
                td.setAttributeNode(attr);
                td.appendChild(tdText);
                
                attr = document.createAttribute("data-comment-num");
                attr.value = ar[i].num;
                td.setAttributeNode(attr);
                tr.appendChild(td);

                commentList.append(tr);

                if(page >= pager.totalPage){

                    more.classList.add("disabled");
                }
                else{
                    more.classList.remove("disabled");
                }
            }
            //console.log(result);
            //let t = commentList.children;
            //if(t.length != 0){
                //commentList.children[0].remove();
            //}
            //try{
                //console.log(commentList.children);
                //throw new Error("에러 메시지");
            //}catch(exception){
                    
            //}finally{
                        
            //}
            //commentList.append(result);
        }
    });

}
more.addEventListener("click",function(){
    page++;
    //const book_Num = button.getAttribute("data-bookNum");
    getCommentList(page,book_Num);
});

commentList.addEventListener("click",function(event){
    if(event.target.className == "delete"){
        let check = window.confirm("삭제하시겠습니까?");
        if(check == true){
            const xHttp = new XMLHttpRequest();
            xHttp.open("POST","./commentDelete");
            xHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xHttp.send("num="+event.target.getAttribute("data-comment-num"))
            xHttp.onreadystatechange = function(){
                if(xHttp.readyState == 4 && xHttp.status == 200){
                    let result = xHttp.responseText;
                    result = result.trim();
                    result = JSON.parse(result);
                    if(result.result == 1){
                        alert("삭제했습니다");
                        if(commentList.children.length != 0){
                            for(let i=0; i<commentList.children.length;){
                                commentList.children[i].remove();
                            }
                        }
                        page = 1;
                        getCommentList(page,book_Num);
                    }
                    else{
                        alert("삭제실패");
                    }
                }
            }
            console.log(event.target.getAttribute("data-comment-num"));
        }
    }
    else if(event.target.className == "update"){
        document.getElementById("up");
        up.click();
        let contents = event.target.previousSibling.previousSibling.previousSibling;
        console.log(contents);
        let v = contents.innerHTML;
        contents.innerHTML = "<textarea>"+v+"</textarea>";
    }
});

