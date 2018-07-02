$(document).ready(function() {
	$("#service_name1").change(function() {		
		$.ajax({				
				//url: "http://localhost:8080/servicesSelection/"+$("#service_name1").val(),
				url: "http://www.riomam.com.br/servicesSelection/"+$("#service_name1").val(),
				dataType: 'json',
	            type: 'GET',
	            data: {serviceId : $('#service_name1').val()},
	            success: function(data){	            	
	            	$("#service_value1").val(data);
	            },
	            error: function(jqXHR, textStatus, errorThrown) {
	                alert(errorThrown);
	            }
		});
	});
});



