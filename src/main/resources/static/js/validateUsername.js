 
	 $("#checkUsername").click(function() {		
			$.ajax({				
					//url: "http://localhost:8080/checkusername/"+$("#usernameCheck").val(),
					url: "http://www.riomam.com.br/checkusername/"+$("#usernameCheck").val(),
					dataType: 'json',
		            type: 'GET',
		            data: {username : $('#usernameCheck').val()},
		            success: function(data){            
		            	if (data == 1){
		            		alert("Este usuário já existe ! Por favor escolher um outro nome de usuário !");
		            		$("#usernameCheck").focusin();	            			            		
		            	}else if (data == 0){
		            		checkUserEmailExists();
		            	}      	
		            	
		            },
		            error: function(jqXHR, textStatus, errorThrown) {
		                alert(errorThrown);
		            }	            	            
			});			
		});	

			
 
 
function checkUserEmailExists() {	
	$("#emailCheck").show();	
};


	



