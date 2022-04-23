$("button.addBook")
		.click(
				function() {
					
					let bookName = $("form.addBook input.bookName").val();
					let authorBook = $("form.addBook input.authorBook").val();
					let ganreBook = $("form.addBook input.ganreBook").val();
					let priceBook = $("form.addBook input.priceBook").val();
					let codBook = $("form.addBook input.codBook").val();
						let books = {
								bookName : bookName,
								authorBook : authorBook,
								ganreBook : ganreBook,
								priceBook : priceBook,
								codBook : codBook
								
						};
//add validation
						$.post("product", books,
								function(data) {
									if (data == 'Success') {
										alert('Success');
									}
								});
					
				});


$("button.buy-product").click(function() {
	let book_id = jQuery(this).attr("product-id");
	
	
	$.post("bucket", {'book_id':book_id},
			function(data) {
				if (data == 'Success') {
					$("[data-dismiss=modal]").trigger({ type: "click" });
					alert('Success');
				}
			});
});
