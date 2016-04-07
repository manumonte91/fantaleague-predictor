<div class="popupCompetizione">
    <g:form name="frmPop" controller="admin" action="saveCompetition">
        <div>
        <table>
            <tr>
                <td>
                    <g:img dir="images" file="leagues/${competizione.descrizione.replace(" ", "_")}.png" class="avatar_logo" />
                </td>
                <td>
                    <p>
                        <g:textField name="descrizione" value="${competizione.descrizione}" />
                    </p>
                    <p>
                     <g:select name="tipo" from="${it.flp.TipoCompetizione.findAll()}" optionKey="id" optionValue="descrizione"
                          value="${competizione.tipoComp.id}" />
                    </p>
                </td>
            </tr>
        </table>
        </div>
        <hr/>
        <div>
        <p>
            Formato: <g:select name="formato" from="${it.flp.FormatoCompetizione.findAll()}" optionKey="id" optionValue="descrizione"
                value="${competizione.formato.id}" />
        </p>
        <p>        
            Squadre: <g:field type="number" name="descrizione" min="2" max="100" value="${competizione.squadre}" />
        </p>
        </div>
        <div>
        <p>
            <g:if test="${competizione.fasi.size() > 0}">
                Fasi<br/>
                <g:each in="${competizione.fasi.sort{ it.id }}" var="fase">
                    <fieldset>
                        <legend>${fase.descrizione}</legend>
                        <g:each in="${fase.turni.sort{ it.id }}" var="turno">
                            <p>
                                ${turno.descrizione} - Sorteggio <g:checkBox name="sorteggio" value="${turno.sorteggio}" /> - 
                                Andata/Ritorno <g:checkBox name="andataRitorno" value="${turno.andataRitorno}" />
                            </p>
                        </g:each>
                    </fieldset>
                </g:each>
            </g:if>
        </p>
        <div>
    </g:form>
</div>
