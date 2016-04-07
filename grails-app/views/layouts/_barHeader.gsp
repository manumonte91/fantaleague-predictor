<nav class="navUser">
    <table width="100%">
        <tr>
            <td>
                <a href="${createLink(uri:'/dashboard')}" id="logo">
                    <g:img dir="images" file="logo.png" class="logo_tiny" />
                </a>
                <a href="javascript:void()" onclick="showMenu()">MENU'</a>
            </td>
            <td>
                <%--<ul id="nav">
                    <li class="first"><a href="#">HOME</a></li>
                    <li><a href="#" class="selected"></a>
                            <ul>
                                    <li><a href="#">Sottovoce Menu Numero 01</a></li>
                                    <li><a href="#">Sottovoce Menu Numero 02</a></li>
                                    <li class="last"><a href="#">Sottovoce Menu Numero 03</a></li>
                            </ul>
                            <div class="clear"></div>
                    </li>
                    <li><a href="#">REGOLAMENTO</a>
                    <ul>
                            <li><a href="#">Sottovoce Menu Numero 04</a></li>
                            <li><a href="#">Sottovoce Menu Numero 05</a></li>
                            <li><a href="#">Sottovoce Menu Numero 06</a></li>
                            <li class="last"><a href="#">Sottovoce Menu Numero 07</a></li>
                    </ul>			
                            <div class="clear"></div>
                    </li>
                    <li class="last"><a href="#">CONTATTACI</a></li>
            </ul>--%>
            </td>
            <td>
                <div id="searchWrap">
                    Cerca <g:textField name="ricerca" id="ricerca" class="searchText" placeholder="Cerca un utente"
                        onkeyup="DelayedCallMe(this.value)"
                        onfocus='if(!$("#resultSearch").is(":visible")){ $("#resultSearch").show(); }' />
                    <a href="#">
                        <g:img dir="images" file="search-icon.png" />
                    </a>
                    <div id="resultSearch">
                        <g:render template="/layouts/searchResult" />
                    </div>
                </div>
            </td>
            <td>
                <div align="right">
                    Versione: <g:meta name="app.version"/> - 
                    <span id="clock"></span>
                    <br/>
                    <g:if test="${session.user}">
                        <g:if test="${session.user.avatar}">
                            <img class="avatar_tiny" src="${createLink(controller:'profile', action:'avatar_image', id:session.user.ident())}" />
                        </g:if>
                        <g:elseif test="${session.user.avatarUrl}">
                            <img class="avatar_tiny" src="${session.user.avatarUrl}" />
                        </g:elseif>
                        <g:else>
                            <g:img class="avatar_tiny" dir="images" file="${session.user.gender == 'male' ? 'user-male.png' : 'user-female.png'}" />
                        </g:else>
                        ${session.user.nomeEsteso} - 
                        <g:link controller="profile" action="view" id="${session.user.id}">Profilo</g:link> - 
                        <g:link controller="login" action="logout">Esci</g:link>
                    </g:if>
                    <g:else>
                        <g:link controller="login" action="index">Effettua il login</g:link>
                    </g:else>
                </div>
            </td>
        </tr>
    </table>
</nav>
<script type="text/javascript">
    var _timer = 0;
    function DelayedCallMe(value) {
        if (_timer)
            window.clearTimeout(_timer);
        _timer = window.setTimeout(function() {
            ${remoteFunction(controller:'base', action: 'search',
               update: [success: 'resultSearch'], onSuccess:'modelFlagFromSearchResult(data)', /*options: [asynchronous: false], */
               params: '\'query=\' + value')};
        }, 500);
    }
</script>
