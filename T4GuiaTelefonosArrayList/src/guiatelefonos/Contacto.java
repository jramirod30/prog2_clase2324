package guiatelefonos;
import java.util.Objects;

// Contacto simple (nombre, telefono)

public class Contacto {
    private String nombre;
    private long numero;

    // Constructor
    public Contacto(String nombre, long numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public long getNumero() {
        return numero;
    }

    // Comparacion
    public boolean esIgual(Contacto otro) {
        return this.nombre.equals(otro.nombre) &&
               this.numero == otro.numero;
    }
    public boolean igualNombre(String nombre) {
        return this.nombre.equals(nombre);
    }
    public boolean igualNumero(long numero) {
        return this.numero == numero;
    }

    // Presentar con formato
    public String toString() {
        return nombre + ": " + numero;
    }
    
    public void setNumero(long numero) {
    	this.numero = numero;
    }
    
    public boolean contieneNumeroMadrid() {
    	String num = Long.toString(numero);
		return (num.startsWith("3491") || num.startsWith("91"));
    }
    
//    @Override
//    public boolean equals(Object obj) {
//    	if(obj == this) return true;
//    	if((obj instanceof Contacto)) 
//    		return this.esIgual((Contacto) obj);
//    	return false;
//    }
    
    @Override
    public boolean equals(Object obj) {
    	return (obj == this) || 
    			((obj instanceof Contacto) && 
    			this.esIgual((Contacto) obj));
    }
        
    
}
