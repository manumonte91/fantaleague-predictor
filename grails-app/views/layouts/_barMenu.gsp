<div class="menu">
    <%--MENU'
    <a href="javascript:void(0)" id="hideMenu">
        <g:img dir="images" file="arrow-left.png" />
    </a>--%>
    <ul id="menu">
        <g:if test="${session.user && session.user.authorities.find { it.id != it.USER }}">
            <li>
                <a href="${createLink(controller:'admin',action:'edit')}">
                    GESTIONE <g:img dir="images" file="management.png" />
                </a>
                <hr/>
            </li>
        </g:if>
        <li>
            <a href="${createLink(controller:'season')}">
                STAGIONE
            </a>
            <hr/>
        </li>
        <li>
            <a href="${createLink(controller:'calendar',action:'view',id:session.user.id)}">
                CALENDARIO
            </a>
            <hr/>
        </li>
        <li>STATISTICHE<hr/></li>
        <li>ARCHIVIO<hr/></li>
        <li>REGOLAMENTO<hr/></li>
        <li>ALBO D'ORO<hr/></li>
        <li>ASSISTENZA</li>
    </ul>
</div>