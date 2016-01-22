package it.flp

class TurnoCompetizione {
    
    String descrizione
    TipoTurnoCompetizione tipo
    boolean andataRitorno
    boolean sorteggio = false
    
    static belongsTo = [fase:FaseCompetizione]

    static constraints = {
        descrizione blank: false
        tipo nullable: false
        andataRitorno nullable: false
        sorteggio nullable: false
    }
}
