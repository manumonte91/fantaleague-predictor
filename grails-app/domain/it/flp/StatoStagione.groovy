package it.flp

class StatoStagione {
    
    static int APERTA = 1
    static int IN_CORSO = 2
    static int SOSPESA = 3
    static int CHIUSA = 4
    
    String descrizione

    static constraints = {
        descrizione blank: false
    }
}
