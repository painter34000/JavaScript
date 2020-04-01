
var num = 1;  //변수의 값이 null, 0은 거짓(false);   , 변수에 값이 있다면 (true);
function gallery(direct) {
    if (direct) {      //증가
        if (num == 4)
            return;
        num++;
    } else {
        if (num == 1)
            return;     //감소
        num--;
    }
    var photo = document.getElementById('photo');
    console.log(photo);
    photo.setAttribute("src", "./images/images" + num + ".jpg");
}



