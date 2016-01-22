package it.flp

class Squadra {

    String nome
    String sigla
    Nazione nazionalita

    static constraints = {
        nome(blank: false, unique: true)
        nazionalita(blank: false)
    }

    static mapping = {
        //table 'P_SQUADRA'
    }
}
