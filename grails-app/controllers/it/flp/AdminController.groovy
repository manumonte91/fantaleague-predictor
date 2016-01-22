package it.flp

import java.text.SimpleDateFormat

class AdminController {

    def sdf = new SimpleDateFormat("dd/MM/yyyy")
    
    def index() { }
    
    def edit = {
        render view:'edit'
    }
    
    def newSeason = {
        render template:'newSeason'
    }
    
    def confirmSeason = {
        
        def season = new Stagione()
        season.descrizione = params.descrizione
        if(params.dataInizio) season.dataInizio = sdf.parse(params.dataInizio)
        if(params.dataFine) season.dataFine = sdf.parse(params.dataFine)
        season.stato = StatoStagione.get(StatoStagione.APERTA)
        if (!season.hasErrors() && season.save(flush:true)) {
            flash.message = "Stagione ${season.descrizione} creata con successo"
        } else {
            flash.error = "Errore di inserimento della stagione"
        }
        
        def competizioni = Competizione.findAllByTipoComp(TipoCompetizione.get(1))
        competizioni.each { comp ->
            new StagioneCompetizione
                (stagione:season, 
                competizione:comp, 
                dataInizio:season.dataInizio,
                dataFine:season.dataFine).save()
        }
        
        redirect action:edit
    }
    
    def newSession = {
        render template:'newSession'
    }
    
    def confirmSession = {
        
        def sessione = new Sessione()
        sessione.descrizione = params.descrizione
        sessione.stagione = Stagione.get(params.stagione)
        if (!sessione.hasErrors() && sessione.save(flush:true)) {
            flash.message = "Sessione ${sessione.descrizione} creata con successo"
        } else {
            flash.error = "Errore di inserimento della stagione"
        }
        
        def competizioni = Competizione.findAllByTipoComp(TipoCompetizione.get(1))
        competizioni.each { comp ->
            def codice = ""
            def number = sessione.count() < 10 ? "0" + sessione.count() : sessione.count()
            codice = comp.siglaNazione + number + comp.codComp + sessione.stagione.descrizione.replace('/','')
            new SessioneCompetizione
                (codice:codice,
                sessione:sessione, 
                competizione:comp, 
                dataInizio:sessione.stagione.dataInizio,
                dataFine:sessione.stagione.dataFine,
                stato:StatoCompetizione.get(StatoCompetizione.APERTA)).save()
        }
        
        redirect action:edit
    }
    
    def newCompetition = {
        render template:'newCompetition'
    }
    
    def addPhaseCompetition = {
        render template:'phaseCompetition', model:[idPhase:params.idPhase]
    }
    
    def addRoundCompetition = {
        render template:'roundCompetition', model:[idPhase:params.idPhase, idRound:params.idRound]
    }
    
    def editCompetition = {
        def comp = Competizione.get(params.id)
        
        render template:"editCompetition", model:[competizione:comp]
    }
    
    def editSession = {
        def sessione = Sessione.get(params.id)
        
        render template:"editSession", model:[sessione:sessione]
    }
    
    def newTeam = {
        render template:'newTeam'
    }
    
    def confirmTeam = {
        
        def squadra = new Squadra()
        squadra.nome = params.nome
        squadra.sigla = params.sigla
        squadra.nazionalita = Nazione.get(params.nazionalita)
        if (!squadra.hasErrors() && squadra.save(flush:true)) {
            flash.message = "Squadra ${squadra.nome} creata con successo"
        } else {
            flash.error = "Errore di inserimento della squadra"
        }
        
        redirect action:edit
    }
    
    def editTeam = {
        def squadra = Squadra.get(params.id)
        
        render template:'editTeam', model:[squadra:squadra]
    }
    
    def updateTeam = {
        
        def squadra = Squadra.get(params.id)
        squadra.nome = params.nome
        squadra.sigla = params.sigla
        squadra.nazionalita = Nazione.get(params.nazionalita)
        if (!squadra.hasErrors() && squadra.save(flush:true)) {
            flash.message = "Squadra ${squadra.nome} aggiornata con successo"
        } else {
            flash.error = "Errore di aggiornamento della squadra"
        }
        
        redirect action:edit
    }
}
