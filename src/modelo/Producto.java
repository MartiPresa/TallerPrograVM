package modelo;

public class Producto implements Cloneable
{
    private static int siguienteIdProd = 0;
    private int idProd;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stockInicial;
    
	public Producto(String nombre, double precioCosto, double precioVenta, int stockInicial) {
		super();
		this.idProd = siguienteIdProd++;
		this.nombre = nombre;
		this.precioCosto = precioCosto;
		this.precioVenta = precioVenta;
		this.stockInicial = stockInicial;
	}
	public Producto() {
		
	}

	public int getIdProd() {
		return idProd;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecioCosto() {
		return precioCosto;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public int getStockInicial() {
		return stockInicial;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public void setStockInicial(int stockInicial) {
		this.stockInicial = stockInicial;
	}

	
	public static int getSiguienteIdProd() {
		return siguienteIdProd;
	}

	public static void setSiguienteIdProd(int siguienteIdProd) {
		Producto.siguienteIdProd = siguienteIdProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	@Override
	public String toString() {
		return "Producto [idProd=" + idProd + ", nombre=" + nombre + ", precioCosto=" + precioCosto + ", precioVenta="
				+ precioVenta + ", stockInicial=" + stockInicial + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	

	
    
    
    /**
     * el producto no puede ser nulo
	 * aplicaDosPorUno y aplicaDtoPorCantidad no pueden ser false ambos al mismo tiempo (ya que no habría promo)

     */
}
