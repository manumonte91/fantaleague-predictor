<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <g:set var="form" value="#frmPop" />
            <g:if test="${session.user && session.user.authorities.find { it.id == it.SUPERVISOR }}">
                <g:set var="url1" value="${createLink(controller:'admin',action:'newSeason')}"/>
                <g:set var="title1" value="Crea Nuova Stagione"/>
                <input type="button" value="Crea Stagione" onclick="openDialog('${url1}','${title1}','${form}')" />
                <g:set var="url2" value="${createLink(controller:'admin',action:'newSession')}"/>
                <g:set var="title2" value="Crea Nuova Sessione"/>
                <input type="button" value="Crea Sessione" onclick="openDialog('${url2}','${title2}','${form}')" />
            </g:if>
            <g:set var="url3" value="${createLink(controller:'admin',action:'newCompetition')}"/>
            <g:set var="title3" value="Crea Nuova Competizione"/>
            <input type="button" value="Crea Competizione" onclick="openDialog('${url3}','${title3}','#frmComp')" />
            <g:set var="url4" value="${createLink(controller:'admin',action:'newTeam')}"/>
            <g:set var="title4" value="Crea Nuova Squadra"/>
            <input type="button" value="Crea Squadra" onclick="openDialog('${url4}','${title4}','${form}')" />
            <g:set var="url5" value="${createLink(controller:'admin',action:'newSession')}"/>
            <g:set var="title5" value="Crea Giornata"/>
            <input type="button" value="Crea Giornata" onclick="openDialog('${url5}','${title5}','${form}')" />
            <hr/>
            
            <div id="accordion">
                <h3>Gestione Utenze</h3>
                <div>
                  <p>
                    <table>
                        <thead>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>FantaLeague</th>
                            <th>Ruolo</th>
                            <th></th>
                        </thead>
                        <g:each in="${it.flp.Utente.findAll()}" var="user">
                            <tr>
                                <td>${user.nome}</td>
                                <td>${user.cognome}</td>
                                <td>${user.giocatore ? user.giocatore.fantaLeague : ''}</td>
                                <td>${user.authorities.first().authority}</td>
                                <td>
                                    <g:if test="${session.user.id != user.id}">
                                        <input type="button" value="Cambia Ruolo" />
                                    </g:if>
                                </td>
                            </tr>
                        </g:each>
                    </table>
                  </p>
                </div>
                <h3>Gestione Stagioni</h3>
                <div>
                  <table>
                        <thead>
                            <th>Descrizione</th>
                            <th>Inizio</th>
                            <th>Fine</th>
                            <th>Competizioni</th>
                            <th>Sessioni</th>
                            <th>Stato</th>
                            <th></th>
                        </thead>
                        <g:if test="${it.flp.Stagione.count()}">
                            <g:each in="${it.flp.Stagione.findAll()}" var="season">
                                <tr>
                                    <td>${season.descrizione}</td>
                                    <td><g:formatDate date="${season.dataInizio}" format="dd/MM/yyyy" /></td>
                                    <td><g:formatDate date="${season.dataFine}" format="dd/MM/yyyy" /></td>
                                    <td>${season.competizioni.size()}</td>
                                    <td>${season.sessioni.size()}</td>
                                    <td>${season.stato.descrizione}</td>
                                    <td><input type="button" value="Gestisci" /></td>
                                </tr>
                            </g:each>
                        </g:if>
                        <g:else>
                            <tr>
                                <td colspan="4">Nessuna stagione disponibile</td>
                            </tr>
                        </g:else>
                    </table>
                </div>
                <h3>Gestione Competizioni</h3>
                <div>
                    <table>
                        <thead>
                            <th>Logo</th>
                            <th>Descrizione</th>
                            <th>Tipo</th>
                            <th>Squadre</th>
                            <th>Formato</th>
                            <th></th>
                        </thead>
                        <g:each in="${it.flp.Competizione.findAll()}" var="season">
                            <tr>
                                <td><g:img dir="images" file="leagues/${season.descrizione.replace(" ", "_")}.png" class="avatar_logo_tiny" /></td>
                                <td>${season.descrizione}</td>
                                <td>${season.tipoComp.descrizione}</td>
                                <td>${season.squadre}</td>
                                <td>${season.formato.descrizione}</td>
                                <td>
                                    <g:set var="urlEditComp" value="${createLink(controller:'admin',action:'editCompetition',id:season.id)}"/>
                                    <g:set var="titleEditComp" value="Gestisci Competizione - ${season.descrizione}"/>
                                    <input type="button" value="Gestisci" onclick="openDialog('${urlEditComp}','${titleEditComp}','#frmComp')" />
                                </td>
                            </tr>
                        </g:each>
                    </table>
                </div>
                <h3>Gestione Squadre</h3>
                <div>
                    <table>
                        <thead>
                            <th>Logo</th>
                            <th>Nome</th>
                            <th>Abbr.</th>
                            <th>Nazionalità</th>
                            <th></th>
                        </thead>
                        <g:each in="${it.flp.Squadra.findAll().sort{ it.nome }}" var="team">
                            <tr>
                                <td><g:img dir="images" file="clubs/${team.nome}.png" class="avatar_logo_tiny" /></td>
                                <td>${team.nome}</td>
                                <td>${team.sigla}</td>
                                <td><g:img dir="images" file="flags/flag${team.nazionalita.sigla}.png" class="avatar_logo_tiny" /></td>
                                <td>
                                    <g:set var="urlEditTeam" value="${createLink(controller:'admin',action:'editTeam',id:team.id)}"/>
                                    <g:set var="titleEditTeam" value="Gestisci Squadra - ${team.nome}"/>
                                    <input type="button" value="Gestisci" onclick="openDialog('${urlEditTeam}','${titleEditTeam}','${form}')" />
                                </td>
                            </tr>
                        </g:each>
                    </table>
                </div>
                <h3>Gestione Sessioni</h3>
                <div>
                  <p>
                    <table>
                        <thead>
                            <th>Descrizione</th>
                            <th>Stagione</th>
                            <th>Competizioni</th>
                            <th></th>
                        </thead>
                        <g:if test="${it.flp.Sessione.count()}">
                            <g:each in="${it.flp.Sessione.findAll()}" var="season">
                                <tr>
                                    <td>${season.descrizione}</td>
                                    <td>${season.stagione.descrizione}</td>
                                    <td>${season.competizioni.size()}</td>
                                    <td>
                                        <g:set var="urlEditSess" value="${createLink(controller:'admin',action:'editSession',id:season.id)}"/>
                                        <g:set var="titleEditSess" value="Gestisci Sessione - ${season.descrizione}"/>
                                        <input type="button" value="Gestisci" onclick="openDialog('${urlEditSess}','${titleEditSess}','#frmComp')" />
                                        <input type="button" value="Cambia Stato" />
                                    </td>
                                </tr>
                            </g:each>
                        </g:if>
                        <g:else>
                            <tr>
                                <td colspan="4">Nessuna sessione disponibile</td>
                            </tr>
                        </g:else>
                    </table>
                  </p>
                </div>
              </div>
            
            <script type="text/javascript">
            $(function() {
                $( "#accordion" ).accordion({
                        collapsible: true
                });
            });
            $(document).on("ajaxStop", function() {
                $("#dialog").dialog("option", "position", ['center', 'center']);
                $("#dialog").dialog({ position: "center" });
            });
            
            function openDialog(sUrl, sTitle, sForm) {

                pop = $("<div id='dialog'></div>")
                pop.load(sUrl).dialog({
                    modal: true,
                    show: {
                        effect: 'fade',
                        duration: 500
                    },
                    hide: {
                        effect: 'fade',
                        duration: 500
                    }
                });

                if (sForm == "#frmComp") {
                    pop.dialog( "option", "height", "auto");
                    pop.dialog( "option", "width", "50%");
                } else {
                    pop.dialog( "option", "height", "auto");
                    pop.dialog( "option", "width", "auto");
                }
                
                pop.dialog({
                  close: function() { $(this).remove(); }
                });
                
                pop.dialog( "option", "buttons",
                [
                    {
                        text: "Conferma",
                        class: "btn",
                        click: function() {
                          $(sForm).submit();
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

                pop.dialog( "option", "title", sTitle);

            }
            </script>
	</body>
</html>
