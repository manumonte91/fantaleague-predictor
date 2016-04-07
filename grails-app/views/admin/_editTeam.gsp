<div class="popupSquadra">
    <g:form name="frmPop" controller="admin" action="updateTeam">
        <input type="hidden" name="id" value="${squadra.id}" />
        <div>
        <table>
            <tr>
                <td>
                    <g:img dir="images" file="clubs/${squadra.nome}.png" class="avatar_logo" />
                </td>
                <td>
                    <p>
                        Nome: <g:textField name="nome" value="${squadra.nome}" /> 
                    </p>
                    <p>
                        Sigla: <g:textField name="sigla" maxlength="3" value="${squadra.sigla}" />
                    </p>
                    <p>
                        Nazionalità: <g:select name="nazionalita" from="${it.flp.Nazione.findAll()}" optionKey="id" optionValue="nome" value="${squadra.nazionalita.id}" />
                    </p>
                </td>
            </tr>
        </table>
        </div>
    </g:form>
</div>
