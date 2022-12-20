let heart = document.querySelectorAll(".fa-heart");

heart.forEach((target) => target.addEventListener("click", clickHeart));
// heart.forEach((target) => target.classList.contains);
function clickHeart(event) {
  let targetClass = event.target.classList;
  targetClass.toggle("fa-heart--red");
  if (targetClass.contains("fa-heart--red")) {
    targetClass.remove("fa-regular");
    targetClass.add("fa-solid");
  } else {
    targetClass.remove("fa-solid");
    targetClass.add("fa-regular");
  }
}

var swiper = new Swiper(".wrap", {
  pagination: {
    el: ".swiper-pagination",
    type: "fraction",
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
  slidesPerView: "auto",
  spaceBetween: 100,
  loop: true,
  centeredSlides: true,
  speed: 1000,
  // direction: "horizontal",
  //   세로 vertical 기본값은 가로 horizontal
  effect: "coverflow",
  coverflowEffect: {
    rotate: 5, //회전값
    stretch: -100, //+면 당김 -면 벌림
    depth: 400, //원근감 깊이
    modifier: 1, //부여한 효과 배수로 늘림 1배 2배...
    slideShadows: false, //그림자
  },
});
