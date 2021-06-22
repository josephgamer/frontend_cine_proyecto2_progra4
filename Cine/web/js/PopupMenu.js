/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function alternar() {
    var refA = document.getElementById("page-mask");
    if (refA) {
        if (refA.style.display === "none" || refA.style.display === "") {
            refA.style.display = "block";
        } else {
            refA.style.display = "none";
        }
    }
}

function mostrar(idx) {
    var ref = document.getElementById("pop-up-img");
    if (ref) {
        switch (idx) {
            case 1:
                ref.src = "images/cat1.jpg";
                break;
            case 2:
                ref.src = "images/cat2.jpg";
                break;
            case 3:
                ref.src = "images/cat3.jpg";
                break;
            case 4:
                window.onload =  new init2();
                break;
            default:
                ref.src = "images/cat0.png";
        }
        console.log({idx: idx, src: ref.src});
        alternar();
    }
}