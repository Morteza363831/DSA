/*change background header*/
function scrollHeader() {
    const header =document.getElementById('header');
    if(this.scrollY >= 50) {
        header.classList.add('scroll-header');
    }
    
}
window.addEventListener('scroll',scrollHeader);
/*swiper poppular*/
var swiperPopular = new Swiper(".popular__container", {
    spaceBetween:32,
    grabCursor:true,
    centerSlides:true,
    slidesPerView:'auto',
    loop: true,
    
  });
  /* value */
  const accordionItems = document.querySelectorAll('.value__accordion-item');
  accordionItems.forEach((item) => {
    const accordionHeader = item.querySelector('.value__accordion-header');
    accordionHeader.addEventListener('click' , () => {
      const openItem = document.querySelector('.accordion-open');

      toggleItem(item);
      
      if(openItem && openItem!== item) {
        console.log(item);
        toggleItem(openItem);
      }
    })
  })
  const toggleItem = (item) => {
    const accordionContent = item.querySelector('.value__accordion-content');

    if(item.classList.contains('accordion-open')) {
      accordionContent.removeAttribute('style');
      item.classList.remove('accordion-open');

    } 
    else {
      accordionContent.style.height = accordionContent.scrollHeight + 'px';
      item.classList.add('accordion-open');
    }
    
  }