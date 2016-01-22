<g:if test="${resultSearch}">
    <ul id="searchResult" ${resultSearch.size > 10 ? "style=overflow-y:scroll;height:450px" : ""}>
        <g:each in="${resultSearch}" var="item" status="i">
            <g:if test="${i != 0}"><hr/></g:if>
            <a href='${createLink(controller:"profile",action:"view",id:item.id)}'>
                <li>
                    <table>
                        <tr>
                            <td rowspan="2">
                                <g:if test="${item.avatar}">
                                    <img class="avatar_small" src="${createLink(controller:'profile', action:'avatar_image', id:item.ident())}" />
                                </g:if>
                                <g:elseif test="${item.avatarUrl}">
                                    <img class="avatar_small" src="${item.avatarUrl}" />
                                </g:elseif>
                                <g:else>
                                    <g:img class="avatar_small" dir="images" file="${item.gender == 'male' ? 'user-male.png' : 'user-female.png'}" />
                                </g:else>
                            </td>
                            <td colspan="2">
                                ${item.nomeEsteso}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="flag_tiny" 
                                        idType="${item.giocatore.tipoColoriSociali.id}" 
                                        color1="${item.giocatore.coloreSociale1}" 
                                        color2="${item.giocatore.coloreSociale2}" 
                                        color3="${item.giocatore.coloreSociale3}"></div>
                                        
                            </td>
                            <td>
                                ${item.giocatore.fantaLeague}
                            </td>
                        </tr>
                    </table>
                </li>
            </a>
        </g:each>
    </ul>
    <%--<script type="text/javascript">
        function modelFlagFromSearchResult(flag, type, color1, color2, color3) {
            modelFlag(flag, type, color1, color2, color3);
        }
    </script>--%>
</g:if>
<g:elseif test="${searchEmptyText}">
    <ul><li>${searchEmptyText}</li></ul>
</g:elseif>