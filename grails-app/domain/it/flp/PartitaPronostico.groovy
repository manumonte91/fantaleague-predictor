package it.flp

class PartitaPronostico {
    
    Giocatore casa
    Giocatore trasferta
    Integer puntiCasa
    Integer puntiTrasferta
    Date dataPartita
    
    //static mappedBy = [giocatoreCasa:'casa', giocatoreTrasferta:'trasferta']
    
    static hasMany = [pronosticiCasa:Pronostico, pronosticiTrasferta:Pronostico]
    
    static belongsTo = [giornata:GiornataPronostico]

    static constraints = {
        puntiCasa nullable: true
        puntiTrasferta nullable: true
        dataPartita nullable: true
    }
}
