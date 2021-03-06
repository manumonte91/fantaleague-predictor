/*
 * Copyright 2012 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.util.Holders
import org.scribe.exceptions.OAuthException

class SpringSecurityOauthUrlMappings {

    static mappings = {
        def active = Holders.grailsApplication.config.grails?.plugin?.springsecurity?.oauth?.active
        boolean enabled = (active instanceof Boolean) ? active : true
        if (enabled && SpringSecurityUtils.securityConfig?.active) {
            "/oauth/$provider/success"(controller: 'springSecurityOAuth', action: 'onSuccess')
            "/oauth/$provider/failure"(controller: 'springSecurityOAuth', action: 'onFailure')
            '/oauth/askToLinkOrCreateAccount'(controller: 'springSecurityOAuth', action: 'askToLinkOrCreateAccount')
            '/oauth/linkaccount'(controller: 'springSecurityOAuth', action: 'linkAccount')
            '/oauth/createaccount'(controller: 'springSecurityOAuth', action: 'createAccount')

            '500'(controller: 'login', action: 'auth', exception: OAuthException)
        }
    }

}
