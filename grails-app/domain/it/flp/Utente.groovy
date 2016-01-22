package it.flp

class Utente {

	transient springSecurityService
        static searchable = true

        String email
        String nome
        String cognome
	String username
	String password
        String gender
        String birthday
        byte[] avatar
        String avatarType
        String avatarUrl
	boolean enabled = true
        boolean emailEnabled = false
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
        
        SortedSet socialList
        
        static hasMany = [
            socialList: OAuthID, 
            posts: Post, 
            notifications: Notifica]

	static transients = ['springSecurityService']

	static constraints = {
                email blank: false, unique: true
                nome blank: false
                cognome blank: false
		username blank: false, unique: true
		password blank: false
                avatar nullable:true, maxSize: 16384 /* 16K */
                avatarType nullable:true
                avatarUrl nullable:true
	}

	static mapping = {
		password column: '`password`'
                posts cascade: 'all', lazy: false
                //likes cascade: 'all', lazy: false
                //likesComment cascade: 'all', lazy: false
                notifications lazy: false
	}

	Set<Ruolo> getAuthorities() {
		UtenteRuolo.findAllByUtente(this).collect { it.ruolo }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}
        
        def getNomeEsteso() {
            return this.nome + " " + this.cognome
        }
        
        def getGiocatore() {
            Giocatore.findByUtente(this)
        }
        
        def getLikes() {
            Like.findAllByUtente(this)
        }
        
        def getLikesComment() {
            LikeCommento.findAllByUtente(this)
        }

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
