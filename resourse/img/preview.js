var now;
var imgs;

function Init() {
    now = 0;
    var actionimg = document.getElementById("actionimg");
    for (let i = 0; i < maximg; i++) {
        createimg(actionimg, "../temp/" + i + ".jpg")
    }
    actionimg.firstChild.style.display = "block";
    numshow();
    imgs = actionimg.querySelectorAll("img");
}

function createimg(node, imgpath) {
    var para = document.createElement("img");
    para.src = imgpath;
    para.style.display = "none";
    node.appendChild(para);
}

function nextimg() {
    if (now == maximg - 1) {
        return
    } else {
        imgs[now].style.display = "none";
        imgs[++now].style.display = "block";
        numshow();
    }

}

function preimg() {
    if (now == 0) {
        return
    } else {
        imgs[now].style.display = "none";
        imgs[--now].style.display = "block";
        numshow();
    }

}

function numshow() {
    document.querySelector("body > div > div:nth-child(2)").innerHTML = now + 1 + "/" + maximg;
}