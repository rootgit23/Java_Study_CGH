const addfiles = document.getElementById("addfiles");
const fileadd = document.getElementById("fileadd");
const count = document.getElementsByClassName("count");
const check = document.getElementById("check");
const fileDelete = document.querySelectorAll(".fileDelete"); //queryselectorall만 foreach가능 classname으로 가져오면 유사배열이여서 불가능

let ccount = 0;
let idx = 0;


function setCount(c){
    if(c>=0){
        ccount = c
    }
}

//add할때 파일 추가
try {
    
    check.addEventListener("click",function(event){
        if(event.target.className == "del"){
            let b = event.target.title;
            let a = document.getElementById("file"+(b));
            a.remove();
        }
    });
    
    fileadd.addEventListener("click",function(){
        if(ccount < 5){
    
            let div = document.createElement("div");
            let a = document.createAttribute("class");
            a.value = "mb-3";
            div.setAttributeNode(a);
            let p = document.createAttribute("id");
            p.value = "file"+idx;
            div.setAttributeNode(p);
            let label = document.createElement("label");
            let b = document.createAttribute("for");
            b.value = "exampleFormControlTextarea1";
            label.setAttributeNode(b);
            let c = document.createAttribute("class");
            c.value = "form-label";
            label.setAttributeNode(c);
            let file = document.createTextNode("Files");
            label.appendChild(file);
            let input = document.createElement("input");
            let d = document.createAttribute("type");
            d.value = "file";
            input.setAttributeNode(d);
            let e = document.createAttribute("name");
            e.value = "files";
            input.setAttributeNode(e);
            let f = document.createAttribute("class");
            f.value = "form-control";
            input.setAttributeNode(f);
            let g = document.createAttribute("id");
            g.value = "exampleFormControlInput1";
            input.setAttributeNode(g);
            let h = document.createAttribute("class");
            h.value = "count";
            input.setAttributeNode(h);
            let btn = document.createElement("button");
            let t = document.createAttribute("type");
            t.value = "button";
            btn.setAttributeNode(t);
            let cs = document.createAttribute("class");
            cs.value = "del";
            btn.setAttributeNode(cs);
            let content = document.createTextNode("파일 삭제");
            btn.appendChild(content);
            let button = document.createAttribute("title");
            button.value = idx;
            btn.setAttributeNode(button);
            div.appendChild(label);
            div.appendChild(input);
            div.appendChild(btn);
            addfiles.before(div);
            idx++;
            ccount++;
        }
    
        else
            alert("최대 파일 첨부수는 5개입니다.");
        
    
    
    });
    
} catch (e) {
    
}



//update시 파일 delete
try {
    fileDelete.forEach(function(f){
        f.addEventListener("click",function(){
            console.log(f.parentNode);
            console.log("file Delete");
            let check = window.confirm("삭제를 하면 되돌릴수 없습니다.");
            if(!check){
                return;
            }
            let fileNum = f.getAttribute("data-file-num");
            const xHttp = new XMLHttpRequest();
            xHttp.open("POST","./fileDelete");
            xHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xHttp.send("fileNum="+fileNum);
            xHttp.onreadystatechange=function(){
                if(xHttp.readyState == 4 && xHttp.status == 200){
                    let result = xHttp.responseText.trim();
                    if(result==1){
                        console.log(result);
                        f.parentNode.remove();
                        ccount--;
                    } else{
                        console.log(result);
                    }
                }
            }
        })
    });
    
} catch (e) {
    console.log(e);
}

//for(fi of fileDelete){
    //console.log(fi);
//}
