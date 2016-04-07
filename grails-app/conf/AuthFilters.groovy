/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmontervino
 * class to filter login auth check
 */
class AuthFilters {
    def filters = {
        loginCheck(controller: '*', action: '*', uriExclude: '/assets/**') {
            before = {
                if (!session.user && (controllerName && !controllerName.equals('login'))) {
                    if (!controllerName.equals('login') && !controllerName.equals('oauth')) {
                        redirect(controller: 'login', action: 'index')
                        return false
                    }
                }
            }
        }
    }
}

