package it.flp

class StagioneCompetizione {
    
    Stagione stagione
    Competizione competizione
    Date dataInizio
    Date dataFine
    
    static hasMany = [giornate:Giornata]

    static constraints = {
    }
}
