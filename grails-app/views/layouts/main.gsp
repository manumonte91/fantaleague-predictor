<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
                <link rel="javascript" href="jquery-1.8.3.js" type="text/javascript">
                <asset:stylesheet src="main.css"/>
                <asset:stylesheet src="colpick.css"/>
                <asset:stylesheet src="fullcalendar.css"/>
                <asset:stylesheet src="fullcalendar.min.css"/>
                <asset:javascript src="moment.min.js"/>
                <asset:javascript src="jquery-1.8.3.js"/>
                <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
                <%--<asset:javascript src="jquery.min.js"/>--%>
                
  		<%--<asset:stylesheet src="application.css"/>--%>
		<asset:javascript src="application.js"/>
                <jq:resources/>
                <jqui:resources/>
		<g:layoutHead/>
                <script type="text/javascript">
$(document).ready(function () {	
	
	$('#nav li').hover(
		function () {
			//mostra sottomenu
			$('ul', this).stop(true, true).delay(100).slideDown(200);

		}, 
		function () {
			//nascondi sottomenu
			$('ul', this).stop(true, true).slideUp(200);		
		}
	);
	

});
	</script>
                <style type="text/css">
	
	#nav {
		margin:0; 
		padding:0; 
		list-style:none;
	}	
	
		#nav li {
			float:left; 
			display:block; 
			width:120px; 
			background:#A8F4A5; 
			position:relative;
			z-index:500; 
			margin:0 5px;
                        font-size:14px;
                        font-family:'Arial Narrow';
                        border-radius:10px 10px 10px 10px;
			-webkit-transition: all 0.1s ease-in-out;
		}
		/*#nav li.first {
			border-radius:10px 0 0 10px;
			-moz-border-radius:5px 0 0 5px;
			}
		#nav li.last {
			border-radius:0 10px 10px 0;
			-moz-border-radius:0 5px 5px 0;
			}
		#nav li li.last {
			border-radius:0 0 10px 10px;
			-moz-border-radius:0 0 5px 5px;
			}*/
		#nav li a {
			display:block; 
			padding:8px 5px 0 5px; 
			font-weight:700;  
			height:23px; 
			text-decoration:none; 
			text-align:center; 
			color:#333;
		}

		#nav li a:hover {
			color:#C00;
		}
		#nav li li:hover {
			-webkit-transform: translate(+10px,0);
			}
	/
		#nav a.selected {
			color:#C00;
		}
	
		#nav ul {
			position:absolute; 
			left:0; 
			display:none; 
			margin:0 0 0 -1px; 
			padding:0; 
			list-style:none;
		}
		
		#nav ul li {
			width:120px; 
			float:left; 
			border-top:1px solid #fff;
		}
		
		#nav ul a {
			display:block;  
			height:auto;
			padding: 8px 5px; 
			color:#666;
		}
		/* fix ie6, meglio inserirlo in un file .css separato */
		*html #nav ul {
			margin:0 0 0 -2px;
		}

	</style>
	</head>
	<body>
            <asset:javascript src="jquery-autosize.js"/>
            <asset:javascript src="colpick.js"/>
            <asset:javascript src="fullcalendar.js"/>
                <asset:javascript src="fullcalendar.min.js"/>
                <asset:javascript src="it.js"/>
                <asset:javascript src="jquery.fittext.js"/>
            
            
            <input type="hidden" id="ctxRoot" value="${request.contextPath}" />
            <g:render template="/layouts/barHeader" />
            <g:render template="/layouts/barMenu" />
            <div class="menuTongue">
                <a href="javascript:void(0)" id="showMenu">
                    <g:img dir="images" file="arrow-right.png" />
                </a>
            </div>
            <div class="principal">
                <g:if test="${flash.message}">
                    <div class="infoMessage">
                        <g:img dir="images" file="information.png" /> ${flash.message}
                    </div>
                </g:if>
                <g:if test="${flash.error}">
                    <div class="errorMessage">
                        <g:img dir="images" file="circle_cross.png" /> ${flash.error}
                    </div>
                </g:if>
                <g:layoutBody/>
            </div>
            <div id="maschera"></div>
            <g:javascript>
                $(document).ready(function() {
                    $(".infoMessage").fadeOut({duration: 5000});
                    $(".errorMessage").fadeOut({duration: 5000});
                });
                
                $('#clock').fitText(1.3);
                
                function update() {
                    $('#clock').html(moment().format('dddd D MMMM YYYY H:mm:ss'));
                  }

                  setInterval(update, 1000);
                
              /*$( "#hideMenu" ).click(function() {
                $( ".menu" ).animate({ "left": "-=200px" }, "slow" );
                $( ".menuTongue" ).animate({ "left": "+=100px" }, "slow" );
              });
              
              $( "#showMenu" ).click(function() {
                $( ".menuTongue" ).animate({ "left": "-=100px" }, "fast" );
                $( ".menu" ).animate({ "left": "+=200px" }, "slow" );
              });*/
              
              function showMenu() {
                if ( $(".menu").position().top < 0 ) {
                    $( ".menu" ).animate({ "top": "+=580px" }, "slow" );
                }
              }
              $(document).click(function(event) { 
                    if(!$(event.target).closest('.menu').length) {
                        if($('.menu').position().top > 0) {
                            $(".menu").animate({ "top": "-=580px" }, "slow" );
                        }
                    }
                    if(!$(event.target).closest('#searchWrap').length) {
                        if($("#resultSearch").is(":visible")){ 
                            $("#resultSearch").hide();
                        }
                    }
                })
            </g:javascript>
            <%--<g:javascript>
  function searchText(div, template){
    if(!$.trim($('#'+div).html())){
      //Mask.lock();
      $.ajax({
        type: 'POST',
        url: '${createLink(action:'changeTabScheda')}',
        data: {
          div: div,
          template: template,
          progetto: ${progetto.id}
        }
      }).done(function(response){
        $('#'+div).html(response);
        //Mask.unlock();
      });
    }
  }
</g:javascript>--%>
	</body>
</html>
