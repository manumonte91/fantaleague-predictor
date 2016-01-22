package it.flp

class SessioneCompetizione {
    
    String codice
    Sessione sessione
    Competizione competizione
    StatoCompetizione stato
    Date dataInizio
    Date dataFine
    
    static hasMany = [giocatori:SessioneGiocatore, 
        fasi: SessioneFaseCompetizione, 
        giornate:GiornataPronostico]

    static constraints = {
        codice blank: false, unique: true
        dataInizio(nullable: false)
        dataFine(nullable: false)
    }
}
