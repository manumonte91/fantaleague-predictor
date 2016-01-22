<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <div id="listOfficial">
                <g:each in="${sessioni}" var="sessComp">
                        <%--${sessione.descrizione}--%>
                        <%--<g:each in="${sessione.sort { it.id }}" var="sessComp">--%>
                                <g:set var="campionato" value="${sessComp.competizione.competizione}" />
                                <g:set var="giocatore" value="${sessComp}" />
                                <a class="btnComp" style="width:95%;text-align:left" href="${createLink(controller:'competition',action:'view',id:sessComp.competizione.id)}">
                                    <p>
                                        <table>
                                            <tr>
                                                <td style="width:15%">
                                        <g:img dir="images" file="${campionato.descrizione.replace(" ", "_")}.png" class="avatar_logo" />
                                                </td>
                                                <td>
                                        <h2>${campionato.descrizione}</h2>
                                        <span>
                                            Presenze: ${giocatore.presenze} 
                                            Vittorie: ${giocatore.vittorie} 
                                            Pareggi: ${giocatore.pareggi} 
                                            Sconfitte: ${giocatore.sconfitte} 
                                            <br/>
                                            Pronostici - 
                                            Risultati: ${giocatore.pronosticiRisultati} 
                                            Esiti: ${giocatore.pronosticiEsiti} 
                                            Nulli: ${giocatore.pronosticiNulli} 
                                            Punti Fatti: ${giocatore.puntiFatti}
                                            Punti Subiti: ${giocatore.puntiSubiti}
                                            Differenza Punti: ${giocatore.differenzaPunti}
                                            Media Punti: ${giocatore.mediaPunti}
                                            <br/>
                                            MOP: ${giocatore.mop}
                                            Bidoni: ${giocatore.bidoni}
                                        </span>
                                        </td>
                                        </tr>
                                        </table>
                                    </p>
                                </a>
                        <%--</g:each>--%>
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
