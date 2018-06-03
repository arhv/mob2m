$(document).ready(function() {
	$("#estado").change(function() {		
		$.ajax({				
				url: "http://localhost:8080/listStates/"+$("#estado").val(),
				//url: "http://www.riomam.com.br/listStates/"+$("#estado").val(),
				dataType: 'json',
	            type: 'GET',
	            data: {state : $('#state').val()},
	            success: function(data){
	            	$("#cidade").empty();
	            	for (row in data) {
	            		$('#cidade').append($("<option></option>").attr("value", data[row].cod_cidades).text(data[row].cityName));
	            	}
	            },
	            error: function(jqXHR, textStatus, errorThrown) {
	                alert(errorThrown);
	            }
		});
	});
});



