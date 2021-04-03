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

function fileread() {
    //获取读取我文件的File对象
    var f = document.getElementById('files').files[0];
    var name = f.name; //读取选中文件的文件名
    var size = f.size; //读取选中文件的大小
    console.log("文件名:" + name + "大小:" + size);
    var reader = new FileReader(); //这是核心,读取操作就是由它完成.
    reader.readAsText(f); //读取文件的内容,也可以读取文件的URL
    reader.onloadend = function () {
        console.log(this.result);
        maximg = JSON.parse(this.result).a;
        Init();
    }
}

function inputnum() {
    maximg = document.getElementById("input").value;
    console.log(maximg);
    Init();
}