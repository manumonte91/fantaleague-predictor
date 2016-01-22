package it.flp

class Giocatore {
    
    String fantaLeague
    String coloreSociale1
    String coloreSociale2
    String coloreSociale3
    TipoColoriSociali tipoColoriSociali
    Utente utente
    
    static hasMany = [sessioni:SessioneGiocatore]

    static constraints = {
        fantaLeague blank: false, unique: true
        coloreSociale1 blank: false
        coloreSociale2 blank: true, nullable: true
        coloreSociale3 blank: true, nullable: true
        tipoColoriSociali blank: false
    }
    
    Set<PartitaPronostico> getPartiteCasa() {
        PartitaPronostico.findAllByCasa(this)
    }
    
    Set<PartitaPronostico> getPartiteTrasferta() {
        PartitaPronostico.findAllByTrasferta(this)
    }
}