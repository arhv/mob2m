	
	//##### Verify email is valid #### //
	$("#checkUserEmail").click(function(event){
		event.preventDefault();		
		$.ajax({				
			url: "http://localhost:8080/checkuseremail/"+$("#userEmailCheck").val(),
			dataType: 'json',
            type: 'GET',
            data: {email : $('#userEmailCheck').val()},           
            success: function(data){
            	if (data == 1){
            		alert("Este email já existe ! Por favor escolher um outro email !");
            		$("#checkUserEmail").focusin();            			            		
            	}else if (data == 0){            		
            		$("#saveCancelButtonsUsernameEmail").show();
            	}        	
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }            
            
	});
	});
	//##### Verify email is valid #### //




