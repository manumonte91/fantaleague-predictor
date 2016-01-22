package it.flp

class CommonTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    
    def getSeasons = {
        def list = Stagione.findAll()
    }
    
    def getSessionsOfSeason = { attrs ->
        def idSeason = attrs.remove('idSeason')
        
        def sessions = Sessione.findAllByStagione(Stagione.get(idSeason as Long))
    }
}
