const d2 = document.querySelector("#d2");
const d1 = document.getElementById("d1");
const d3 = document.getElementById("d3");
d2.addEventListener("mouseenter",function(){
    console.log("enter");
    console.log(d1.class);
    console.log(d1.getAttribute("class"));
    //d1.className = "c2";
    d1.classList.replace('c3','c2');


});

d2.addEventListener("mouseleave",function(){
    console.log("leave");
    console.log(d1.classList);
    console.log(d1.className);
    d1.classList.add("c4");
});

d3.addEventListener("click",function(){
    
});

