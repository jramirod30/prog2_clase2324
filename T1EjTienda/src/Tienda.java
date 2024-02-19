
public class Tienda {
	private Almacen almacen1, almacen2;
	private double saldoCaja;
	// en pos i esta el precio del producto con codigo i
	private double[] precios;
	
	//PRE: almacen1.size() = almacen2.size() y
	// saldoInicial >= 0
	public Tienda(double saldoInicial, Almacen almacen1,
			Almacen almacen2) {
		saldoCaja = saldoInicial;
		this.almacen1 = almacen1;
		this.almacen2 = almacen2;
		precios = new double [almacen1.size()];
	}
	
	//PRE: 0 <= codProducto < precios.length y precio > 0
	public void setPrecio(int codProducto, double precio) {
		precios[codProducto] = precio;
	}
	
	//PRE: 0 <= codProducto < precios.length y 
	// hay existencias del producto codProducto
	// preferimos utilizar el almacen mas cercano
	public void comprar(int codProducto) {
		saldoCaja += precios [codProducto];
		if (almacen1.get(codProducto) == 0) 
			almacen2.gastarProductos(codProducto,1);
		else almacen1.gastarProductos(codProducto, 1);
	}
	
	//PRE: 0 <= codProducto < precios.length
	public void devolver(int codProducto) {
		saldoCaja -= precios[codProducto];
		almacen1.recibirProductos(codProducto, 1);
	}
	
	//PRE: 0 <= codProducto < precios.length
	public boolean quedaProducto(int codProducto){
		return almacen1.get(codProducto) != 0 ||
				almacen2.get(codProducto) != 0;
	}
	
	public int numProdAgotados() {
		int res=0;
		for(int i=0; i<almacen1.size ();i++)
		{
			if(!quedaProducto (i))
			{
				res++;
			}
		}
		return res;
	}
	
	public String toString() {
		String str= "[" + precios[0];
		for(int i=1; i<precios.length; i++) {
			str +=","+ precios[i];
		}
		str += "]";
		return almacen1.toString() + almacen2.toString() + " " + 
				saldoCaja + " " + str;		
	}
}
