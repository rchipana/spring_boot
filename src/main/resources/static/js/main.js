/**
 * 
 */
$(document).ready(function() {
	$('.nBtn, .table .eBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if (text == 'Edit') {
			$.get(href, function(cliente, status) {
				$('.myForm #id').val(cliente.id);
				$('.myForm #nombre').val(cliente.nombre);
				$('.myForm #apellido').val(cliente.apellido);
				$('.myForm #email').val(cliente.email);
				$('.myForm #createAt').val(cliente.createAt);

			});

			$('.myForm #exampleModal').modal();

		} else {
			$('.myForm #id').val('');
			$('.myForm #nombre').val('');
			$('.myForm #apellido').val('');
			$('.myForm #email').val('');
			$('.myForm #createAt').val('');

			$('.myForm #exampleModal').modal();

		}
	});
});


$(document).ready(function() {
	$('#saveCliente').submit(function(e) {
		$.post('/save', $(this).serialize(), function(cliente) {
                window.location.href = "/listar";
                $('.myForm #exampleModal').modal('hide');

            
		});
		
		e.preventDefault();

	});

});


$(document).ready(function () {
    (function ($) {
        $('#filtrar').keyup(function () {
            var rex = new RegExp($(this).val(), 'i');
            $('.buscar tr').hide();
            $('.buscar tr').filter(function () {
                return rex.test($(this).text());
            }).show();
        })
    }(jQuery));
});



/*

$("#saveCliente").submit(function () {
    var data = $("#saveCliente").serialize();
    $.ajax({
        type: "Post",
        url: "/save",
        data: data,
        success: function (result) {
            alert("Success!..");
            window.location.href = "/listar";
            $('.myForm #exampleModal').modal('hide');


        }
    })
})

*/



