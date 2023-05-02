$(document).ready(function () { 
    let r = getRandomNumber(0, 255)
    let g = getRandomNumber(0, 255)
    let b = getRandomNumber(0, 255)
    let randomColor = "rgb(" + r.toString() + "," + g.toString() + "," + b.toString  + ");"
    console.log(randomColor)
    $("li a").css("background-color", randomColor)
});

function getRandomNumber(min, max) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
}