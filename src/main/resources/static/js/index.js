 let showBox = ()=>{
	    const x = document.getElementById('popup_container');
	    x.style.display="block";
	}
	let hideBox = ()=>{
	    let shut = document.getElementById("popup_container");
	    let  district = document.getElementById("district"); 
	    
//	    shut.addEventListener("click",()=>{
// 	        x = shut.style.display="none";
// 	    })
 	    
	    if(district.value=='- - -'){
	    	
	    	 alert('Field Is empty');
	    }
	    else{
	    	shut.addEventListener("click",()=>{
	 	        x = shut.style.display="none";
	 	    })

	    }
	   
	}

	var prefix = '/imuka';
	
function validate(){
	
	
}


//$("#anonymous_user").submit(function(event){
//	event.preventDefault(); //prevent default action 
//	var post_url = $(this).attr("action"); //get form action url
//	var form_data = $(this).serialize(); //Encode form elements for submission
//	
//	$.post( post_url, form_data, function( response ) {
//	  $("#server-results").html( response );
//	});
//});


//$(function () {
//    $('#submitButton').click(function (e) {
// 
//        //Prevent default submission of form
//        e.preventDefault();
// 
//        //Remove previous errors
//        $('input').next('span').remove();
// 
//        $.post({
//            url: '/imuka/guest',
//            data: $('#anonymous_user').serialize(),
//            success: function (res) {
//                if (res.validated) {
//                    //take your successful action here; you may want to redirect to another page
//                    alert("Registration Successful");
//                } else {
//                    $.each(res.errorMessages, function (key, value) {
//                        $('input[name=' + key + ']').after('<span class="error">' + value + '</span>');
//                    });
//                }
//            }
//        })
//    });
// 
//});
