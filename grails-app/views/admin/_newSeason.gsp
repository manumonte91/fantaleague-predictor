<div class="formAllegato">
    <g:form name="frmPop" controller="admin" action="confirmSeason">
        <p>
            <label for="descrizione">Stagione:</label>
            <g:textField name="descrizione" />
        </p>
        <p>
            <label for="dataInizio">Data Inizio:</label>
            <g:textField class="datepicker" name="dataInizio" />
        </p>

        <p>
            <label for="dataFine">Data Fine:</label>
            <g:textField class="datepicker" name="dataFine" />
        </p>
    </g:form>
</div>
<script type="text/javascript">
    $(function() {
        $( ".datepicker" ).datepicker({
            showAnim: 'slideDown',
            dateFormat: 'dd/mm/yy'
        });
    });
</script>
