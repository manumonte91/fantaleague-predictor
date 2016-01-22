<g:form name="frmSure" controller="season" action="confirmCompetition">
    <input type="hidden" name='idComp' value="${comp.id}" />
    <input type="hidden" name='idPlayer' value="${giocatore.id}" />
    <p>
        Sei sicuro di voler partecipare alla ${comp.competizione.descrizione}?
    </p>
</g:form>