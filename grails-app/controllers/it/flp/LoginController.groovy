package it.flp

import grails.converters.JSON
import org.scribe.model.Token
import java.text.SimpleDateFormat

class LoginController {

    def oauthService
    def springSecurityService
    def passwordEncoder
    def facebookGraphService
    def mailSenderService
    
    def sdf = new SimpleDateFormat("dd/MM/yyyy")
    
    def index() {
    }
    
    def register() {
        log.info("PARAMS: $params")
        
        def newUser = new Utente()
        newUser.email = params.j_email
        newUser.nome = params.j_name
        newUser.cognome = params.j_surname
        newUser.username = params.j_username
        newUser.password = params.j_password
        newUser.gender = params.j_gender
        if(params.j_birthday) newUser.birthday = sdf.parse(params.j_birthday)
        
        if(!newUser.hasErrors() && newUser.save(flush:true)) {
            new UtenteRuolo (utente:newUser, ruolo:Ruolo.get(Ruolo.USER)).save()
            new Giocatore (fantaLeague:"Team " + newUser.id,
            coloreSociale1:"#FFFFFF",
            tipoColoriSociali:TipoColoriSociali.get(1),
            utente:newUser).save()
            flash.message = "Registrazione effettuata con successo!"
            session.user = Utente.get(newUser.id)
            mailSenderService.sendMailRegistration(newUser)
            render view:'/dashboard.gsp'
        } else {
            flash.error = "Errori: $newUser.errors"
            render view:'index'
        }
    }
    
    def login() {
        log.info("PARAMS: $params")
        def user = Utente.findByUsername(params.j_username)
        if (user && passwordEncoder.isPasswordValid(user.password, params.j_password, null)) {
            session.user = user
            flash.message = "Login effettuata con successo"
            redirect uri: '/dashboard'
        } else {
            flash.error = "Utente o Password non valida"
            render view:'index'
        }
    }
    
    def logout() {
        session.invalidate()
        flash.message = "Logout effettuato con successo"
        redirect uri: '/'
    }
    
    def facebookSuccess() {
        Token facebookAccessToken = (Token) session[oauthService.findSessionKeyForAccessToken('facebook')]
        def facebookResource = oauthService.getFacebookResource(facebookAccessToken, "https://graph.facebook.com/me")
        def facebookResponse = JSON.parse(facebookResource?.getBody())
        def facebookPictureResource = oauthService.getFacebookResource(facebookAccessToken, "https://graph.facebook.com/me/picture?type=large&redirect=false")
        def facebookPictureResponse = JSON.parse(facebookPictureResource?.getBody())

        log.info "FACEBOOK RESPONSE: $facebookResponse"
        log.info "Email = ${facebookResponse.email}"
        
        def user = Utente.findByEmail(facebookResponse.email)
        def message = ""
        if (user) {
            def userauth = OAuthID.findByUser(user)
            if (!userauth) {
                new OAuthID (provider:"facebook", 
                    accessToken:facebookAccessToken.token,
                    user:user).save(flush:true)
            }
            session.user = Utente.get(user.id)
            message += "Login effettuata con successo"
        } else {
            def defaultUsername = facebookResponse.link.split('/')
            defaultUsername = defaultUsername[defaultUsername.length - 1]
            def birthdayIt = facebookResponse.birthday.split('/')
            birthdayIt = birthdayIt[1] + "/" + birthdayIt[0] + "/" + birthdayIt[2]
            def newUser = new Utente()
            newUser.email = facebookResponse.email
            newUser.nome = facebookResponse.first_name
            newUser.cognome = facebookResponse.last_name
            newUser.username = defaultUsername
            newUser.password = defaultUsername
            newUser.gender = facebookResponse.gender
            newUser.birthday = birthdayIt
            newUser.avatarUrl = facebookPictureResponse.data.url
            newUser.save(flush:true)
            new UtenteRuolo (utente:newUser, ruolo:Ruolo.get(Ruolo.USER)).save()
            new OAuthID (provider:"facebook", 
                accessToken:facebookAccessToken.token,
                profileUrl:facebookResponse.link,
                profileName:facebookResponse.name,
                user:newUser).save(flush:true)
            new Giocatore (fantaLeague:"Team " + newUser.id,
            coloreSociale1:"#FFFFFF",
            tipoColoriSociali:TipoColoriSociali.get(1),
            utente:newUser).save()
            message += "Registrazione avvenuta con successo"
            session.user = Utente.get(newUser.id)
            
            mailSenderService.sendMailRegistration(newUser)
        }
        
        flash.message = message

        redirect uri: '/dashboard'
    }
    
    def facebookFailure() {
        log.info "LOGIN FAILED WITH FACEBOOK"
        flash.error = "Login Facebook fallita"
        redirect view: index()
    }
}
