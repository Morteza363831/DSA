const link = document.querySelector('a');
link.addEventListener('click', function(event) {
  event.preventDefault();  
  const id = this.getAttribute('href');  
  document.querySelector(id).scrollIntoView({
    behavior: 'smooth'
  });
});

const spans = document.querySelectorAll("span");
window.addEventListener('scroll' , () => {
  const scrollPos = window.scrollY;

  spans.forEach((span) => {
    const spanTop = span.offsetTop;
    const spanHeight = span.clientHeight;

    if (scrollPos > spanTop + spanHeight + 40) {
      span.style.color = "#2F89FC";
    }
  });
});