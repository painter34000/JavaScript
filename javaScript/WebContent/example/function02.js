//전역함수/지역함수/실행함수    

var score = 10;
function myFunc(){
    var score=20;
    console.log("local:" +score)
}
myFunc();
console.log("global : "+score);

function newFunc(){
    console.log("golbal function");
}
function outerFunc(){
    function newFunc(){
        console.log("local function");
    }
    newFunc();
}
newFunc();
outerFunc();


(function(){
    console.log("return Fnc");
})();   //()붙이면 바로실행