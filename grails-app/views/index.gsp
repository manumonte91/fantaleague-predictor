<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="index"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <p align="center">
                    <div style="float:left">
                        <table>
                            <tr>
                                <td>
                                    <g:img dir="images" file="logo.png" width="50%" />
                                </td>
                                <td>
                                    <h2>Unisciti Al Club!</h2><h3>Join The Club!</h3>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class='inner loginarea'>
                            <g:if test="${flash.message}">
                                    <div class='login_message'>${flash.message}</div>
                            </g:if>

                            <g:render template="login/formLogin" />
                    </div>
                    <input type="button" onclick="location.href='${createLink(controller:'login',action:'index')}'" value="Login" />
            </p>
	</body>
</html>
