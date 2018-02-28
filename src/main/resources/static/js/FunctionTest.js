$(document).ready(function(){
	//$('#mainDiv').on('click', function(e){  
	// e.preventDefault( );
	    
	    $("#btn1").click(function(){
	    	alert("You clicked btn1 !");
	        //$("#mainDiv").html("index.html");
	    	//testPage();
	    	
	    });	
});

	/*function testPage(){
		$.ajax({url:"index.html", 
				type: "GET",
				dataType: "text",
				success:function(response){
					console.log('the page jas been loaded',response);
					$('#mainDiv').html(response);
					},
				error:function(error){
					console.log('error loading: ',error);
				},
				complete:function(xhr,status){
					console.log('call completed');
				}
			});
	}
});*/