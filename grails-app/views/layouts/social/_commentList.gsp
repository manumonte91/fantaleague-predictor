<div class="commentList">
    <g:if test="${commentList && commentList.size() > 0}">
        <ul>
            <g:if test="${commentList.size() <= 10 || displayAll}">
                <g:each in="${commentList.sort{it.dataInserimento}}" var="comment" status="i">
                    <g:render template="/layouts/social/comment" model="['comment':comment]" />
                </g:each>
            </g:if>
            <g:else>
                <a href="javascript:void(0)" onclick="displayAllComments(${post.id})">
                    <g:img dir="images" file="comment.png" style="margin-left: 5px;margin-right: 5px;vertical-align: bottom;"/> 
                    Visualizza tutti i ${commentList.size()} commenti
                </a>
            </g:else>
        </ul>
    </g:if>
</div>
