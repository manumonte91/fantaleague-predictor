<div class="popupSquadra">
    <g:form name="frmPop" controller="admin" action="confirmTeam">
        <div>
        <table>
            <tr>
                <td>
                    <div class="avatar_logo"></div>
                </td>
                <td>
                    <p>
                        Nome: <g:textField name="nome" /> 
                    </p>
                    <p>
                        Sigla: <g:textField name="sigla" maxlength="3" />
                    </p>
                    <p>
                        Nazionalità: <g:select name="nazionalita" from="${it.flp.Nazione.findAll()}" optionKey="id" optionValue="nome" />
                    </p>
                </td>
            </tr>
        </table>
        </div>
    </g:form>
</div>
