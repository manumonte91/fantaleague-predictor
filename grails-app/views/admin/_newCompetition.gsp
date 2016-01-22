<div class="popupCompetizione">
    <g:form name="frmPop" controller="admin" action="confirmCompetition">
        <div>
        <table>
            <tr>
                <td>
                    <div class="avatar_logo"></div>
                </td>
                <td>
                    <p>
                        <g:textField name="descrizione" />
                    </p>
                    <p>
                        <g:select name="tipo" from="${it.flp.TipoCompetizione.findAll()}" optionKey="id" optionValue="descrizione" />
                    </p>
                </td>
            </tr>
        </table>
        </div>
        <hr/>
        <div>
        <p>
            Formato: <g:select name="formato" from="${it.flp.FormatoCompetizione.findAll()}" optionKey="id" optionValue="descrizione" />
        </p>
        <p>        
            Squadre: <g:field type="number" name="squadre" min="2" max="100" />
        </p>
        </div>
        <div>
        <p>
            Fasi <a href="javascript:void(0)" onclick="addPhase()">Aggiungi fase</a>
            <div class="phases">
            </div>
        </p>
        <div>
    </g:form>
</div>
<script type="text/javascript">
    function addPhase() {
        var countPhases = 0;
        while ($('.phase_' + countPhases).html() != null) {
            countPhases++;
        }
        $.ajax({
            type: 'POST',
            url: '${createLink(controller:'admin',action:'addPhaseCompetition')}',
            data: {
              idPhase: countPhases
            }
          }).done(function(response){
            $('.phases').append(response);
          });
    }
    
    function addRound(idPhase) {
        var countRounds = 0;
        while ($('.round_' + idPhase + '_' + countRounds).html() != null) {
            countRounds++;
        }
        $.ajax({
            type: 'POST',
            url: '${createLink(controller:'admin',action:'addRoundCompetition')}',
            data: {
              idPhase: idPhase,
              idRound: countRounds
            }
          }).done(function(response){
            $('.rounds_' + idPhase).append(response);
          });
    }
</script>
