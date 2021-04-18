var now;
var imgs;

function Init() {
    now = 0;
    var actionimg = document.getElementById("actionimg");
    for (let i = 0; i < actimg; i++) {
        createimg(actionimg, "../../temp/a" + i + ".jpg", "none");
    }
    try {
        actionimg.firstChild.style.display = "block";
    } catch (error) {

    }
    numshow();
    imgs = actionimg.querySelectorAll("img");

    var describeimg = document.querySelector("body > div > div.describe");
    for (let i = 0; i < descimg; i++) {
        createimg(describeimg, "../../temp/d" + i + ".jpg", "block");
    }
}

function createimg(node, imgpath, sty) {
    var para = document.createElement("img");
    para.src = imgpath;
    para.style.display = sty;
    node.appendChild(para);
}

function nextimg() {
    if (now == actimg - 1) {
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
    document.querySelector("body > div > div:nth-child(2)").innerHTML = now + 1 + "/" + actimg;
}