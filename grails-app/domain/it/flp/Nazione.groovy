package it.flp

class Nazione {

    String nome
    String sigla

    static constraints = {
        nome blank: false
        sigla maxSize: 3, unique: true
    }

    static mapping = {
        //table 'NAZIONE'
    }
    
}
