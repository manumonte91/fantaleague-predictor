package it.flp

class Ruolo {

    static int SUPERVISOR = 1
    static int ADMINISTRATOR = 2
    static int USER = 3
    
	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
