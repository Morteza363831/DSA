let showBarCounter = 0;
var screenWidth = window.innerWidth;



function showBar(target) {
    showBarCounter++;
    if (showBarCounter == 1) {
        target.style.display = "flex";
    }
    else if (showBarCounter == 2) {
        target.style.display = "none";
        showBarCounter = 0;
    }
}
function changeproperty(h3_1,h3_2,h3_3,p_1,p_2,p_3,button_type) {
    switch (button_type) {
        case section3_b1 :
            section3_b1.addEventListener("click", () => {
                document.getElementById("section3_div2").style.opacity = 0; // Fade out
                
                setTimeout(() => {
                    h3_1.innerText = "Lorem ipsum dolor sit amet1";
                    h3_2.innerText = "Lorem ipsum dolor sit amet1";
                    h3_3.innerText = "Lorem ipsum dolor sit amet1";
                    p_1.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                    p_2.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                    p_3.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                    
                    document.getElementById("section3_div2").style.opacity = 1; // Fade in                     
                }, 300);
              });
            
            break;
            case section3_b2 :
                section3_b2.addEventListener("click", () => {
                    document.getElementById("section3_div2").style.opacity = 0; // Fade out
                    
                    setTimeout(() => {
                        h3_1.innerText = "Lorem ipsum dolor sit amet2";
                        h3_2.innerText = "Lorem ipsum dolor sit amet2";
                        h3_3.innerText = "Lorem ipsum dolor sit amet2";
                        p_1.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                        p_2.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                        p_3.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                        
                        document.getElementById("section3_div2").style.opacity = 1; // Fade in 
                    }, 300);
                  });
                
        break;
        case section3_b3 :
            section3_b3.addEventListener("click", () => {
                document.getElementById("section3_div2").style.opacity = 0; // Fade out
                
                setTimeout(() => {
                    h3_1.innerText = "Lorem ipsum dolor sit amet3";
                    h3_2.innerText = "Lorem ipsum dolor sit amet3";
                    h3_3.innerText = "Lorem ipsum dolor sit amet3";
                    p_1.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                    p_3.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                    p_3.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                
                    document.getElementById("section3_div2").style.opacity = 1; // Fade in                     
                }, 300);
              });
            
        break;
        case section3_b4 :
            section3_b4.addEventListener("click", () => {
                document.getElementById("section3_div2").style.opacity = 0; // Fade out
                
                setTimeout(() => {
                    h3_1.innerText = "Lorem ipsum dolor sit amet4";
                    h3_2.innerText = "Lorem ipsum dolor sit amet4";
                    h3_3.innerText = "Lorem ipsum dolor sit amet4";
                    p_1.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                    p_2.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";
                    p_3.innerText =  "Vel tempore numquam aut rerum recusandae eos iure quos. Ut voluptas voluptas ex sint quia qui dolorem odio qui tenetur recusandae est quas fuga et architecto voluptatibus quo sint fuga. Vel voluptatem libero qui quia repellat id internos molestias. Et voluptas aliquam vel amet doloribus aut dolore optio qui odio consequatur qui doloribus rerum At autem voluptates.";

                    document.getElementById("section3_div2").style.opacity = 1; // Fade in                     
                }, 300);
              });
            
        break

    }
}

let imgName = "img1";
function changeImg_n(img1,img2,img3) {
    switch (imgName) {
        case "img1" :
            img1.style.display = "flex";
            img2.style.display = "none";
            img3.style.display = "none";
            imgName= "img2";
        break;
        case "img2" :
            img1.style.display = "none";
            img2.style.display = "flex";
            img3.style.display = "none";
            imgName = "img3";
        break;
        case "img3" :
            img1.style.display = "none";
            img2.style.display = "none";
            img3.style.display = "flex";
            imgName = "img1";
        break;
    }
}
function changeImg_p(img1,img2,img3) {
    switch (imgName) {
        case "img1" :
            img1.style.display = "none";
            img2.style.display = "none";
            img3.style.display = "flex";
            imgName = "img3";
        break;
        case "img2" :
            img1.style.display = "flex";
            img2.style.display = "none";
            img3.style.display = "none";
            imgName = "img1";
        break;
        case "img3" :
            img1.style.display = "none";
            img2.style.display = "flex";
            img3.style.display = "none";
            imgName = "img2";
        break;
    }
}

window.addEventListener("scroll", () => {
    let scrollHeight = window.pageYOffset;
    // Use scrollHeight
    if (scrollHeight > 50) {
        if (screenWidth <= 768) {
            document.getElementById("img1").style.width = "100%";
        }
        else {
            document.getElementById("img1").style.width = "58%";
        }
    }
    if (scrollHeight > 400) {
        if (screenWidth <= 768) {
            document.getElementById("img2").style.width = "100%";
        }
        else {
            document.getElementById("img2").style.width = "58%";
        }
    }
    if (scrollHeight> 850) {
        document.getElementById("section3_b1").style.opacity = "1";
        document.getElementById("section3_b2").style.opacity = "1";
        document.getElementById("section3_b3").style.opacity = "1";
        document.getElementById("section3_b4").style.opacity = "1";
    }
    if (scrollHeight> 1500) {
        document.getElementById("section4_article1").style.opacity = "1";
        document.getElementById("section4_article2").style.opacity = "1";
        document.getElementById("section4_article3").style.opacity = "1";
    }
  });
  
  let currentIndex = 0;




  const link = document.querySelector('a');
  link.addEventListener('click', function(event) {
    event.preventDefault();  
    const id = this.getAttribute('href');  
    document.querySelector(id).scrollIntoView({
      behavior: 'smooth'
    });
  });