$(function() {
	$('.select').change(function(e) {
		var $this = $(this);
		var c = $this.find('option:selected').data('color');
		$this.css({ 'color': c, 'border-color': c });
	});
	$('.ex-select').each(function() {
		var $this = $(this);
		$this.trigger('change');
		$this.find('option').each(function() {
			$(this).css('color', $(this).data('color'));
		});
	});
});

const open = () => {
	document.querySelector(".modal").classList.remove("hidden");
}

const close = () => {
	document.querySelector(".modal").classList.add("hidden");
}


const openBtn = document.querySelectorAll(".openBtn");
openBtn.forEach(e => {
	e.addEventListener("click", open);
})

const closeBtn = document.querySelectorAll(".closeBtn");
closeBtn.forEach(e => {
	e.addEventListener("click", close);
})

const bg = document.querySelectorAll(".bg");
bg.forEach(e => {
	e.addEventListener("click", close);
})