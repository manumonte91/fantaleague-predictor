package it.flp

class SessioneTurnoCompetizione {

    String descrizione
    TipoTurnoCompetizione tipo
    boolean andataRitorno
    boolean sorteggio = false
    
    static belongsTo = [fase: SessioneFaseCompetizione]
    
    static hasMany = [giocatori: SessioneGiocatore, giornate: GiornataPronostico]

    static constraints = {
        descrizione blank: false
        tipo nullable: false
        andataRitorno nullable: false
        sorteggio nullable: false
    }
}
