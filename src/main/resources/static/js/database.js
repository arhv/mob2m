$(document).ready(function(){
	
		$("#agenda").click(function() {
			
			var htmlAgenda = ("<h1>Test</h1>");
			
		})
	    
	    $("#btn1").click(function(){
	    	
	    	
	    	var returnlHtml = ("<h2>Expenses Table</h2><table id=\"expensesTable\" class=\"table table-sm table-striped table-hover table-bordered\"> " +
	    				"<!-- Header Table --><thead><tr><th>Id</th><th>category</th><th>item</th>" +
	    				"<th>purchase_location</th><th>amount</th><th>payment_type</th>" +
	    				"<th>purchase_date</th></tr></thead></table>");   				
	    	
	    	
	    	$("#mainDiv").append(returnlHtml);
	    	
	    	$("#btn1").prop("disabled", true)
	    	
	    	var table = $('#expensesTable').DataTable({
				"sAjaxSource": "/expensesAll",
				"sAjaxDataProp": "",
				"order": [[ 0, "asc" ]],
				"aoColumns": [
				    { "mData": "id"},
				    { "mData": "category" },
					{ "mData": "item" },
					{ "mData": "purchase_location" },
					{ "mData": "amount" },
					{ "mData": "payment_type" },
					{ "mData": "purchase_date" }					
				]
	    	})
	    })
});