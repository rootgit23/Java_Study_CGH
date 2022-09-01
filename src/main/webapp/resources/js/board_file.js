const addfiles = document.getElementById("addfiles");
const fileadd = document.getElementById("fileadd");
const count = document.getElementsByClassName("count");

fileadd.addEventListener("click",function(){
    if(count.length < 5){

        let div = document.createElement("div");
        let a = document.createAttribute("class");
        a.value = "mb-3";
        div.setAttributeNode(a);
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
        div.appendChild(label);
        div.appendChild(input);
        addfiles.before(div);
    }

    else
        alert("최대 파일 첨부수는 5개입니다.");

});