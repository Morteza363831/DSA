
const sliderImages = [
    "images/news1.jpg",
    "images/news2.jpg",
    "images/news3.jpg",
];
var imageDiv = document.getElementById("news_section-div");
var currentImage = 0;

function renderImages() {
    sliderImages.forEach((image) => {
        imageDiv.innerHTML += "<img src='" + image + "' class= 'news_images' />";
    });
}

function clearImages() {
    const imgs = document.querySelectorAll(".news_images");
    imgs.forEach((image) => {
        image.style.opacity = 0;
    });
}

function showImage(image) {
    clearImages();
    document.getElementsByTagName("img")[image].style.opacity = 1;
}

function init() {
    renderImages();
    showImage(currentImage);
}
  
init();

let next = document.querySelector("#nextButton");

next.onclick = function() {
  currentImage++;
  if (currentImage > sliderImages.length-1) {
    currentImage = 0;
  }
  showImage(currentImage);
};

let prev = document.querySelector("#prevButton");

prev.onclick = function() {
  currentImage--;
  if(currentImage <= -1) {
    currentImage = sliderImages.length-1;
  }
  showImage(currentImage);
}

const navButton = document.getElementById('nav_button');
const navLinks = document.getElementById('header2_ul');

navButton.addEventListener('click', toggleNavLinks);

function toggleNavLinks() {
  navLinks.classList.toggle('show');
}