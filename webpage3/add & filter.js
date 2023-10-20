/*function getPropertys() {
    var model = document.getElementById("model").value;
    var cpu = document.getElementById("cpu").value;
    var gpu = document.getElementById("gpu").value;
    var ram = document.getElementById("ram").value;
    var color = document.getElementById("color").value;
    var price = document.getElementById("price").value;
}*/
var models = ['asus','asus','lenovo','mac','mac','hp','lenovo','asus','mac','hp','hp','mac','lenovo','lenovo','asus','mac','lenovo'];
var cpus = ['1165G7','1135G5','1165G7','1135G5','1165G7','1065G3','1165G7','1065G3','1165G7','1065G3','1135G5','1065G3','1165G7','1065G3','1135G5','1165G7','1065G3'];
var gpus = ['mx330','mx450','mx450','mx350','mx330','mx450','mx350','mx330','mx450','mx350','mx350','mx350','mx330','mx450','mx350','mx350','mx330'];
var rams = ['4','8','16','32','4','32','32','16','8','16','hp','16','32','4','8','32','8'];
var colors = ['black','white','gray','blue','blue','black','black','blue','gray','white','gray','white','black','gray','black','gray','lenovo'];
var prices = ['1000$','500$','10000$','700$','500$','500$','700$','10000$','500$','700$','1000$','700$','1000$','10000$','1000$','10000$','1000$'];
var laptopImages = [
'images/1.jpg',
'images/2.jpg',
'images/3.jpg',
'images/4.jpg',
'images/5.jpg',
'images/6.jpg',
'images/7.jpg',
'images/8.jpg',
'images/9.jpg',
'images/10.jpg',
'images/11.jpg',
'images/12.jpg',
'images/13.jpg',
'images/14.jpg',
'images/15.jpg',
'images/16.jpg',
];

function add() {
    for (let i =0; i<laptopImages.length; i++) {
        const a = document.createElement("a");
        a.className = "laptop_a";
        a.href = "#";
        a.innerHTML += "<img src='" + laptopImages[i] + "'/>";
        a.innerHTML += "<h2> MODEL :" + models[i] + "</h2>";
        a.innerHTML += "<h3> CPU :" + cpus[i] + "</h3>";
        a.innerHTML += "<h3> VIDEO CARD :" + gpus[i] + "</h3>";
        a.innerHTML += "<h3> RAM :" + rams[i] + "</h3>";
        a.innerHTML += "<h3> COLOR :" + colors[i] + "</h3>";
        a.innerHTML += "<h3> PRICE :" + prices[i] + "</h3>";
        document.getElementById("laptop_article").appendChild(a);
    }
    };
    add();
    
    function filter() {
        const index = [];
        const bool = [];
        var model = document.getElementById("model").value;
        var cpu = document.getElementById("cpu").value;
        var gpu = document.getElementById("gpu").value;
        var ram = document.getElementById("ram").value;
        var color = document.getElementById("color").value;
        var price = document.getElementById("price").value;
        function sort() {
            /********1 */
        if (model != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model) {
                    index.push(i);
                }
            }
        }
        if (cpu != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == model) {
                    index.push(i);
                }
            }
        }
        if (gpu != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu) {
                    index.push(i);
                }
            }
        }
        if (ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /*************model 2 */
        if (model != "" && cpu != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu) {
                    index.push(i);
                }
            }
        }
        if (model != "" && gpu != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && gpus[i] == gpu) {
                    index.push(i);
                }
            }
        }
        if (model != "" && ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (model != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (model != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /*********cpu 2 */
        if (cpu != "" && gpu != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && gpus[i] == gpu) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /**********gpu 2 */
        if (gpu != "" && ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu && rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (gpu != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (gpu != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /**********ram 2 */
        if (ram != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (rams[i] == ram && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (ram != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (rams[i] == ram && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /*********color price */
        if (color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (prices[i] == price && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        /**********model 3 */
        if (model != "" && cpu != "" && gpu != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && gpus[i] == gpu) {
                    index.push(i);
                }
            }
        }
        if (model != "" && cpu != "" && ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (model != "" && cpu != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (model != "" && cpu != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (model != "" && gpu != "" && ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && gpus[i] == gpu && rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (model != "" && gpu != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && gpus[i] == gpu && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (model != "" && gpu != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && gpus[i] == gpus && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (model != "" && ram != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && rams[i] == ram && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (model != "" && ram != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && rams[i] == ram && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (model != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /************cpu 3 */
        if (cpu != "" && gpu != "" && ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && gpu != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && gpus[i] == gpu && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && gpu != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && gpus[i] == gpu && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && ram != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && rams[i] == ram && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && ram != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && rams[i] == ram && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /**************gpu 3 */
        if (gpu != "" && ram != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu && rams[i] == ram && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (gpu != "" && ram != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu && rams[i] == ram && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (gpu != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /*******ram color price */
        if (ram != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (rams[i] == ram && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /*********model 4 */
        if (model != "" && cpu != "" && gpu != "" && ram != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram) {
                    index.push(i);
                }
            }
        }
        if (model != "" && cpu != "" && gpu != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && gpus[i] == gpu && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (model != "" && cpu != "" && gpu != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && gpus[i] == gpu && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (model != "" && gpu != "" && ram != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && gpus[i] == gpu && rams[i] == ram && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (model != "" && gpu != "" && ram != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && gpus[i] == gpu && rams[i] == ram && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (model != "" && ram != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && rams[i] == ram && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /************cpu 4 */
        if (cpu != "" && gpu != "" && ram != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && gpu != "" && ram != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && ram != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && rams[i] == ram && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /*******gpu ram color price */
        if (gpu != "" && ram != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (gpus[i] == gpu && rams[i] == ram && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /************ model 5*/
        if (model != "" && cpu != "" && gpu != "" && ram != "" && color != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram && colors[i] == color) {
                    index.push(i);
                }
            }
        }
        if (model != "" && cpu != "" && gpu != "" && ram != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        if (cpu != "" && gpu != "" && ram != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        /******6 */
        if (model != "" && cpu != "" && gpu != "" && ram != "" && color != "" && price != "") {
            index.length = 0;
            for (let i =0; i<models.length; i++) {
                if (models[i] == model && cpus[i] == cpu && gpus[i] == gpu && rams[i] == ram && colors[i] == color && prices[i] == price) {
                    index.push(i);
                }
            }
        }
        }
        sort();
        /*****************filter */
        const article = document.getElementById("laptop_article");
        while (article.firstChild) {
            article.removeChild(article.firstChild);
        }
        for (let i =0; i<index.length; i++) {
            const a = document.createElement("a");
            a.className = "laptop_a";
            a.href = "#";
            a.innerHTML += "<img src='" + laptopImages[index[i]] + "'/>";
            a.innerHTML += "<h2> MODEL :" + models[index[i]] + "</h2>";
            a.innerHTML += "<h3> CPU :" + cpus[index[i]] + "</h3>";
            a.innerHTML += "<h3> VIDEO CARD :" + gpus[index[i]] + "</h3>";
            a.innerHTML += "<h3> RAM :" + rams[index[i]] + "</h3>";
            a.innerHTML += "<h3> COLOR :" + colors[index[i]] + "</h3>";
            a.innerHTML += "<h3> PRICE :" + prices[index[i]] + "</h3>";
            document.getElementById("laptop_article").appendChild(a);
        }
    }