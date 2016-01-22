<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <input type="button" value="Simula campionato" onclick="location.href='${createLink(controller:'calendar',action:'calendarSimulator')}'" />
            <div id="listOfficial">
                <g:each in="${sessioni}" var="sessione">
                    <div>
                        ${sessione.descrizione}
                        <g:each in="${sessione.competizioni.sort { it.id }}" var="sessComp">
                            <g:if test="${sessComp.competizione.codComp == "A"}">
                                <g:set var="coppa" value="${it.flp.Competizione.findByCodCompAndSiglaNazione("N", sessComp.competizione.siglaNazione).descrizione}" />
                                <g:set var="nomeCoppa" value="${sessione.competizioni.collect{it.competizione}.sort{it.id}.collect{it.descrizione}.find{it.contains(coppa)}}" />
                                <g:set var="campionato" value="${sessComp.competizione}" />
                                <g:set var="sUrl" value="${createLink(controller:'season',action:'popupSure',id:sessComp.id)}"/>
                                <g:if test="${sessComp.giocatori.size() < sessComp.competizione.squadre}">
                                    <div class="btnComp" onclick="popupSure('${sUrl}')">
                                        <p>
                                            <g:img dir="images" file="${campionato.descrizione.replace(" ", "_")}.png" class="avatar_logo" />
                                        </p>
                                        <p>${campionato.descrizione}</p>
                                        <p>Include:</p>
                                        <p><g:img dir="images" file="${coppa.replace(" ", "_")}.png" class="avatar_logo_small" /></p>
                                        <p>${coppa}</p>
                                        <p>${sessComp.giocatori.size()}/${sessComp.competizione.squadre}</p>
                                    </div>
                                </g:if>
                                <g:else>
                                    <div class='btnComp'>
                                        <p>
                                            <g:img dir="images" file="${campionato.descrizione.replace(" ", "_")}.png" class="avatar_logo" />
                                        </p>
                                        <p>${campionato.descrizione}</p>
                                        <p>Include:</p>
                                        <p><g:img dir="images" file="${coppa.replace(" ", "_")}.png" class="avatar_logo_small" /></p>
                                        <p>${coppa}</p>
                                        <p>Posti Terminati</p>
                                    </div>
                                </g:else>
                            </g:if>
                        </g:each>
                    </div>
                </g:each>
            </div>
            <script type="text/javascript">
            
            $(document).ready(function() {
            
            });
            
            function popupSure(sUrl) {
                
                pop = $("<div id='dialog'></div>")
                pop.load(sUrl).dialog({
                    modal: true
                });

                /*if (sForm == "#frmComp") {
                    pop.dialog( "option", "height", "auto");
                    pop.dialog( "option", "width", "50%");
                } else {
                    pop.dialog( "option", "height", "auto");
                    pop.dialog( "option", "width", "auto");
                }*/
                
                pop.dialog({
                  close: function() { $(this).remove(); }
                });
                
                pop.dialog( "option", "buttons",
                [
                    {
                        text: "Conferma",
                        class: "btn",
                        click: function() {
                          $("#frmSure").submit();
                          $(this).dialog("close");
                        }
                    }
                ,

                    {
                        text: "Annulla",
                        class: "btnWhite",
                        click: function() {
                          $(this).dialog("close");
                        }
                    }
                ]);

                pop.dialog( "option", "title", "Conferma");
                
            }
            
            </script>
	</body>
</html>
