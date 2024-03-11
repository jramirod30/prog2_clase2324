
public class GuiaTelefonosOrd {
	private Contacto[] guia;
	private int numContactos;

	// Constructor
	public GuiaTelefonosOrd(int capacidad) {
		guia = new Contacto[capacidad];
		numContactos = 0;
	}

	// A�adir contacto
	public void poner(Contacto contacto) {
		if (numContactos < guia.length) {     // hay sitio
			int i;
			for(i = numContactos - 1; i >= 0 && 
					guia[i].getNombre().compareTo(contacto.getNombre()) > 0; 
					i--)
				guia[i + 1] = guia[i];
			
			guia[i+1] = contacto;
			numContactos++;			
		}
	}

	// Eliminar contacto
	public void quitar(Contacto contacto) {
		int pos = buscarPos(contacto.getNombre());
		
		if (pos != -1) {
			// lo ha encontrado
			for(int i = pos; i < numContactos - 1; i++)
				guia[i] = guia[i+1];
			
			numContactos--;
		}
	}

	// Presentar con formato
	public String toString() {
		String texto = "";
		for (int k = 0; k < numContactos; k++) {  // procesar todos
			texto = texto + guia[k] + "\n";       // un contacto por l�nea
		}
		return texto;
	}

	// B�squedas
	public Contacto buscarNombre(String nombre) {
		int pos = buscarPos(nombre);		
		return pos != -1 ? 	guia[pos] : null;
	}
	
	private int buscarPos(String nombre) {
		int primero = 0;
		int ultimo = numContactos - 1;
		
		while (primero < ultimo) {
			int centro = (primero + ultimo)/2;
			if (guia[centro].getNombre().compareTo(nombre) > 0) {
				ultimo = centro - 1;			
			} else if (guia[centro].getNombre().compareTo(nombre) < 0) {
				primero = centro + 1;			
			} else
				primero = ultimo = centro;			
		}
		/*if (primero == ultimo && guia[primero].getNombre().equals(nombre))
			return guia[primero];
		else
			return null;*/
		
		return (primero == ultimo && guia[primero].getNombre().equals(nombre)) ? 
				primero : -1;		
	}
	
	public Contacto buscarNumero(long numero) {
		Contacto con = null;
		for (int k = 0; k < numContactos && con == null; k++) {
			if (guia[k].igualNumero(numero)) con = guia[k];
		}
		return con;
	}
	
	// POST: busca un contacto con el nombre dado, y sustituye su n�mero
	// por el n�mero dado como entrada, si existe
	public void reemplazar(String nombre, long numero) {
		//int i;
		//for(i=0; i < numContactos && !guia[i].igualNombre(nombre); i++);
		Contacto contacto = buscarNombre(nombre);
		
		if (contacto != null)
			contacto.setNumero(numero);
	}
	
	// POST: devolver el n�mero de telefonos de Madrid que hay en la gu�a
	// un tel�fono es de Madrid si empieza por "91" o "3491"
	public int contarTelefonosMadrid() {
		int contador = 0;
		for (int i = 0; i < numContactos; i++) {
			if (guia[i].contieneNumeroMadrid()) {
				contador++;
			}
		}
		return contador;
	}
	
	public Contacto[] getTelefonosMadrid() {
		// creamos el vector resultado con el tama�o necesario
		
		Contacto[] resultado = new Contacto[contarTelefonosMadrid()];
		
		int pos = 0;
		
		for (int i =0; pos<resultado.length ; i++) {
			
			if (guia[i].contieneNumeroMadrid()) {
				
				resultado [pos] = guia [i];
				pos ++;
				
			}		
		}
		
		//recorremos la guia y metemos cada contacto de Madrid en resultado		
		return resultado;
	}
	
	

}
