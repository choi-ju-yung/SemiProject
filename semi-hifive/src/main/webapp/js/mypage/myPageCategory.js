$(".goToStoreBtn").mouseover(e => {
	$(".goToStoreIcon").css("color", "white");
	$(".goToStore").css("color", "white");
	$(".goToStoreBtn").css("background-color", "#20C997");
});

$(".goToStoreBtn").mouseleave(e => {
	$(".goToStoreIcon").css("color", "#20C997");
	$(".goToStore").css("color", "#20C997");
	$(".goToStoreBtn").css("background-color", "white");
});