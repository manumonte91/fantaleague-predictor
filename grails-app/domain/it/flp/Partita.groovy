package it.flp

class Partita {
    
    Squadra casa
    Squadra trasferta
    Integer golCasa
    Integer golTrasferta
    Date dataPartita
    
    static hasMany = [pronostici:Pronostico]
    
    static belongsTo = [giornata:Giornata]
    
    static constraints = {
        golCasa nullable: true
        golTrasferta nullable: true
    }
    
}
