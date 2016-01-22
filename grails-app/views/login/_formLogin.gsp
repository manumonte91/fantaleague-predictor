<g:form controller='login' action='login' method='POST' id='loginForm' class='cssform formLogin' autocomplete='off'>
    <fieldset>
        <legend>Login</legend>
        <g:if test="${flash.error}">
            <div class="errorMessage">
                <g:img dir="images" file="exclamation.png" /> ${flash.error}
            </div>
        </g:if>

        <p>
                <label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
                <input type='text' class="formfield" name='j_username' id='username'/>
        </p>

        <p>
                <label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
                <input type='password' class="formfield" name='j_password' id='password'/>
        </p>

        <p id="remember_me_holder">
                <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
                <label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
        </p>

        <p>
                <input type='submit' id="submit" class="btnLogin" value='Accedi'/>
        </p>

        <fieldset class="title">
            <legend>oppure</legend>
        </fieldset>

        <div class="loginButton">
                <%--<input type="button" onclick="location.href='${oauth.connect(provider:"facebook")}'" class="btnFacebook" value="Accedi con Facebook" />--%>
                <oauth:connect provider="facebook"><input type="button" class="btnFacebook" value="Accedi con Facebook" /></oauth:connect>
        </div>
    </fieldset>
</g:form>