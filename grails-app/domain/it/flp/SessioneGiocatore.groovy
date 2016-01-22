package it.flp

class SessioneGiocatore {
    
    SessioneCompetizione competizione
    Giocatore giocatore
    String riepilogo
    Integer presenze = 0
    Integer vittorie = 0
    Integer pareggi = 0
    Integer sconfitte = 0
    Integer pronosticiRisultati = 0
    Integer pronosticiEsiti = 0
    Integer pronosticiNulli = 0
    Integer puntiFatti = 0
    Integer puntiSubiti = 0
    Integer differenzaPunti = 0
    Integer mediaPunti = 0
    Integer mop = 0
    Integer bidoni = 0

    static constraints = {
        riepilogo nullable: true, blank: true
    }
}
