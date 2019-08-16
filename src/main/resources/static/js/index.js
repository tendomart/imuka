
const Swal = require('sweetalert2')

import Swal from 'sweetalert2/dist/sweetalert2.js'

import 'sweetalert2/src/sweetalert2.scss'

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


function success(){
	Swal.fire({
		position: 'center',
		type: 'success',
		title: 'Your work has been saved',
		showConfirmButton: false,
		timer: 2000
		})
}