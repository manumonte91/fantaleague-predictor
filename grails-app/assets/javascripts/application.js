// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

$(document).ready(function() {
    Mask.init();
    $('.flag').each(function () {
        var idType = parseInt($(this).attr('idType'));
        var color1 = $(this).attr('color1');
        var color2 = $(this).attr('color2');
        var color3 = $(this).attr('color3');
        modelFlag ($(this), idType, color1, color2, color3);
        if ($('.colorpicker'))
        {
            $('.color1').css('background-color', color1);
            $('.color2').css('background-color', color2);
            $('.color3').css('background-color', color3);
        }
    });
    $('.flag_tiny').each(function () {
        var idType = parseInt($(this).attr('idType'));
        var color1 = $(this).attr('color1');
        var color2 = $(this).attr('color2');
        var color3 = $(this).attr('color3');
        modelFlag ($(this), idType, color1, color2, color3);
    });
});
function modelFlagFromSearchResult(data)
{
    $(data).ready(function() {
        $('.flag_tiny').each(function () {
            var idType = parseInt($(this).attr('idType'));
            var color1 = $(this).attr('color1');
            var color2 = $(this).attr('color2');
            var color3 = $(this).attr('color3');
            modelFlag ($(this), idType, color1, color2, color3);
        });
    });
}
function modelFlag (flag, idType, color1, color2, color3) {
    switch (idType) {
        case 1: {
            flag.css('background', color1);
            flag.css('border-color', color3);
            $('.color2').hide();
            break;
        }
        case 2: {
            flag.css('background', 
                'linear-gradient(' + color1 + ' 50%, ' + color2 + ' 50%)');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 3: {
            flag.css('background', 
                'repeating-linear-gradient(180deg, ' + color1 + ', ' + color1 + ' 25%, ' + color2 + ' 25%, ' + color2 + ' 50%)');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 4: {
            flag.css('background', 
                'linear-gradient(90deg, ' + color1 + ' 50%, ' + color2 + ' 50%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 5: {
            flag.css('background', 
                'repeating-linear-gradient(90deg, ' + color1 + ', ' + color1 + ' 25%, ' + color2 + ' 25%, ' + color2 + ' 50%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 6: {
            flag.css('background', 
                'linear-gradient(25deg, ' + color1 + ' 50%, ' + color2 + ' 50%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 7: {
            flag.css('background', 
                'repeating-linear-gradient(25deg, ' + color1 + ', ' + color1 + ' 25%, ' + color2 + ' 25%, ' + color2 + ' 50%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 8: {
            flag.css('background', 
                'linear-gradient(-205deg, ' + color1 + ' 50%, ' + color2 + ' 50%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 9: {
            flag.css('background', 
                'repeating-linear-gradient(-205deg, ' + color1 + ', ' + color1 + ' 25%, ' + color2 + ' 25%, ' + color2 + ' 50%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 10: {
            flag.css('background', 
                'repeating-linear-gradient(180deg, ' + color1 + ', ' + color1 + ' 30%, ' + color2 + ' 30%, ' + color2 + ' 70%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 11: {
            flag.css('background', 
                'repeating-linear-gradient(180deg, ' + color1 + ', ' + color1 + ' 40%, ' + color2 + ' 40%, ' + color2 + ' 60%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 12: {
            flag.css('background', 
                'repeating-linear-gradient(90deg, ' + color1 + ', ' + color1 + ' 30%, ' + color2 + ' 30%, ' + color2 + ' 70%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 13: {
            flag.css('background', 
                'repeating-linear-gradient(90deg, ' + color1 + ', ' + color1 + ' 40%, ' + color2 + ' 40%, ' + color2 + ' 60%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 14: {
            flag.css('background', 
                'repeating-linear-gradient(25deg, ' + color1 + ', ' + color1 + ' 30%, ' + color2 + ' 30%, ' + color2 + ' 70%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 15: {
            flag.css('background', 
                'repeating-linear-gradient(25deg, ' + color1 + ', ' + color1 + ' 40%, ' + color2 + ' 40%, ' + color2 + ' 60%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 16: {
            flag.css('background', 
                'repeating-linear-gradient(-205deg, ' + color1 + ', ' + color1 + ' 30%, ' + color2 + ' 30%, ' + color2 + ' 70%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
        case 17: {
            flag.css('background', 
                'repeating-linear-gradient(-205deg, ' + color1 + ', ' + color1 + ' 40%, ' + color2 + ' 40%, ' + color2 + ' 60%');
            flag.css('border-color', color3);
            $('.color2').show();
            break;
        }
    }
}