<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <g:if test="${user}">
                <table>
                    <tr>
                        <td width="20%">
                            <div class="pictureTab">
                                <g:if test="${session.user.id == user.id}">
                                    <g:set var="url" value="${createLink(controller:'profile',action:'newProfilePicture',params:[id:user.id])}"/>
                                    <g:set var="title" value="Carica nuova immagine profilo"/>
                                    <g:set var="form" value="#frmPop" />
                                    <a href="#" onclick="openDialog('${url}','${title}','${form}')" alt="Cambia immagine profilo">
                                        <g:img id="changePic" class="changePicClass" dir="images" file="change-picture.png" />
                                    </a>
                                </g:if>
                                <g:if test="${user.avatar}">
                                    <img class="avatar" src="${createLink(controller:'profile', action:'avatar_image', id:user.ident())}" />
                                </g:if>
                                <g:elseif test="${user.avatarUrl}">
                                    <img class="avatar" src="${user.avatarUrl}" />
                                </g:elseif>
                                <g:else>
                                    <g:img class="avatar" dir="images" file="${user.gender == 'male' ? 'user-male.png' : 'user-female.png'}" />
                                </g:else>
                            </div>
                        </td>
                        <td class="profileTab">
                            <p>
                                <input type="text" class="name" name="name" value="${user.nome}" /> 
                                <input type="text" class="name" name="surname" value="${user.cognome}" /> 
                            </p>
                            <g:if test="${user.socialList}">
                                <g:each in="${user.socialList}" var="oAuth">
                                    <div class="referenceSocial">
                                        <a href="${oAuth.profileUrl}">
                                            <g:img dir="images" file="${oAuth.provider}-icon.png" class="iconSocial" /> ${oAuth.profileName}</a>
                                    </div>
                                </g:each>
                            </g:if>
                        </td>
                    </tr>
                </table>
                <table class="profilo">
                    <th colspan="2">Dati anagrafici</th>
                    <tr><th>Email</th>
                        <td>
                            ${user.email}
                        </td>
                    </tr>
                    <tr><th>Sesso</th><td>${user.gender == 'male' ? 'Maschio' : 'Femmina'}</td></tr>
                    <tr><th>Data di nascita</th><td>${user.birthday}</td></tr>
                    <tr><th>Username</th><td>${user.username}</td></tr>
                    <g:if test="${session.user.id == user.id}">
                        <tr><th>Password</th><td><input type="button" onclick="location.href='${createLink(action:"changePassword",id:user.id)}'" value="Cambia Password" /></td></tr>
                    </g:if>
                        <tr><th>FantaLeague</th></tr>
                        <tr><th>Nome</th><td><input type="text" name="fantaLeague" value="${user.giocatore.fantaLeague}" /></td></tr>
                        <tr><th>Colori Sociali</th>
                            <td>
                                <g:select class="typeFlag" name="tipoColoriSociali" from="${it.flp.TipoColoriSociali.findAll()}" optionKey="id" optionValue="descrizione" value="${user.giocatore.tipoColoriSociali.id}"
                                    onchange="modelFlag(\$('.flag'),
                                        parseInt(this.value),
                                        \$('.color1').css('background-color'), 
                                        \$('.color2').css('background-color'), 
                                        \$('.color3').css('background-color'))" />
                                <div class="colorpicker color1"></div>
                                <div class="colorpicker color2"></div>
                                <div class="colorpicker color3"></div>
                            </td>
                        </tr>
                        <tr><th>Anteprima Bandiera</th>
                            <td>
                                <%--<div style="width:70px;height:100px;background-color:white;border:2px outset gold;border-radius:50%">
                                    <div style="margin-top:15px;width:70px;height:70px;background:repeating-linear-gradient(90deg, red, red 25%, black 25%, black 50%);border-radius:50%"></div>
                                </div>--%>
                                <div class="flag" 
                                        idType="${user.giocatore.tipoColoriSociali.id}" 
                                        color1="${user.giocatore.coloreSociale1}" 
                                        color2="${user.giocatore.coloreSociale2}" 
                                        color3="${user.giocatore.coloreSociale3}"></div>
                            </td>
                        </tr>
                </table>
            </g:if>
            <script type="text/javascript">
            $('.colorpicker').colpick({
                    layout:'rgbhex',
                    //color:'#ffffff',
                    onSubmit:function(hsb,hex,rgb,el) {
                            $(el).css('background-color', '#'+hex);
                            $(el).colpickHide();
                            modelFlag($('.flag'), 
                                parseInt($('.typeFlag').val()), 
                                $('.color1').css('background-color'), 
                                $('.color2').css('background-color'), 
                                $('.color3').css('background-color'));
                    }
            }).css('background-color', '${user.giocatore.coloreSociale1}');
            
            /*$(document).ready(function() {
                modelFlag (${user.giocatore.tipoColoriSociali.id});
            });*/
            
            $('.pictureTab').ready(function() {
                var pic = $('#changePic');
                if (pic) {
                    pic.hide();
                }
            });
            $('.pictureTab').on("mouseover", function() {
                var pic = $('#changePic');
                if (pic) {
                    pic.show();
                }
            });
            $('.pictureTab').on("mouseout", function() {
                var pic = $('#changePic');
                if (pic) {
                    pic.hide();
                }
            });
            $(document).on("ajaxStop", function() {
                $("#dialog").dialog("option", "position", ['center', 'center']);
                $("#dialog").dialog({ position: "center" });
            });
            
            function openDialog(sUrl, sTitle, sForm) {

                pop = $("<div id='dialog'></div>")
                pop.load(sUrl).dialog({
                    modal: true
                });

                pop.dialog( "option", "height", "auto");
                pop.dialog( "option", "width", "auto");

                pop.dialog({
                  close: function() { $(this).remove(); }
                });

                pop.dialog( "option", "title", sTitle);

            }

            function disabilitaCampi() {
              if($('#isAnonymous:checked').val() != undefined){
                $('#lastName').attr('disabled',true);
                $('#birthYear').attr('disabled',true);
                $('#mobilePhone').attr('disabled',true);
                $('#email').attr('disabled',true);
              } else {
                $('#lastName').attr('disabled',false);
                $('#birthYear').attr('disabled',false);
                $('#mobilePhone').attr('disabled',false);
                $('#email').attr('disabled',false);
              }
            }
            </script>
	</body>
</html>
