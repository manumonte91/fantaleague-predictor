package it.flp

class Stagione {

    String descrizione
    StatoStagione stato
    Date dataInizio
    Date dataFine
    
    static hasMany = [competizioni:StagioneCompetizione, sessioni:Sessione]

    static constraints = {
        descrizione(nullable: false, unique: true)
        stato(nullable: false)
        dataInizio(nullable: false)
        dataFine(nullable: false)
    }
    
    static mapping = {
        //table 'P_STAGIONE'
    }
    
}
