const d1 = document.getElementById("d1");
const text = document.getElementById("text");
const result = document.getElementById("result");
d1.addEventListener("click",function(){
    let a = text.value;
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET","https://jsonplaceholder.typicode.com/posts/" + a);
    xhttp.send()
    xhttp.onreadystatechange = function(){
       // console.log(this.status);
        //console.log(this.readyState);
        //console.log("----------------------");
        if(this.readyState == 4 && this.status == 200){
            //console.log(this.responseText);
            let response = this.responseText.trim();
            response = JSON.parse(response);
            console.log(response.userId);
            console.log(response.id);
            console.log(response.title);
            console.log(response.body);
            let id = document.createElement("h3");
            let id1 = document.createTextNode(response.userId);
            id.appendChild(id1);
            let h = document.createElement("h3");
            let h1 = document.createTextNode(response.id);
            h.appendChild(h1);
            let t = document.createElement("h3");
            let t1 = document.createTextNode(response.title);
            t.appendChild(t1);
            let b = document.createElement("h3");
            let b1 = document.createTextNode(response.body);
            b.appendChild(b1);
            result.appendChild(id);
            result.appendChild(h);
            result.appendChild(t);
            result.appendChild(b);
        }
    }

    console.log("ajax 발생");

});