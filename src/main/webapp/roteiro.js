$(document).ready(function () {
	$("#cadastradas").on("click", "li",function () {
			//Váriavel para checar se já existe na lista
			var chkRptTag = false;
			var atv = $(this).text();
			$('#salvar li').each(function () {
				haveSomeLi = true;
				var current = $(this).text();
				if (current == atv) {
					chkRptTag = true;
				}
			});
			if (!chkRptTag) {
				$("#salvar").append("<li class='list-group-item' value='" + $(this).val() +"'>" + $(this, "option:selected").text() + "<input type='checkbox' name='salvar' id='salvar' class='chkTags' checked='checked' value='" + $(this, "option:selected").val() + "'></li>");
				$(this).remove();
			}
		});
	$('#salvar').on('click', 'li', function () {
		$("#cadastradas").append("<li class='list-group-item' name='multiselect' value='" + $(this).val() + "'>" + $(this).text() + "</li>");
		$(this).remove();			
		return false;
	});
});