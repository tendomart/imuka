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



function alert1()
            {Swal.fire({
            	position: 'center',
            	type: 'success',
            	title: 'Your work has been saved',
            	showConfirmButton: false,
            	timer: 2000
            	})}
 
 function alert2()
 {
	 Swal.fire({   
     title: 'Alert Auto Close!',   text: '2Seconds',   
     timer: 2000 });
 }
 function alert3(){
	 Swal.fire
     ({   title: 'Delete?',   text: 'Confirm Delete!',   
     type: 'warning',   showCancelButton: true,   
     confirmButtonColor: '#3085d6',   cancelButtonColor: '#d33',   
     confirmButtonText: 'Yes,delete it!',   
     closeOnConfirm: false });
     
 }
 
 function alert4(){
	 Swal.fire
     ({   title: 'Welcome to Imuka Access',   
    	  text: 'Please Feel Form to help us Make Service Better',  
    	  confirmButtonColor:'green',
    	  confirmButtonText:'Enter',
    	  closeOnConfirm:'true',
        animation: true,
        confirmButtonText: "OK",
//        ,
//        
//    	formFields:[
//    		{id:'gender',placeholder:'Your Gender',required},
//    		{id:'interest',placeholder:'Your Interest',required},
//    		{id:'job',placeholder:'Job / Career',required},
//    		{id:'monthly_income',placeholder:'Your Monthly Income',required},
//    		{id:'district',placeholder:'District if Origin',required}
//    	]
     
     });
 }
 
 
 
 
// function guest(){
//Swal.file.withForm({
//	title:'Welcome to Imuka Access',
//	text:'Please Feel Form to help us Make Service Better',
//	confirmButtonColor:'#DD6B55',
//	confirmButtonText:'Enter',
//	closeOnConfirm:'true',
//	formFields:[
//		{id:'gender',placeholder:'Your Gender',required},
//		{id:'interest',placeholder:'Your Interest',required},
//		{id:'job',placeholder:'Job / Career',required},
//		{id:'monthly_income',placeholder:'Your Monthly Income',required},
//		{id:'district',placeholder:'District if Origin',required}
//	]
//
//	
//},
//
//function(isConfirm)	{
//	//do staff here
//	//post data
//});
// }
 
 
 