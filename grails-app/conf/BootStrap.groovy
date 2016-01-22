import it.flp.Utente
import it.flp.Ruolo
import it.flp.UtenteRuolo
import it.flp.TipoColoriSociali
import it.flp.Giocatore
import it.flp.TipoPost
import it.flp.TipoCompetizione
import it.flp.FormatoCompetizione
import it.flp.TipoTurnoCompetizione
import it.flp.FaseCompetizione
import it.flp.TurnoCompetizione
import it.flp.StatoCompetizione
import it.flp.StatoStagione
import it.flp.Competizione
import it.flp.Stagione
import it.flp.StagioneCompetizione
import it.flp.Sessione
import it.flp.SessioneCompetizione
import it.flp.SessioneFaseCompetizione
import it.flp.SessioneTurnoCompetizione
import it.flp.SessioneGiocatore
import it.flp.Nazione
import it.flp.Squadra
import it.flp.SquadraCompetizione

import java.text.SimpleDateFormat

class BootStrap {
    
    def sdf = new SimpleDateFormat("dd/MM/yyyy")

    def springSecurityService
    def init = { servletContext ->
        if (!Utente.count()) {
            new Utente(email:"super@email.it",emailEnabled:true,nome:"Super",cognome:"Visor",gender:"male",birthday:"01/01/1990",username:"super", password:"super").save()
            new Utente(email:"admin@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Admin",gender:"male",birthday:"01/01/1990",username:"admin", password:"admin").save()
            new Utente(email:"admin2@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf", password:"admin").save()
            new Utente(email:"admin3@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf2", password:"admin").save()
            new Utente(email:"admin4@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf3", password:"admin").save()
            new Utente(email:"admin5@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf4", password:"admin").save()
            new Utente(email:"admin6@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf5", password:"admin").save()
            new Utente(email:"admin7@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf6", password:"admin").save()
            new Utente(email:"admin8@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf7", password:"admin").save()
            new Utente(email:"admin9@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf8", password:"admin").save()
            new Utente(email:"admin10@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf9", password:"admin").save()
            new Utente(email:"admin11@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf10", password:"admin").save()
            new Utente(email:"admin12@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf11", password:"admin").save()
            new Utente(email:"admin13@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf12", password:"admin").save()
            new Utente(email:"admin14@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf13", password:"admin").save()
            new Utente(email:"admin15@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf14", password:"admin").save()
            new Utente(email:"admin16@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf15", password:"admin").save()
            new Utente(email:"admin17@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf16", password:"admin").save()
            new Utente(email:"admin18@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf17", password:"admin").save()
            new Utente(email:"admin19@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf18", password:"admin").save()
            new Utente(email:"admin20@gmail.com",emailEnabled:true,nome:"Admin",cognome:"Female",gender:"female",birthday:"01/01/1988",username:"adminf19", password:"admin").save(flush:true)
        }
        if (!Ruolo.count()) {
            new Ruolo(authority:"SUPERVISOR").save()
            new Ruolo(authority:"ADMINISTRATOR").save()
            new Ruolo(authority:"USER").save(flush:true)
        }
        if (!UtenteRuolo.count()) {
            new UtenteRuolo(utente:Utente.get(1), ruolo:Ruolo.get(Ruolo.SUPERVISOR)).save()
            new UtenteRuolo(utente:Utente.get(2), ruolo:Ruolo.get(Ruolo.ADMINISTRATOR)).save()
            new UtenteRuolo(utente:Utente.get(3), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(4), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(5), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(6), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(7), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(8), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(9), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(10), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(11), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(12), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(13), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(14), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(15), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(16), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(17), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(18), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(19), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(20), ruolo:Ruolo.get(Ruolo.USER)).save()
            new UtenteRuolo(utente:Utente.get(21), ruolo:Ruolo.get(Ruolo.USER)).save(flush:true)
        }
        if (!TipoColoriSociali.count()) {
            new TipoColoriSociali(descrizione:"Neutro").save()
            new TipoColoriSociali(descrizione:"Orizzontale largo").save()
            new TipoColoriSociali(descrizione:"Orizzontale stretto").save()
            new TipoColoriSociali(descrizione:"Verticale largo").save()
            new TipoColoriSociali(descrizione:"Verticale stretto").save()
            new TipoColoriSociali(descrizione:"Diagonale sx largo").save()
            new TipoColoriSociali(descrizione:"Diagonale sx stretto").save()
            new TipoColoriSociali(descrizione:"Diagonale dx largo").save()
            new TipoColoriSociali(descrizione:"Diagonale dx largo").save()
            new TipoColoriSociali(descrizione:"Striscia orizzontale larga").save()
            new TipoColoriSociali(descrizione:"Striscia orizzontale stretta").save()
            new TipoColoriSociali(descrizione:"Striscia verticale larga").save()
            new TipoColoriSociali(descrizione:"Striscia verticale stretta").save()
            new TipoColoriSociali(descrizione:"Striscia diagonale sx larga").save()
            new TipoColoriSociali(descrizione:"Striscia diagonale sx stretta").save()
            new TipoColoriSociali(descrizione:"Striscia diagonale dx larga").save()
            new TipoColoriSociali(descrizione:"Striscia diagonale dx stretta").save(flush:true)
        }
        if (!Giocatore.count()) {
            new Giocatore(fantaLeague:"Team 1", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(1)).save()
            new Giocatore(fantaLeague:"Team 2", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(2)).save()
            new Giocatore(fantaLeague:"Team 3", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(3)).save()
            new Giocatore(fantaLeague:"Team 4", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(4)).save()
            new Giocatore(fantaLeague:"Team 5", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(5)).save()
            new Giocatore(fantaLeague:"Team 6", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(6)).save()
            new Giocatore(fantaLeague:"Team 7", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(7)).save()
            new Giocatore(fantaLeague:"Team 8", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(8)).save()
            new Giocatore(fantaLeague:"Team 9", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(9)).save()
            new Giocatore(fantaLeague:"Team 10", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(10)).save()
            new Giocatore(fantaLeague:"Team 11", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(11)).save()
            new Giocatore(fantaLeague:"Team 12", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(12)).save()
            new Giocatore(fantaLeague:"Team 13", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(13)).save()
            new Giocatore(fantaLeague:"Team 14", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(14)).save()
            new Giocatore(fantaLeague:"Team 15", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(15)).save()
            new Giocatore(fantaLeague:"Team 16", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(16)).save()
            new Giocatore(fantaLeague:"Team 17", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(17)).save()
            new Giocatore(fantaLeague:"Team 18", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(18)).save()
            new Giocatore(fantaLeague:"Team 19", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(19)).save()
            new Giocatore(fantaLeague:"Team 20", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(20)).save()
            new Giocatore(fantaLeague:"Team 21", coloreSociale1: "#FFFFFF", tipoColoriSociali:TipoColoriSociali.get(1), utente:Utente.get(21)).save(flush:true)
        }
        if (!TipoPost.count()) {
            new TipoPost(descrizione:"Globale").save()
            new TipoPost(descrizione:"Amici di amici").save()
            new TipoPost(descrizione:"Solo amici").save(flush:true)
        }
        if (!TipoCompetizione.count()) {
            new TipoCompetizione(descrizione:"Ufficiale").save()
            new TipoCompetizione(descrizione:"myFantaLeague").save(flush:true)
        }
        if (!FormatoCompetizione.count()) {
            new FormatoCompetizione(descrizione: "Campionato all'italiana").save()
            new FormatoCompetizione(descrizione: "Fase a eliminazione diretta").save()
            new FormatoCompetizione(descrizione: "Fase a gironi + Fase finale").save()
            new FormatoCompetizione(descrizione: "Girone unico").save()
            new FormatoCompetizione(descrizione: "Girone unico + Fase finale").save(flush:true)
        }
        if (!StatoStagione.count()) {
            new StatoStagione(descrizione:"Aperta").save()
            new StatoStagione(descrizione:"In corso").save()
            new StatoStagione(descrizione:"Sospesa").save()
            new StatoStagione(descrizione:"Chiusa").save(flush:true)
        }
        if (!Stagione.count()) {
            new Stagione(descrizione:"2014/2015", dataInizio:sdf.parse("01/08/2014"), dataFine:sdf.parse("30/06/2015"),stato:StatoStagione.get(1)).save(flush:true)
        }
        if (!StatoCompetizione.count()) {
            new StatoCompetizione(descrizione:"Aperta").save()
            new StatoCompetizione(descrizione:"In corso").save()
            new StatoCompetizione(descrizione:"Sospesa").save()
            new StatoCompetizione(descrizione:"Chiusa").save(flush:true)
        }
        if (!Competizione.count()) {
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.CAMPIONATO_ITALIANA), squadre:20, siglaNazione:"IT", codComp:"A", descrizione:"Serie A").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.CAMPIONATO_ITALIANA), squadre:20, siglaNazione:"EN", codComp:"A", descrizione:"Premier League").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.CAMPIONATO_ITALIANA), squadre:20, siglaNazione:"ES", codComp:"A", descrizione:"Liga BBVA").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.CAMPIONATO_ITALIANA), squadre:18, siglaNazione:"DE", codComp:"A", descrizione:"Bundesliga").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.CAMPIONATO_ITALIANA), squadre:20, siglaNazione:"FR", codComp:"A", descrizione:"Ligue 1").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONE_UNICO), squadre:66, siglaNazione:"PU", codComp:"C", descrizione:"Preliminare UEFA").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONI_FASE_FINALE), squadre:32, siglaNazione:"CL", codComp:"C", descrizione:"UEFA Champions League").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONI_FASE_FINALE), squadre:48, siglaNazione:"EL", codComp:"C", descrizione:"UEFA Europa League").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.FASE_FINALE), squadre:2, siglaNazione:"SC", codComp:"C", descrizione:"UEFA Super Cup").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONE_UNICO_FASE_FINALE), squadre:20, siglaNazione:"IT", codComp:"N", descrizione:"Tim Cup").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONE_UNICO_FASE_FINALE), squadre:20, siglaNazione:"EN", codComp:"N", descrizione:"FA Cup").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONE_UNICO_FASE_FINALE), squadre:20, siglaNazione:"ES", codComp:"N", descrizione:"Copa del Rey").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONE_UNICO_FASE_FINALE), squadre:18, siglaNazione:"DE", codComp:"N", descrizione:"DFB-Pokal").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.GIRONE_UNICO_FASE_FINALE), squadre:20, siglaNazione:"FR", codComp:"N", descrizione:"Coupe de France").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.FASE_FINALE), squadre:2, siglaNazione:"IT", codComp:"S", descrizione:"Supercoppa Tim").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.FASE_FINALE), squadre:2, siglaNazione:"EN", codComp:"S", descrizione:"FA Community Shield").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.FASE_FINALE), squadre:2, siglaNazione:"ES", codComp:"S", descrizione:"Supercopa de Espana").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.FASE_FINALE), squadre:2, siglaNazione:"DE", codComp:"S", descrizione:"DFL-Supercup").save()
            new Competizione(tipoComp:TipoCompetizione.get(1), formato:FormatoCompetizione.get(FormatoCompetizione.FASE_FINALE), squadre:2, siglaNazione:"FR", codComp:"S", descrizione:"Tropheé des Champions").save(flush:true)
        }
        if (!StagioneCompetizione.count()) {
            def stagione = Stagione.get(1)
            for (int i = 0; i < 18; i++) {
                new StagioneCompetizione(stagione:stagione, competizione:Competizione.get(i+1), dataInizio:stagione.dataInizio, dataFine:stagione.dataFine).save()
            }
            new StagioneCompetizione(stagione:Stagione.get(1), competizione:Competizione.get(19), dataInizio:stagione.dataInizio, dataFine:stagione.dataFine).save(flush:true)
        }
        if (!TipoTurnoCompetizione.count()) {
            new TipoTurnoCompetizione(descrizione:"Girone unico").save()
            new TipoTurnoCompetizione(descrizione:"Gironi").save()
            new TipoTurnoCompetizione(descrizione:"Trentaduesimi di finale").save()
            new TipoTurnoCompetizione(descrizione:"Sedicesimi di finale").save()
            new TipoTurnoCompetizione(descrizione:"Ottavi di finale").save()
            new TipoTurnoCompetizione(descrizione:"Quarti di finale").save()
            new TipoTurnoCompetizione(descrizione:"Semifinali").save()
            new TipoTurnoCompetizione(descrizione:"Finale").save(flush:true)
        }
        if (!FaseCompetizione.count()) {
            new FaseCompetizione(descrizione:"Girone unico", competizione:Competizione.findByDescrizione("Preliminare UEFA")).save()
            
            new FaseCompetizione(descrizione:"Fase a gironi", competizione:Competizione.findByDescrizione("UEFA Champions League")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("UEFA Champions League")).save()
            
            new FaseCompetizione(descrizione:"Fase a gironi", competizione:Competizione.findByDescrizione("UEFA Europa League")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("UEFA Europa League")).save()
            
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("UEFA Super Cup")).save()
            
            new FaseCompetizione(descrizione:"Girone unico", competizione:Competizione.findByDescrizione("Tim Cup")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("Tim Cup")).save()
            
            new FaseCompetizione(descrizione:"Girone unico", competizione:Competizione.findByDescrizione("FA Cup")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("FA Cup")).save()
            
            new FaseCompetizione(descrizione:"Girone unico", competizione:Competizione.findByDescrizione("Copa del Rey")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("Copa del Rey")).save()
            
            new FaseCompetizione(descrizione:"Girone unico", competizione:Competizione.findByDescrizione("DFB-Pokal")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("DFB-Pokal")).save()
            
            new FaseCompetizione(descrizione:"Girone unico", competizione:Competizione.findByDescrizione("Coupe de France")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("Coupe de France")).save()
            
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("Supercoppa Tim")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("FA Community Shield")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("Supercopa de Espana")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("DFL-Supercup")).save()
            new FaseCompetizione(descrizione:"Fase a eliminazione diretta", competizione:Competizione.findByDescrizione("Tropheé des Champions")).save(flush:true)
        }
        if (!TurnoCompetizione.count()) {
            new TurnoCompetizione(descrizione:"Turno Preliminare", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONE_UNICO), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(1)).save()
            new TurnoCompetizione(descrizione:"Playoff", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONE_UNICO), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(1)).save()
            
            new TurnoCompetizione(descrizione:"Girone A", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:"Girone B", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:"Girone C", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:"Girone D", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:"Girone E", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:"Girone F", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:"Girone G", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:"Girone H", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(2)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(3)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(3)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(3)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(3)).save()
            
            new TurnoCompetizione(descrizione:"Girone A", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone B", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone C", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone D", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone E", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone F", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone G", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone H", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone I", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone J", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone K", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:"Girone L", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(4)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEDICESIMI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEDICESIMI_FINALE), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(5)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE), andataRitorno:true, sorteggio:false, fase:FaseCompetizione.get(5)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(5)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI), andataRitorno:true, sorteggio:true, fase:FaseCompetizione.get(5)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(5)).save()
            
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(6)).save()
            
            new TurnoCompetizione(descrizione:"Turno Preliminare", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONE_UNICO), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(7)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(8)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(8)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI), andataRitorno:true, sorteggio:false, fase:FaseCompetizione.get(8)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(8)).save()
            
            new TurnoCompetizione(descrizione:"Turno Preliminare", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONE_UNICO), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(9)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(10)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(10)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(10)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(10)).save()
            
            new TurnoCompetizione(descrizione:"Turno Preliminare", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONE_UNICO), andataRitorno:true, sorteggio:false, fase:FaseCompetizione.get(11)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE), andataRitorno:true, sorteggio:false, fase:FaseCompetizione.get(12)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE), andataRitorno:true, sorteggio:false, fase:FaseCompetizione.get(12)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI), andataRitorno:true, sorteggio:false, fase:FaseCompetizione.get(12)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(12)).save()
            
            new TurnoCompetizione(descrizione:"Turno Preliminare", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONE_UNICO), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(13)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(14)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(14)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(14)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(14)).save()
            
            new TurnoCompetizione(descrizione:"Turno Preliminare", tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.GIRONE_UNICO), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(15)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.OTTAVI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(16)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.QUARTI_FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(16)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.SEMIFINALI), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(16)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(16)).save()
            
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(17)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(18)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:true, sorteggio:false, fase:FaseCompetizione.get(19)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(20)).save()
            new TurnoCompetizione(descrizione:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE).descrizione, tipo:TipoTurnoCompetizione.get(TipoTurnoCompetizione.FINALE), andataRitorno:false, sorteggio:false, fase:FaseCompetizione.get(21)).save(flush:true)
        }
        if (!Sessione.count()) {
            new Sessione(descrizione:"Sessione 1", stagione:Stagione.get(1)).save(flush:true)
        }
        if (!SessioneCompetizione.count()) {
            def sessione = Sessione.get(1)
            def codice = ""
            def number = Sessione.count() < 10 ? "0" + Sessione.count() : Sessione.count()
            for (int i = 0; i < 18; i++) {
                def comp = Competizione.get(i+1)
                codice = comp.siglaNazione + number + comp.codComp + sessione.stagione.descrizione.replace('/','')
                new SessioneCompetizione(codice:codice,
                    sessione:sessione, 
                    competizione:comp, 
                    dataInizio:sessione.stagione.dataInizio,
                    dataFine:sessione.stagione.dataFine,
                    stato:StatoCompetizione.get(StatoCompetizione.APERTA)).save()
            }
            def comp = Competizione.get(19)
            codice = comp.siglaNazione + number + comp.codComp + sessione.stagione.descrizione.replace('/','')
            new SessioneCompetizione(codice:codice,
                    sessione:sessione, 
                    competizione:comp, 
                    dataInizio:sessione.stagione.dataInizio,
                    dataFine:sessione.stagione.dataFine,
                    stato:StatoCompetizione.get(StatoCompetizione.APERTA)).save(flush:true)
        }
        if (!SessioneFaseCompetizione.count()) {
            for (int s = 7; s < 9; s++) {
                def sessione = SessioneCompetizione.get(s)
                sessione.fasi.each { fase ->
                    def newFase = new SessioneFaseCompetizione(descrizione:fase.descrizione)
                    fase.turni.each { turno ->
                        for (int i = 0; i < num; i++) {
                            def newTurno = new SessioneTurnoCompetizione()
                            newTurno.descrizione = turno.descrizione
                            newTurno.tipo = turno.tipo
                            newTurno.andataRitorno = turno.andataRitorno
                            newTurno.sorteggio = turno.sorteggio
                            newFase.addToTurni(newTurno)
                        }
                    }
                    newFase.save(flush:true)
                }
            }
        }
        if (!SessioneGiocatore.count()) {
            def comp = SessioneCompetizione.get(1)
            for (int i = 0; i < 19; i++) {
                new SessioneGiocatore(competizione:comp, 
                    giocatore:Giocatore.get(i+2)).save()
            }
            new SessioneGiocatore(competizione:comp, 
                    giocatore:Giocatore.get(21)).save(flush:true)
        }
        if (!Nazione.count()) {
            new Nazione(nome:"Italia", sigla:"ITA").save()
            new Nazione(nome:"Inghilterra", sigla:"ENG").save()
            new Nazione(nome:"Spagna", sigla:"ESP").save()
            new Nazione(nome:"Germania", sigla:"GER").save()
            new Nazione(nome:"Francia", sigla:"FRA").save()
            new Nazione(nome:"Olanda", sigla:"NED").save()
            new Nazione(nome:"Belgio", sigla:"BEL").save()
            new Nazione(nome:"Cipro", sigla:"CYP").save()
            new Nazione(nome:"Kazakistan", sigla:"KAZ").save()
            new Nazione(nome:"Grecia", sigla:"GRE").save()
            new Nazione(nome:"Svizzera", sigla:"SUI").save()
            new Nazione(nome:"Bielorussia", sigla:"BLR").save()
            new Nazione(nome:"Portogallo", sigla:"POR").save()
            new Nazione(nome:"Turchia", sigla:"TUR").save()
            new Nazione(nome:"Russia", sigla:"RUS").save()
            new Nazione(nome:"Scozia", sigla:"SCO").save()
            new Nazione(nome:"Ucraina", sigla:"UKR").save()
            new Nazione(nome:"Croazia", sigla:"CRO").save()
            new Nazione(nome:"Polonia", sigla:"POL").save()
            new Nazione(nome:"Israele", sigla:"ISR").save()
            new Nazione(nome:"Svezia", sigla:"SWE").save()
            new Nazione(nome:"Danimarca", sigla:"DEN").save()
            new Nazione(nome:"Norvegia", sigla:"NOR").save()
            new Nazione(nome:"Serbia", sigla:"SRB").save()
            new Nazione(nome:"Azerbaijan", sigla:"AZE").save()
            new Nazione(nome:"Austria", sigla:"AUS").save()
            new Nazione(nome:"Albania", sigla:"ALB").save()
            new Nazione(nome:"Repubblica Ceca", sigla:"CZE").save(flush:true)
        }
        if (!Squadra.count()) {
            new Squadra(nome:"Atalanta", sigla:"ATA", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Bologna", sigla:"BOL", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Carpi", sigla:"CAR", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Chievo Verona", sigla:"CHI", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Empoli", sigla:"EMP", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Fiorentina", sigla:"FIO", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Frosinone", sigla:"FRO", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Genoa", sigla:"GEN", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Inter", sigla:"INT", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Juventus", sigla:"JUV", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Lazio", sigla:"LAZ", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Milan", sigla:"MIL", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Napoli", sigla:"NAP", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Palermo", sigla:"PAL", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Roma", sigla:"ROM", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Sampdoria", sigla:"SAM", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Sassuolo", sigla:"SAS", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Torino", sigla:"TOR", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Udinese", sigla:"UDI", nazionalita: Nazione.get(1)).save()
            new Squadra(nome:"Verona", sigla:"VER", nazionalita: Nazione.get(1)).save()
            
            new Squadra(nome:"Arsenal", sigla:"ARS", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Aston Villa", sigla:"AVL", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Bournemouth", sigla:"BOU", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Chelsea", sigla:"CHE", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Crystal Palace", sigla:"CRY", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Everton", sigla:"EVE", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Leicester City", sigla:"LEI", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Liverpool", sigla:"LVP", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Manchester City", sigla:"MCI", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Manchester United", sigla:"MUN", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Newcastle", sigla:"NEW", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Norwich City", sigla:"NOR", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Southampton", sigla:"SOU", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Stoke City", sigla:"STK", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Sunderland", sigla:"SUN", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Swansea City", sigla:"SWA", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Tottenham", sigla:"TOT", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"Watford", sigla:"WAT", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"West Bromwich Albion", sigla:"WBA", nazionalita: Nazione.get(2)).save()
            new Squadra(nome:"West Ham", sigla:"WHU", nazionalita: Nazione.get(2)).save()
            
            new Squadra(nome:"Athletic Bilbao", sigla:"ATH", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Atlético Madrid", sigla:"ATM", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Barcellona", sigla:"BAR", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Betis", sigla:"BET", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Celta Vigo", sigla:"CVI", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Deportivo La Coruna", sigla:"DEP", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Eibar", sigla:"EIB", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Espanyol", sigla:"ELC", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Getafe", sigla:"GET", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Granada", sigla:"GRA", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Las Palmas", sigla:"LPM", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Levante", sigla:"LEV", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Malaga", sigla:"MLG", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Rayo Vallecano", sigla:"RVA", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Real Madrid", sigla:"RMA", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Real Sociedad", sigla:"RSO", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Siviglia", sigla:"SIV", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Sporting Gijon", sigla:"GIJ", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Valencia", sigla:"VAL", nazionalita: Nazione.get(3)).save()
            new Squadra(nome:"Villareal", sigla:"VIL", nazionalita: Nazione.get(3)).save()
            
            new Squadra(nome:"Amburgo", sigla:"AMB", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Augsburg", sigla:"AUG", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Bayer Leverkusen", sigla:"BLE", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Bayern Monaco", sigla:"BAY", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Borussia Dortmund", sigla:"BDO", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Borussia Moenchengladbach", sigla:"MGB", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Colonia", sigla:"COL", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Darmstadt", sigla:"DAR", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Eintracht Frankfurt", sigla:"EIN", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Hannover", sigla:"HAN", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Hertha Berlino", sigla:"HER", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Hoffenheim", sigla:"HOF", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Ingolstadt", sigla:"ING", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Mainz", sigla:"MAI", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Schalke 04", sigla:"SCH", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Stoccarda", sigla:"STO", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Werder Brema", sigla:"WER", nazionalita: Nazione.get(4)).save()
            new Squadra(nome:"Wolfsburg", sigla:"WOL", nazionalita: Nazione.get(4)).save()
            
            new Squadra(nome:"Angers", sigla:"ANG", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Bastia", sigla:"BAS", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Bordeaux", sigla:"BOR", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Caen", sigla:"CAE", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Gazelec Ajaccio", sigla:"GAJ", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Guingamp", sigla:"GUI", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Lilla", sigla:"LIL", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Lione", sigla:"LIO", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Lorient", sigla:"LOR", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Marsiglia", sigla:"MAR", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Monaco", sigla:"MON", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Montpellier", sigla:"MNT", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Nantes", sigla:"NAN", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Nizza", sigla:"NIZ", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Paris Saint-Germain", sigla:"PSG", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Rennes", sigla:"REN", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Saint-Etienne", sigla:"SET", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Stade Reims", sigla:"SRE", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Tolosa", sigla:"TOL", nazionalita: Nazione.get(5)).save()
            new Squadra(nome:"Troyes", sigla:"TRO", nazionalita: Nazione.get(5)).save()
            
            new Squadra(nome:"AZ Alkmaar", sigla:"AZ", nazionalita: Nazione.get(6)).save()
            new Squadra(nome:"Ajax", sigla:"AJA", nazionalita: Nazione.get(6)).save()
            new Squadra(nome:"Anderlecht", sigla:"AND", nazionalita: Nazione.get(7)).save()
            new Squadra(nome:"Apoel Nicosia", sigla:"APO", nazionalita: Nazione.get(8)).save()
            new Squadra(nome:"Astana", sigla:"AST", nazionalita: Nazione.get(9)).save()
            new Squadra(nome:"Asteras", sigla:"ATR", nazionalita: Nazione.get(10)).save()
            new Squadra(nome:"Basilea", sigla:"BAS", nazionalita: Nazione.get(11)).save()
            new Squadra(nome:"Bate Borisov", sigla:"BAT", nazionalita: Nazione.get(12)).save()
            new Squadra(nome:"Belenenses", sigla:"BEL", nazionalita: Nazione.get(13)).save()
            new Squadra(nome:"Benfica", sigla:"BEN", nazionalita: Nazione.get(13)).save()
            new Squadra(nome:"Besiktas", sigla:"BES", nazionalita: Nazione.get(14)).save()
            new Squadra(nome:"Braga", sigla:"BRA", nazionalita: Nazione.get(13)).save()
            new Squadra(nome:"Brugge", sigla:"BRU", nazionalita: Nazione.get(7)).save()
            new Squadra(nome:"CSKA Mosca", sigla:"CSK", nazionalita: Nazione.get(15)).save()
            new Squadra(nome:"Celtic", sigla:"CEL", nazionalita: Nazione.get(16)).save()
            new Squadra(nome:"Dinamo Kiev", sigla:"DKV", nazionalita: Nazione.get(17)).save()
            new Squadra(nome:"Dinamo Minsk", sigla:"DMK", nazionalita: Nazione.get(12)).save()
            new Squadra(nome:"Dinamo Zagabria", sigla:"DZG", nazionalita: Nazione.get(18)).save()
            new Squadra(nome:"Dnipro", sigla:"DNI", nazionalita: Nazione.get(17)).save()
            new Squadra(nome:"Fenerbahce", sigla:"FEN", nazionalita: Nazione.get(14)).save()
            new Squadra(nome:"Galatasaray", sigla:"GAL", nazionalita: Nazione.get(14)).save()
            new Squadra(nome:"Gent", sigla:"GNT", nazionalita: Nazione.get(7)).save()
            new Squadra(nome:"Groningen", sigla:"GRO", nazionalita: Nazione.get(6)).save()
            new Squadra(nome:"Krasnodar", sigla:"KRA", nazionalita: Nazione.get(15)).save()
            new Squadra(nome:"Lech Poznan", sigla:"LPZ", nazionalita: Nazione.get(19)).save()
            new Squadra(nome:"Legia Varsavia", sigla:"LEG", nazionalita: Nazione.get(19)).save()
            new Squadra(nome:"Lokomotiv Mosca", sigla:"LMO", nazionalita: Nazione.get(15)).save()
            new Squadra(nome:"Maccabi Tel-Aviv", sigla:"MTA", nazionalita: Nazione.get(20)).save()
            new Squadra(nome:"Malmo", sigla:"MAL", nazionalita: Nazione.get(21)).save()
            new Squadra(nome:"Midtjylland", sigla:"MID", nazionalita: Nazione.get(22)).save()
            new Squadra(nome:"Molde", sigla:"MOL", nazionalita: Nazione.get(23)).save()
            new Squadra(nome:"Olympiacos", sigla:"OLY", nazionalita: Nazione.get(10)).save()
            new Squadra(nome:"PAOK", sigla:"PAO", nazionalita: Nazione.get(10)).save()
            new Squadra(nome:"PSV Eindhoven", sigla:"PSV", nazionalita: Nazione.get(6)).save()
            new Squadra(nome:"Partizan Belgrado", sigla:"PAR", nazionalita: Nazione.get(24)).save()
            new Squadra(nome:"Porto", sigla:"POR", nazionalita: Nazione.get(13)).save()
            new Squadra(nome:"Qabala", sigla:"QAB", nazionalita: Nazione.get(25)).save()
            new Squadra(nome:"Qarabag", sigla:"QAR", nazionalita: Nazione.get(25)).save()
            new Squadra(nome:"Rapid Vienna", sigla:"RVN", nazionalita: Nazione.get(26)).save()
            new Squadra(nome:"Rosenborg", sigla:"ROS", nazionalita: Nazione.get(23)).save()
            new Squadra(nome:"Rubin Kazan", sigla:"RUB", nazionalita: Nazione.get(15)).save()
            new Squadra(nome:"Shakhtar Donetsk", sigla:"SHA", nazionalita: Nazione.get(17)).save()
            new Squadra(nome:"Sion", sigla:"SIO", nazionalita: Nazione.get(11)).save()
            new Squadra(nome:"Skenderbeu", sigla:"SKE", nazionalita: Nazione.get(27)).save()
            new Squadra(nome:"Slovan Liberec", sigla:"SLB", nazionalita: Nazione.get(28)).save()
            new Squadra(nome:"Sparta Praga", sigla:"SPR", nazionalita: Nazione.get(28)).save()
            new Squadra(nome:"Sporting Lisbona", sigla:"SCP", nazionalita: Nazione.get(13)).save()
            new Squadra(nome:"Viktoria Plzen", sigla:"PLZ", nazionalita: Nazione.get(28)).save()
            new Squadra(nome:"Zenit", sigla:"ZEN", nazionalita: Nazione.get(15)).save(flush:true)
        }
        if (!SquadraCompetizione.count()) {
            for (int i = 0; i < 20; i++) {
                new SquadraCompetizione(squadra:Squadra.get(i+1), competizione:StagioneCompetizione.get(1)).save()
            }
            for (int i = 0; i < 20; i++) {
                new SquadraCompetizione(squadra:Squadra.get(i+21), competizione:StagioneCompetizione.get(2)).save()
            }
            for (int i = 0; i < 20; i++) {
                new SquadraCompetizione(squadra:Squadra.get(i+41), competizione:StagioneCompetizione.get(3)).save()
            }
            for (int i = 0; i < 18; i++) {
                new SquadraCompetizione(squadra:Squadra.get(i+61), competizione:StagioneCompetizione.get(4)).save()
            }
            for (int i = 0; i < 19; i++) {
                new SquadraCompetizione(squadra:Squadra.get(i+79), competizione:StagioneCompetizione.get(5)).save()
            }
            new SquadraCompetizione(squadra:Squadra.get(98), competizione:StagioneCompetizione.get(5)).save(flush:true)
        }
    }
    def destroy = {
    }
}