package it.flp

class TipoPost {
    
    String descrizione

    static constraints = {
        descrizione blank: false
    }
}
