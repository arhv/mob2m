$(document).ready(function () {
	             $("#formNewCustomer").validate({
	                 rules: {
	                     'customer_name': {
	                         required: true,
	                        // minlength: 5,
	                        //maxlength: 100
	                     }
	                     
	                 },
	                
	             });
	         });