<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <g:set var="campionato" value="${comp.competizione}" />
            <div>
                <table>
                    <tr>
                        <td style="width:45%">
                <g:img dir="images" file="${campionato.descrizione.replace(" ", "_")}.png" class="avatar_logo" />
                        </td>
                        <td>
                <h2>${campionato.descrizione}</h2>
                Stagione ${comp.sessione.stagione.descrizione}
                </td>
                </tr>
                </table>
            </div>
            <hr/>
            <div class="nav">
                <ul id="menu">
                    <li id="link1"><a href="javascript:void(0)" data-page="teams">Squadre</a></li>
                    <li id="link2"><a href="javascript:void(0)" data-page="players">Giocatori</a></li>
                    <li id="link3"><a href="javascript:void(0)" data-page="matches">Giornate</a></li>               
                </ul>
            </div>
            <br/>
            <div id="listNav">
                <div id="teams">
                    <h2>Squadre</h2>
                <table>
                    <thead>
                        <th>Nome</th>
                        <th>G</th>
                        <th>V</th>
                        <th>P</th>
                        <th>S</th>
                        <th>GF</th>
                        <th>GS</th>
                        <th>DIFF.RETI</th>
                    </thead>
                    <g:each in="${squadre}" var="squadra">
                        <tr>
                            <td>${squadra.squadra.nome}</td>
                            <td>${squadra.presenze}</td>
                            <td>${squadra.vittorie}</td>
                            <td>${squadra.pareggi}</td>
                            <td>${squadra.sconfitte}</td>
                            <td>${squadra.golFatti}</td>
                            <td>${squadra.golSubiti}</td>
                            <td>${squadra.differenzaReti}</td>
                        </tr>
                    </g:each>
                </table>
                </div>
                <div id="players">
                    <h2>Giocatori</h2>
                <table>
                    <thead>
                        <th>Nome</th>
                        <th>G</th>
                        <th>V</th>
                        <th>P</th>
                        <th>S</th>
                        <th>RIS.</th>
                        <th>ESITI</th>
                        <th>NULLI</th>
                        <th>PT.FATTI</th>
                        <th>PT.SUBITI</th>
                        <th>DIFF.PT.</th>
                        <th>MEDIA PT.</th>
                        <th>MOP</th>
                        <th>BIDONI</th>
                    </thead>
                    <g:each in="${giocatori}" var="giocatore">
                        <tr>
                            <td>${giocatore.giocatore.utente.nomeEsteso}</td>
                            <td>${giocatore.presenze}</td>
                            <td>${giocatore.vittorie}</td>
                            <td>${giocatore.pareggi}</td>
                            <td>${giocatore.sconfitte}</td>
                            <td>${giocatore.pronosticiRisultati}</td>
                            <td>${giocatore.pronosticiEsiti}</td>
                            <td>${giocatore.pronosticiNulli}</td>
                            <td>${giocatore.puntiFatti}</td>
                            <td>${giocatore.puntiSubiti}</td>
                            <td>${giocatore.differenzaPunti}</td>
                            <td>${giocatore.mediaPunti}</td>
                            <td>${giocatore.mop}</td>
                            <td>${giocatore.bidoni}</td>
                        </tr>
                    </g:each>
                </table>
                </div>
                <div id="matches">
                    <h2>Giornate</h2>
                    <g:if test="${giornate && giornate.size() > 0}">
                        <table>
                            <g:each in="${giornate}" var="giornata" status="i">
                                <g:if test="${(i % 2) == 0}"><tr></g:if>
                                    <td>
                                        <table>
                                            <thead>
                                                <th colspan="7">${giornata.descrizione}</th>
                                            </thead>
                                            <g:each in="${giornata.partite}" var="partita">
                                                <tr>
                                                    <td>${partita.casa.fantaLeague}</td>
                                                    <td><div class="flag_tiny" 
                                                            idType="${partita.casa.tipoColoriSociali.id}" 
                                                            color1="${partita.casa.coloreSociale1}" 
                                                            color2="${partita.casa.coloreSociale2}" 
                                                            color3="${partita.casa.coloreSociale3}"></div></td>
                                                    <td>${partita.puntiCasa}</td>
                                                    <td>-</td>
                                                    <td>${partita.puntiTrasferta}</td>
                                                    <td><div class="flag_tiny" 
                                                            idType="${partita.trasferta.tipoColoriSociali.id}" 
                                                            color1="${partita.trasferta.coloreSociale1}" 
                                                            color2="${partita.trasferta.coloreSociale2}" 
                                                            color3="${partita.trasferta.coloreSociale3}"></div></td>
                                                    <td>${partita.trasferta.fantaLeague}</td>
                                                </tr>
                                            </g:each>
                                        </table>
                                    </td>
                                <g:if test="${(i % 2) != 0}"></tr></g:if>
                            </g:each>
                        </table>
                    </g:if>
                    <g:else>
                        <input type="button" value="Genera Calendario" onclick="location.href='${createLink(controller:'competition',action:'generateCalendar',id:comp.id)}'" />
                    </g:else>
                </div>
            </div>
            <script type="text/javascript">
            
            $(document).ready(function() {
                var curPage="";
                $("#listNav > div").each(function() {
                    $(this).hide();
                });
                $("#listNav > div:first").show();
                $("#menu a").click(function() {
                    $("#listNav > div").each(function() {
                        $(this).hide();
                    });
                    curPage=$(this).data("page");
                    $("#"+curPage).show();
                });
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
