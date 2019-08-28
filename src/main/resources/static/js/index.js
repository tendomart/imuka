let showBox = ()=>{
    const x = document.getElementById('popup_container');
    x.style.display="block";
}
let hideBox = ()=>{
    let shut = document.getElementById("popup_container");
    shut.addEventListener("click",()=>{
        x = shut.style.display="none";
    })

}

//image slider rules
var slideIndex = 1;
//invoking the showSlides function
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}
// show slides function to make the images slide
function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1} 
  if (n < 1) {slideIndex = slides.length} ;
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none"; 
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].classList.remove("active");
  }
  slides[slideIndex-1].style.display = "block"; 
  dots[slideIndex-1].classList.add("active");
}
class human{
constructor(name, age){
this.name = name;
this.age= age;

}
talk(){

}

}


$(document).ready(function () {

    $("#guest-form").submit(function (event) {

        //stop submit the form event. Do this manually using ajax post function
        event.preventDefault();

        var loginForm = {}
        loginForm["district"] = $("#district").val();
        loginForm["gender"] = $("#gender").val();
        loginForm["job"] = $("#job").val();
        loginForm["interest"] = $("#interest").val();
        loginForm["country"] = $("#country").val();
        

        $("#btn").prop("disabled", true);
        
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/imuka/rs",
            data: JSON.stringify(loginForm),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);

                console.log("SUCCESS : ", data);
                $("#btn").prop("disabled", false);

            },
            error: function (e) {

                var json = "<h4>Ajax Response Error</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-login").prop("disabled", false);

            }
        });
        
    });

});