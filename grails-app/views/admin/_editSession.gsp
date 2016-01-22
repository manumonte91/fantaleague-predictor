<div class="popupCompetizione">
    <g:form name="frmPop" controller="admin" action="saveSession">
        <div>
        <table>
            <tr>
                <td>
                    <p>
                        <g:textField name="descrizione" value="${sessione.descrizione}" />
                    </p>
                    <p>
                        Stagione ${sessione.stagione.descrizione}
                    </p>
                </td>
            </tr>
        </table>
        </div>
        <hr/>
        <div>
        <p>
            <g:if test="${sessione.competizioni.size() > 0}">
                <fieldset>
                    <legend>Competizioni</legend>
                    <table>
                        <thead>
                            <th>Codice</th>
                            <th>Competizione</th>
                            <th>Data Inizio</th>
                            <th>Data Fine</th>
                            <th>Stato</th>
                            <th>Iscritti</th>
                            <th></th>
                        </thead>
                        <g:each in="${sessione.competizioni.sort{ it.id }}" status="i" var="competizione">
                            <tr class="${(i.toInteger() % 2) == 0 ? 'odd' : ''}">
                                <td>${competizione.codice}</td>
                                <td>${competizione.competizione.descrizione}</td>
                                <td><g:formatDate date="${competizione.dataInizio}" format="dd/MM/yyyy" /></td>
                                <td><g:formatDate date="${competizione.dataFine}" format="dd/MM/yyyy" /></td>
                                <td>${competizione.stato.descrizione}</td>
                                <td>${competizione.giocatori.size()}/${competizione.competizione.squadre}</td>
                                <td></td>
                            </tr>
                        </g:each>
                    </table>
                </fieldset>
                
            </g:if>
        </p>
        <div>
    </g:form>
</div>
