const addfiles = document.getElementById("addfiles");
const fileadd = document.getElementById("fileadd");
const count = document.getElementsByClassName("count");
const check = document.getElementById("check");

let idx = 0;

check.addEventListener("click",function(event){
    if(event.target.className == "del"){
        let b = event.target.title;
        let a = document.getElementById("file"+(b));
        a.remove();
    }
});

fileadd.addEventListener("click",function(){
    if(count.length < 5){

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

    }

    else
        alert("최대 파일 첨부수는 5개입니다.");
    


});

