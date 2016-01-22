<div class="formAllegato">
    <g:form name="frmPop" controller="admin" action="confirmSession">
        <p>
            <label for="descrizione">Stagione:</label>
            <g:select name="stagione" from="${it.flp.Stagione.findAll()}" optionKey="id" optionValue="descrizione" />
        </p>
        <p>
            <label for="dataInizio">Descrizione:</label>
            <g:textField name="descrizione" />
        </p>
    </g:form>
</div>
