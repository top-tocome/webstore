"use strict";

var str = "";
str += "<!DOCTYPE html>";
str += "<html>";
str += "";
str += "<head>";
str += "    <meta charset=\"UTF-8\">";
str += "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
str += "    <title>img preview</title>";
str += "    <style>";
str += "        * {";
str += "            box-sizing: border-box;";
str += "        }";
str += "";
str += "        .background {";
str += "            width: 500px;";
str += "            height: auto;";
str += "            background-color: rgb(255, 225, 159);";
str += "            margin: auto;";
str += "        }";
str += "";
str += "        .actionimg {";
str += "            overflow: hidden;";
str += "            background-color: rgba(158, 158, 158, 0.39);";
str += "            width: 70%;";
str += "            height: 350px;";
str += "            float: left;";
str += "            text-align: center;";
str += "            border-radius: 30px;";
str += "            border-style: ridge;";
str += "            border-color: rgb(233, 125, 188);";
str += "            box-shadow: 0px 0 20px 0px rgb(243, 139, 243);";
str += "";
str += "            display: flex;";
str += "            align-items: center;";
str += "            justify-content: center;";
str += "        }";
str += "";
str += "        .actionimg img {";
str += "            min-width: 50%;";
str += "            max-width: 100%;";
str += "            min-height: 50%;";
str += "            max-height: 100%;";
str += "        }";
str += "";
str += "        .button {";
str += "            width: 15%;";
str += "            height: 100%;";
str += "            text-align: center;";
str += "            float: left;";
str += "        }";
str += "";
str += "        .button :hover {";
str += "            border-style: groove;";
str += "        }";
str += "";
str += "        .fullscreen {";
str += "            position: absolute;";
str += "            width: 100%;";
str += "            height: 100%;";
str += "            top: 0;";
str += "            left: 0;";
str += "            min-width: 500px;";
str += "        }";
str += "";
str += "        .fullscreen img {";
str += "            min-width: auto;";
str += "            min-height: auto;";
str += "        }";
str += "";
str += "        .fullscreenbuttonleft {";
str += "            position: fixed;";
str += "            top: 0;";
str += "            left: 0;";
str += "            z-index: 1;";
str += "        }";
str += "";
str += "        .fullscreenbuttonright {";
str += "            position: fixed;";
str += "            top: 0;";
str += "            right: 0;";
str += "            z-index: 1;";
str += "        }";
str += "";
str += "        .fullscreennumshow {";
str += "            position: fixed;";
str += "            top: 0;";
str += "            right: 10px;";
str += "            z-index: 1;";
str += "            font-size: 3vmax;";
str += "";
str += "        }";
str += "";
str += "        .fullscreenbuttonleft img {";
str += "            width: 50px;";
str += "        }";
str += "";
str += "        .fullscreenbuttonright img {";
str += "            width: 50px;";
str += "        }";
str += "";
str += "        .describe {";
str += "            height: 120px;";
str += "        }";
str += "    </style>";
str += "</head>";
str += "";
str += "<body style=\"background-color:antiquewhite;\">";
str += "";
str += "    <div class=\"background\">";
str += "";
str += "        <div style=\"height: 100px;\"></div>";
str += "";
str += "        <div style=\"text-align:center;\" id=\"numshow\"></div>";
str += "";
str += "        <div style=\"height: 350px;\">";
str += "            <div id=\"buttonleft\" class=\"button\">";
str += "                <img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAACXBIWXMAAC4jAAAuIwF4pT92AAAF0WlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDUgNzkuMTYzNDk5LCAyMDE4LzA4LzEzLTE2OjQwOjIyICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdEV2dD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlRXZlbnQjIiB4bWxuczpkYz0iaHR0cDovL3B1cmwub3JnL2RjL2VsZW1lbnRzLzEuMS8iIHhtbG5zOnBob3Rvc2hvcD0iaHR0cDovL25zLmFkb2JlLmNvbS9waG90b3Nob3AvMS4wLyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxOSAoV2luZG93cykiIHhtcDpDcmVhdGVEYXRlPSIyMDIxLTA0LTA1VDE4OjI5OjE2KzA4OjAwIiB4bXA6TWV0YWRhdGFEYXRlPSIyMDIxLTA0LTA1VDE4OjI5OjE2KzA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAyMS0wNC0wNVQxODoyOToxNiswODowMCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDoxNzBhYmY1My00YzRmLWU3NGItYmY2Zi05OTUwMzVmOGJiOTciIHhtcE1NOkRvY3VtZW50SUQ9ImFkb2JlOmRvY2lkOnBob3Rvc2hvcDo3MTcwZWUxYi0wYjU3LWFlNDItYWQzMS1lOThjMDVmNGRkMjIiIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDoxMjdjY2YyYS03YTc4LTAyNDItOTZhZC0xYjRjNzI0YzVhZTciIGRjOmZvcm1hdD0iaW1hZ2UvcG5nIiBwaG90b3Nob3A6Q29sb3JNb2RlPSIzIj4gPHhtcE1NOkhpc3Rvcnk+IDxyZGY6U2VxPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0iY3JlYXRlZCIgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDoxMjdjY2YyYS03YTc4LTAyNDItOTZhZC0xYjRjNzI0YzVhZTciIHN0RXZ0OndoZW49IjIwMjEtMDQtMDVUMTg6Mjk6MTYrMDg6MDAiIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE5IChXaW5kb3dzKSIvPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0ic2F2ZWQiIHN0RXZ0Omluc3RhbmNlSUQ9InhtcC5paWQ6MTcwYWJmNTMtNGM0Zi1lNzRiLWJmNmYtOTk1MDM1ZjhiYjk3IiBzdEV2dDp3aGVuPSIyMDIxLTA0LTA1VDE4OjI5OjE2KzA4OjAwIiBzdEV2dDpzb2Z0d2FyZUFnZW50PSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxOSAoV2luZG93cykiIHN0RXZ0OmNoYW5nZWQ9Ii8iLz4gPC9yZGY6U2VxPiA8L3htcE1NOkhpc3Rvcnk+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+EpfU/wAAAYJJREFUaN7d2j0OAUEUB/BV0FFrHIATKMRHLXEDFRcgcQM3UDgBjROQiNU7A7VCKRrCW7HJ2MzOzDIf703x3+zMVL9kycy8FzyD4QzSgQSUEz0mkCdkTxkUPSqQxwdDFhS/bBkIC2pTgww4EFKg+KUEuQkw6EHsYCWBoAaxg54iBCWIHRQgl4wYNKDkxPwHSJzQJSg50fgD4hSUnMhBThow1kG8yakmiFUQb7KmGWIFlLZwMISJsjMBSlsYG4QYAaUtlCF3CxhtINHixhJEC0i02LcM+QskWixCro4wMailAxJl6RCSCSSDdBFAlEAySB5yRoRJBal8fzNkEC5IBVJHCmFBTR8g7z0c5U/raxNK8cfO3UVT+vsVHgNkkAV2AIUtSqaDGMZNY6h707imAMB0sNqbPFiNqABcXj4YuWLlTVYpAWxe0Fm55OZdmR4pAUxeYjspM+gsKzitk3hZ6PGm9OZFMVS1PI22I0K1YQB9S4eshYNMT4pXTTXetDl50Xj2Aj+wifZIFsLOAAAAAElFTkSuQmCC\"";
str += "                    width=\"30px\" style=\"margin-top: 150%;transform:rotate(180deg);\" onclick=\"preimg()\">";
str += "            </div>";
str += "";
str += "            <div class=\"actionimg\" id=\"actionimg\" onclick=\"action()\"></div>";
str += "";
str += "            <div id=\"buttonright\" class=\"button\">";
str += "                <img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAACXBIWXMAAC4jAAAuIwF4pT92AAAF0WlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDUgNzkuMTYzNDk5LCAyMDE4LzA4LzEzLTE2OjQwOjIyICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdEV2dD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlRXZlbnQjIiB4bWxuczpkYz0iaHR0cDovL3B1cmwub3JnL2RjL2VsZW1lbnRzLzEuMS8iIHhtbG5zOnBob3Rvc2hvcD0iaHR0cDovL25zLmFkb2JlLmNvbS9waG90b3Nob3AvMS4wLyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxOSAoV2luZG93cykiIHhtcDpDcmVhdGVEYXRlPSIyMDIxLTA0LTA1VDE4OjI5OjE2KzA4OjAwIiB4bXA6TWV0YWRhdGFEYXRlPSIyMDIxLTA0LTA1VDE4OjI5OjE2KzA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAyMS0wNC0wNVQxODoyOToxNiswODowMCIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDoxNzBhYmY1My00YzRmLWU3NGItYmY2Zi05OTUwMzVmOGJiOTciIHhtcE1NOkRvY3VtZW50SUQ9ImFkb2JlOmRvY2lkOnBob3Rvc2hvcDo3MTcwZWUxYi0wYjU3LWFlNDItYWQzMS1lOThjMDVmNGRkMjIiIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDoxMjdjY2YyYS03YTc4LTAyNDItOTZhZC0xYjRjNzI0YzVhZTciIGRjOmZvcm1hdD0iaW1hZ2UvcG5nIiBwaG90b3Nob3A6Q29sb3JNb2RlPSIzIj4gPHhtcE1NOkhpc3Rvcnk+IDxyZGY6U2VxPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0iY3JlYXRlZCIgc3RFdnQ6aW5zdGFuY2VJRD0ieG1wLmlpZDoxMjdjY2YyYS03YTc4LTAyNDItOTZhZC0xYjRjNzI0YzVhZTciIHN0RXZ0OndoZW49IjIwMjEtMDQtMDVUMTg6Mjk6MTYrMDg6MDAiIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE5IChXaW5kb3dzKSIvPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0ic2F2ZWQiIHN0RXZ0Omluc3RhbmNlSUQ9InhtcC5paWQ6MTcwYWJmNTMtNGM0Zi1lNzRiLWJmNmYtOTk1MDM1ZjhiYjk3IiBzdEV2dDp3aGVuPSIyMDIxLTA0LTA1VDE4OjI5OjE2KzA4OjAwIiBzdEV2dDpzb2Z0d2FyZUFnZW50PSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxOSAoV2luZG93cykiIHN0RXZ0OmNoYW5nZWQ9Ii8iLz4gPC9yZGY6U2VxPiA8L3htcE1NOkhpc3Rvcnk+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+EpfU/wAAAYJJREFUaN7d2j0OAUEUB/BV0FFrHIATKMRHLXEDFRcgcQM3UDgBjROQiNU7A7VCKRrCW7HJ2MzOzDIf703x3+zMVL9kycy8FzyD4QzSgQSUEz0mkCdkTxkUPSqQxwdDFhS/bBkIC2pTgww4EFKg+KUEuQkw6EHsYCWBoAaxg54iBCWIHRQgl4wYNKDkxPwHSJzQJSg50fgD4hSUnMhBThow1kG8yakmiFUQb7KmGWIFlLZwMISJsjMBSlsYG4QYAaUtlCF3CxhtINHixhJEC0i02LcM+QskWixCro4wMailAxJl6RCSCSSDdBFAlEAySB5yRoRJBal8fzNkEC5IBVJHCmFBTR8g7z0c5U/raxNK8cfO3UVT+vsVHgNkkAV2AIUtSqaDGMZNY6h707imAMB0sNqbPFiNqABcXj4YuWLlTVYpAWxe0Fm55OZdmR4pAUxeYjspM+gsKzitk3hZ6PGm9OZFMVS1PI22I0K1YQB9S4eshYNMT4pXTTXetDl50Xj2Aj+wifZIFsLOAAAAAElFTkSuQmCC\"";
str += "                    width=\"30px\" style=\"margin-top: 150%;\" onclick=\"nextimg()\">";
str += "            </div>";
str += "        </div>";
str += "";
str += "        <div class=\"describe\"></div>";
str += "    </div>";
str += "";
str += "</body>";
str += "";
str += "</html>";
// 展示页面



var imgarr;
var maximg;
var now;
var imgs;
// 创建开关
var btn = document.createElement("div");
btn.innerHTML = "<button style=\"width: 120px;height: 50px;position:fixed;top:10%;right:0;z-index:2147483647;font-size:20px;background-color: beige;\">抓取</button>";
document.querySelector("body").appendChild(btn);

btn.onclick = function () {
    // 获取当前页面的内容
    var htmlcontent = "";
    htmlcontent += document.querySelector("head").innerHTML.toString();
    htmlcontent += document.querySelector("body").innerHTML.toString();
    var patt = /(?:\/\/|\\\/\\\/)[^><{},:]+?\.(?:jpg|png)/igm;
    imgarr = htmlcontent.match(patt);
    maximg = imgarr.length;
    document.querySelector("head").remove();
    document.querySelector("body").outerHTML = str;
    Init();
}

function Init() {
    now = 0;
    var actionimg = document.getElementById("actionimg");
    for (let i = 0; i < maximg; i++) {
        createimg(actionimg, imgarr[i])
    }
    actionimg.firstChild.style.display = "block";
    numshow();
    imgs = actionimg.querySelectorAll("img");
}

function action() {
    if (document.getElementById("actionimg").className == "fullscreen actionimg") {
        document.getElementById("actionimg").className = "actionimg";
        document.getElementById("buttonleft").className = "button";
        document.getElementById("buttonright").className = "button";
        document.getElementById("numshow").className = "";
    } else {
        document.getElementById("actionimg").className = "fullscreen actionimg";
        document.getElementById("buttonleft").className = "fullscreenbuttonleft button";
        document.getElementById("buttonright").className = "fullscreenbuttonright button";
        document.getElementById("numshow").className = "fullscreennumshow";
    }
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