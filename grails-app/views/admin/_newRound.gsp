<div class="formAllegato">
    <g:form name="frmPop" controller="admin" action="confirmSeason">
        <p>
            <label for="stagione">Stagione:</label>
            <g:select name="stagione" from="${it.flp.Stagione.list()}" optionKey="id" optionValue="descrizione" onselect="" />
        </p>
        <p>
            <label for="stagione">Stagione:</label>
            <g:select name="sessione" from="${it.flp.Stagione.list()}" optionKey="id" optionValue="descrizione" />
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
