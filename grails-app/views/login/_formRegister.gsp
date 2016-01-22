<form action='register' method='POST' id='loginForm' class='cssform formRegister' autocomplete='off'>
    <fieldset>
        <legend>Registrati</legend>
        <g:if test="${flash.error}">
            <div class="errorMessage">
                <g:img dir="images" file="exclamation.png" /> ${flash.error}
            </div>
        </g:if>

        <p>
                <label for='username'>Email:</label>
                <input type='email' class="formfield" name='j_email' id='email' placeholder="esempio@mail.com" />
        </p>
        
        <p>
                <label for='username'>Nome:</label>
                <input type='text' class="formfield" name='j_name' id='name'/>
        </p>
        
        <p>
                <label for='username'>Cognome:</label>
                <input type='text' class="formfield" name='j_surname' id='surname'/>
        </p>
        
        <p>
                <label for='username'>Sesso:</label>
                <g:select id="j_gender" name="j_gender" noSelection="[null:'- Seleziona -']"
                        from="${['male': 'Maschio', 'female': 'Femmina']}"
                        optionKey="key" optionValue="value" />
        </p>
        
        <p>
                <label for='username'>Data di nascita:</label>
                <input type='datetime' class="formfield" name='j_birthday' id='birthday' placeholder="dd/mm/yyyy"/>
        </p>
        
        <p>
                <label for='username'><g:message code="springSecurity.login.username.label"/>:</label>
                <input type='text' class="formfield" name='j_username' id='username'/>
        </p>

        <p>
                <label for='password'><g:message code="springSecurity.login.password.label"/>:</label>
                <input type='password' class="formfield" name='j_password' id='password'/>
        </p>

        <p>
                <input type='submit' id="submit" class="btnLogin" value='Registrati'/>
        </p>
    </fieldset>
</form>