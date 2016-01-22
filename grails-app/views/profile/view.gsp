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
                                <span class="name">${user.nomeEsteso}</span> 
                                <g:if test="${session.user.id == user.id}">
                                    &nbsp;
                                    <g:link action="edit" id="${session.user.id}">
                                        <g:img dir="images" file="edit.png" class="iconSocial" /> Modifica profilo
                                    </g:link>
                                </g:if>
                                <g:else>
                                    <g:verifyFriendship idUser="${user.id}" myIdUser="${session.user.id}" />
                                </g:else>
                            </p>
                            <g:if test="${user.socialList}">
                                <g:each in="${user.socialList}" var="oAuth">
                                    <div class="referenceSocial">
                                        <a href="${oAuth.profileUrl}">
                                            <g:img dir="images" file="${oAuth.provider}-icon.png" class="iconSocial" /> ${oAuth.profileName}</a>
                                    </div>
                                </g:each>
                            </g:if>
                            <p>
                            <div class="flag" 
                                        idType="${user.giocatore.tipoColoriSociali.id}" 
                                        color1="${user.giocatore.coloreSociale1}" 
                                        color2="${user.giocatore.coloreSociale2}" 
                                        color3="${user.giocatore.coloreSociale3}"></div>
                                <span class="fantaLeague">${user.giocatore.fantaLeague}</span>
                            </p>
                        </td>
                    </tr>
                </table>
                <table class="profilo">
                    <th colspan="2">Dati anagrafici</th>
                    <tr><th>Email</th>
                        <td>
                            ${user.email} 
                            <g:if test="${session.user.id == user.id}">
                                <g:if test="${!user.emailEnabled}">
                                    <g:img dir="images" file="circle_cross.png" /> <span style="color:red">Non Confermata</span> - 
                                    <input type="button" onclick="location.href='${createLink(action:"sendMailConfirmation")}'" value="Ricevi la mail di attivazione" />
                                </g:if>
                                <g:else>
                                    <g:img dir="images" file="circle_confirmed.png" /> Confermata
                                </g:else>
                            </g:if>
                        </td>
                    </tr>
                    <tr><th>Sesso</th><td>${user.gender == 'male' ? 'Maschio' : 'Femmina'}</td></tr>
                    <tr><th>Data di nascita</th><td>${user.birthday}</td></tr>
                    <tr><th>Username</th><td>${user.username}</td></tr>
                    <g:if test="${session.user.id == user.id}">
                        <tr><th>Password</th><td><input type="button" onclick="location.href='${createLink(action:"changePassword",id:user.id)}'" value="Cambia Password" /></td></tr>
                    </g:if>
                        <tr><th>Colori Sociali</th>
                            <td>
                                <div class="colorpicker color1"></div>
                                <div class="colorpicker color2"></div>
                                <div class="colorpicker color3"></div>
                            </td>
                        </tr>
                </table>
            </g:if>
            <script type="text/javascript">
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
