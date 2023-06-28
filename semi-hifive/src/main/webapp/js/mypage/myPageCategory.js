const context = "http://localhost:9090/semi-hifive/";
const userId = sessionStorage.getItem("loginId");

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

$(".goToStoreBtn").click(e=>{
	location.assign(context + "/shop?id=" + userId);
});