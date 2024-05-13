package list;

import node.Node;
import java.util.function.*;

/**
 * Implementación de un TAD Lista
 * basada en una cadena simplemente enlazada
 * 
 * @author jramirez
 *
 */
public class LinkedList<E> implements IList<E> {

	private Node<E> head;
	private int nElems;

	/**
	 * Construye una lista vacía
	 * 
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> crea una lista vacía.
	 * 
	 */
	public LinkedList(){
		head = null;
		nElems = 0;
	}

	/**
	 * Constructor de copia
	 * 
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> crea una lista igual a org (shallow copy).
	 * 
	 */
	public LinkedList(LinkedList<E> org){

		if(org.size() ==0) {
			head = null;
			return;
		}
		head = new Node<>(org.head.getElem());
		Node <E> ultimo = this.head;
		Node<E> actualOrg = org.head.next();
		for(int i=1;i<org.size();i++) {
			ultimo.setNext(new Node<>(actualOrg.getElem()));
			ultimo = ultimo.next();
			actualOrg = actualOrg.next();
		}
		this.nElems = org.size();
	}

	// devuelve una ref al nodo que se encuentra en la posición pos de la cadena
	// PRE: 0 <= pos <= size()-1
	private Node<E> getNodeIn(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size())
			throw new IndexOutOfBoundsException("Índice fuera de rango");
		
		Node <E> actual = head;
		
		for (int i = 0; i < pos; i++)
			actual = actual.next();

		return actual;
	}

	/**
	 * Coloca un nuevo elemento en la posición insertIndex
	 *
	 * <br><B>PRE:</B> insertIndex EN {0..size()}
	 * <br><B>POST:</B> devuelve la lista this con element en la pos insertIndex
	 * y los elementos que antes estaban en pos &gt;=insertIndex, ahora en pos+1.
	 * 
	 * @throws IndexOutOfBoundsException 
	 */
	@Override
	public void add(int insertIndex, E element) throws IndexOutOfBoundsException {
		if (insertIndex < 0 || insertIndex > this.size()) {
			throw new IndexOutOfBoundsException ("Índice fuera de rango.");
		}
		if (insertIndex == 0) {
			head = new Node<E>(element, head);
		} else {
			Node<E> prev = getNodeIn(insertIndex - 1);
			Node<E> added = new Node<E>(element,prev.next());
			prev.setNext(added);
		}
		nElems++;
	}

	/**
	 * Lectura indexada de una posición de la lista
	 * 
	 * <br><B>PRE:</B> insertIndex EN {0..size()-1}
	 * <br><B>POST:</B> devuelve una ref al elemento que está en la pos index.
	 * 
	 * @throws IndexOutOfBoundsException 
	 */
	@Override
	public E get(int getIndex) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return getNodeIn(getIndex).element();
	}

	/**
	 * No. de elementos en la lista
	 * 
	 * <br><B>PRE:</B> cierto
	 * <br><B>POST:</B> devuelve el no. de elems que hay en la lista.
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return nElems;
	}

	/**
	 * Escritura indexada en una posición de la lista
	 * 
	 * <br><B>PRE:</B> insertIndex EN {0..size()-1}
	 * <br><B>POST:</B> coloca element en la posición insertIndex de la lista destruyendo 
	 * el elemento que había en esa posición.
	 * 
	 * @throws IndexOutOfBoundsException 
	 */
	@Override
	public void set(int insertIndex, E element) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		Node<E> ref = this.getNodeIn(insertIndex);
		ref.setElem(element);
	}

	/**
	 * Posición de un elemento dentro de la lista
	 * 
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> devuelve una ref al primer elemento de la lista
	 * que es igual a search (equals), o -1 si no existe ningún elemento igual a search.
	 * 
	 */
	@Override
	public int indexOf(E search) {
		int pos;
		Node<E> actual = head;
		for(pos = 0 ; pos <nElems && !actual.element().equals(search) ;
				pos++, actual = actual.next());
		return pos < nElems ? pos : -1;
	}

	/**
	 * Extracción de un elemento de la lista dada su posición
	 * 
	 * <br><B>PRE:</B> removalIndex EN {0..size()-1}
	 * <br><B>POST:</B> extrae el elemento que está en la pos removalIndex.
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void removeElementAt(int removalIndex) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(removalIndex < 0 || size()-1 > removalIndex) {
			throw new IndexOutOfBoundsException ();
		}
		if(removalIndex == 0) {
			head = head.next();
		}
		else {
			Node<E> pre = getNodeIn(removalIndex-1);
			pre.setNext(pre.next().next());
		}
		nElems--;
	}

	/**
	 * Extracción de un elemento de la lista dado un elemento igual (equals)
	 * 
	 * <br><B>PRE:</B> cierto
	 * <br><B>POST:</B> extrae el primer elemento que sea igual a element (equals) y devuelve cierto, 
	 * si existe. Y si no existe, devuelve falso.
	 * 
	 */
	@Override
	public boolean remove(E element) {
		boolean res=false;
		if(this.head==null)
			return res;
		if(head.equals(element)) {
			head=head.next();
			res=true;
		}
		else {//else
			Node<E> actual =head;
			while(!res &&actual.next()!=null ) {//w
				res = actual.next().element().equals(element);
				if(!res) {
					actual = actual.next();
				}
			}//w
			if(res)
				actual.setNext(actual.next().next());
		}//else
		if(res) {
			this.nElems--;
		}
		
					
		return res;
	}

	// Class-specific methods

	/**
	 * Devuelve un string con los elementos de la lista
	 * 
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> devuelve un string con los elementos de la lista separados
	 * por comas.
	 */
	public String toString() {
		//TODO
		return "";
	}

	/**
	 * Igualdad de listas
	 * 
	 * <br><B>PRE:</B> Cierto
	 * <br><B>POST:</B> indica si obj es igual a this. Dos listas son iguales
	 * si las secuencias de objetos almacenados en ellas son iguales. Cada par de objetos
	 * son comparados con el método equals de la clase a la que pertenecen estos objetos.
	 * 
	 */
	// @SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (!(obj instanceof LinkedList<?>))
			return false; // also, list == null

		LinkedList<?> list = (LinkedList<?>) obj;
		if(list.size() == 0 && this.size() == 0) {
			return true;
		}
		
		boolean iguales = list.size() == this.size() && 
				list.head.element().getClass() == this.head.element().getClass();
		
		Node<E> actualThis = this.head;
		Node<E> actualList = (iguales) ? (Node<E>) list.head : null;
		while (iguales && actualThis != null) {
			iguales = actualThis.element().equals(actualList.element());
			actualThis = actualThis.next();
			actualList = actualList.next();
		}

		return iguales;
	}

	/**
	 * Se hace una deep copy sí y sólo si si copyData hace una copia compelta del tipo de dato conetenido en la lista 
	 * @param copyData
	 * @return
	 */
	public LinkedList <E> deepCopy (Function<E,E>copyData){
		LinkedList <E> copia = new LinkedList<E>();
		Node<E> headOrg = this.head;
		Node<E> refCopyList = null;
		copia.nElems = this.nElems;
		while (headOrg != null){//W
			Node <E> nodoAux = new Node<E>(copyData.apply(headOrg.element()));
			if (copia.head==null){
				copia.head = nodoAux;
				refCopyList = nodoAux;
			}
			else{
				refCopyList.setNext(nodoAux);
				refCopyList = refCopyList.next();
			}
			headOrg = headOrg.next();
		}//W
		return copia;
	}

	/* public E copy (E dato,Function<E,E>copiar ){
        return copiar.apply(dato);
    }*/
}
