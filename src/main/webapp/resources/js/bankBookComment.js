const button = document.getElementById("button");
const writer = document.getElementById("writer");
const contents = document.getElementById("contents");
const commentList = document.getElementById("commentList");

getCommentList();

button.addEventListener("click",function(){
    //console.log(writer.value);
    //console.log(contents.value);
    //console.log(button.data-bookNum);
    //console.log(button.getAttribute("data-bookNum"));
    let book_Num = button.getAttribute("data-bookNum");
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
                getCommentList();
            }
        }
    }

});

function getCommentList(){
    const xHttp = new XMLHttpRequest();
    xHttp.open("GET","./commentList?page=1&book_Num=1");
    xHttp.send();
    xHttp.addEventListener("readystatechange",function(){
        if(this.readyState == 4 && this.status == 200){
            //console.log(xHttp.responseText);
            //commentList.innerHTML = xHttp.responseText.trim();
            let ar = JSON.parse(xHttp.responseText.trim());
            let result = document.createElement("table");
            let resultAttr = document.createAttribute("class")
            resultAttr.value="table table-dark table-hover";
            result.setAttributeNode(resultAttr);  //<table class="table table-dark table-hover"></table>
            resultAttr.value="table-dark table-hover";
            result.setAttributeNode(resultAttr);  //<table class="table table-dark table-hover"></table>
            resultAttr.value="table-hover";
            result.setAttributeNode(resultAttr);  //<table class="table table-dark table-hover"></table>

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

                result.appendChild(tr);

            }
            console.log(result);
            commentList.append(result);
        }
    });

}