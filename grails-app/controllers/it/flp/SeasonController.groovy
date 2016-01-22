package it.flp

class SeasonController {

    def index = {
        def user = Giocatore.findByUtente(Utente.get(session.user.id))
        def isSubscribed = SessioneGiocatore.findByGiocatore(user)
        
        if (isSubscribed) {
            redirect action: view
        } else {
            redirect action: open
        }
    }
    
    def open = {
        // visualizzo le competizioni dove posso iscrivermi
        def season = Stagione.findWhere(stato:StatoStagione.get(StatoStagione.APERTA))
        def list = Sessione.createCriteria().list {
            and {
                stagione {
                    eq("id", season.id)
                }
            }
        }
        
        render view:'open', model:[sessioni:list]
    }
    
    def popupSure = {
        def giocatore = Utente.get(session.user.id).giocatore
        def comp = SessioneCompetizione.get(params.id as Long)
        render template:'confirm', model:[comp:comp, giocatore:giocatore]
    }
    
    def confirmCompetition = {
        def player = Giocatore.get(params.idPlayer as Long)
        def comp = SessioneCompetizione.get(params.idComp as Long)
        def cup = SessioneCompetizione.createCriteria().list {
            competizione {
                and {
                    eq("siglaNazione", comp.competizione.siglaNazione)
                    eq("codComp", "N")
                }
            }
        }[0]
        def uefaCup = SessioneCompetizione.createCriteria().list {
            competizione {
                and {
                    eq("siglaNazione", "PU")
                    eq("codComp", "C")
                }
            }
        }[0]
        
        def newComp = new SessioneGiocatore()
        newComp.giocatore = player
        newComp.competizione = comp
        newComp.save(flush:true)
        
        def cupComp = new SessioneGiocatore()
        cupComp.giocatore = player
        cupComp.competizione = cup
        cupComp.save(flush:true)
        
        def uefaCupComp = new SessioneGiocatore()
        uefaCupComp.giocatore = player
        uefaCupComp.competizione = uefaCup
        uefaCupComp.save(flush:true)
        
        flash.message = "Iscrizione alla ${comp.competizione.descrizione} effettuata con successo"
        
        def list = SessioneGiocatore.createCriteria().list {
            competizione {
                sessione {
                    stagione {
                        eq("id", comp.sessione.stagione.id)
                    }
                }
            }
            giocatore {
                eq("id", player.id)
            }
        }
        
        render view:'view', model:[sessioni:list]
    }
    
    def view = {
        def player = Utente.get(session.user.id).giocatore
        // visualizzo le competizioni dove sono iscritto
        def season = Stagione.createCriteria().list {
            stato {
                or {
                    eq('id',StatoStagione.APERTA as Long)
                    eq('id',StatoStagione.IN_CORSO as Long)
                }
            }
        }[0]
        def list = SessioneGiocatore.createCriteria().list {
            competizione {
                sessione {
                    stagione {
                        eq("id", season.id)
                    }
                }
            }
            giocatore {
                eq("id", player.id)
            }
        }
        
        render view:'view', model:[sessioni:list]
    }
}
