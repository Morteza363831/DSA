var click_counter = 0;
function changeDisplay(target){
    switch (target) {
        case d :
                target.style.display = "flex";
                document.getElementById("m").style.display = 'none';
                document.getElementById("mu").style.display = 'none';
                document.getElementById("f").style.display = 'none';
                document.getElementById("e").style.display = 'none';
            break;
        case m :
                target.style.display = "flex";
                document.getElementById("d").style.display = 'none';
                document.getElementById("mu").style.display = 'none';
                document.getElementById("f").style.display = 'none';
                document.getElementById("e").style.display = 'none';
            break;
            case mu : 
                target.style.display = "flex";
                document.getElementById("d").style.display = 'none';
                document.getElementById("m").style.display = 'none';
                document.getElementById("f").style.display = 'none';
                document.getElementById("e").style.display = 'none';
            break;
            case f : 
                target.style.display = "flex";
                document.getElementById("d").style.display = 'none';
                document.getElementById("mu").style.display = 'none';
                document.getElementById("m").style.display = 'none';
                document.getElementById("e").style.display = 'none';
            break;
            case e :
                target.style.display = "flex";
                document.getElementById("d").style.display = 'none';
                document.getElementById("mu").style.display = 'none';
                document.getElementById("f").style.display = 'none';
                document.getElementById("m").style.display = 'none';
            break;
            case toggle_div :
                click_counter++;
                if (click_counter === 1) {
                    target.style.display = "flex";
                }
                else if (click_counter === 2) {
                    target.style.display = "none";
                    click_counter = 0;
                }
            break;
    }
}

function change(target) {
    switch (target) {
        case panel1 :
            target.style.display = "flex";
            document.getElementById("panel2").style.display = 'none';
            document.getElementById("panel3").style.display = 'none';
            document.getElementById("b1").style.backgroundColor = '	rgb(0,255,255, 0.2)';
            document.getElementById("b2").style.backgroundColor = 'white';
            document.getElementById("b3").style.backgroundColor = 'white';
        break;
        case panel2 :
            target.style.display = "flex";
            document.getElementById("panel1").style.display = 'none';
            document.getElementById("panel3").style.display = 'none';
            document.getElementById("b1").style.backgroundColor = 'white';
            document.getElementById("b2").style.backgroundColor = 'rgb(0,255,255, 0.2)';
            document.getElementById("b3").style.backgroundColor = 'white';
        break;
        case panel3 :
            target.style.display = "flex";
            document.getElementById("panel2").style.display = 'none';
            document.getElementById("panel1").style.display = 'none';
            document.getElementById("b1").style.backgroundColor = 'white';
            document.getElementById("b2").style.backgroundColor = 'white';
            document.getElementById("b3").style.backgroundColor = 'rgb(0,255,255, 0.2)';
        break;
    }
}


