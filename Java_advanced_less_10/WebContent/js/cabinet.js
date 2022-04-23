let book = null;

$.get("product", function(data) {
	if (data !== '') {
		books = data;
	}
}).done(function() {
	
	let cardsContent = "";
	jQuery.each(book, function(i, value) {
	
		cardsContent+="<div class='col'>" +
					  "<div class='card'>" +
					  "<div class='card-body'>" +
					  "<h5 class='card-book'>" + value.book + "</h5>"+
					  "<h5 class='card-author'>" + value.author + "</h5>"+
					  "<h5 class='card-ganre'>" + value.ganre + "</h5>"+
					  "<p class='card-cod'>" + value.cod + "</p>"+
					  "<h6 class='card-price mb-2 text-muted'>" + value.price + "</h6>"+				
					  "<a href='books?id=" + value.id + "' class='card-link'>link</a>"+
					  "</div>" +
					  "</div>" +
					  "</div>" +
					  "</div>"
	});
	
	  $('#productCards').html(cardsContent);
	
});