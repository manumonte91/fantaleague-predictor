<g:if test="${likeList.find { it.utente.id == session.user.id }}">
    <g:if test="${likeList.size() == 1}">
        Ti piace
    </g:if>
    <g:else>
        Piace a te e 
        <g:if test="${likeList.size() - 1 == 1}">
            ad un'altra persona
        </g:if>
        <g:else>
            ad altre ${likeList.size() - 1} persone
        </g:else>
    </g:else>
</g:if>
<g:else>
    Piace a ${likeList.size()} person${likeList.size() == 1 ? "a" : "e"}
</g:else>