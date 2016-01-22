package it.flp

import grails.transaction.Transactional

@Transactional
class MailSenderService {

    def mailService
    def grailsLinkGenerator
    
    def sendMailRegistration = { user ->
        
        def link = grailsLinkGenerator.link(controller:'profile',action:'mailConfirmed',id:user.id,base:grailsLinkGenerator.serverBaseURL)
        
        mailService.sendMail {
            to user.email
            from "no-reply@fantaleaguepredictor.it"
            subject "FLP - Mail di attivazione"
            html """Ciao $user.nome,<br/>
                Grazie per esserti iscritto!<br/><br/>
                Attiva la tua mail con il seguente link:<br/><br/>
                <a href='$link'>$link</a>"""
         }
        
    }
    
    def sendMailConfirmation = { user ->
        
        def link = grailsLinkGenerator.link(controller:'profile',action:'mailConfirmed',id:user.id,base:grailsLinkGenerator.serverBaseURL)
        
        mailService.sendMail {
            to user.email
            from "no-reply@fantaleaguepredictor.it"
            subject "FLP - Mail di attivazione"
            html """Ciao $user.nome!<br/>Attiva la tua mail con il seguente link:<br/><br/>
                <a href='$link'>$link</a>"""
         }
        
    }
}
