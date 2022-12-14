package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;
import negocio.FuncionalidadAdmin;
import negocio.FuncionalidadOperario;
import negocio.Sistema;

public class Persiste {

	private IPersistencia persistencia = new PersistenciaXML();
	private static Persiste instancia = null;
	

	public static Persiste getInstancia() {
		if(instancia == null)
			instancia = new Persiste();
		return instancia;
	}
	
	public void persistir() {
		try {
			persistencia.abrirOutput("Archivo.xml");
			System.out.println("Crea archivo de escritura");
			
			//System.out.println(Sistema.getInstance().getMozos());
			persistencia.escribir(Sistema.getInstance().getMozos());
			persistencia.escribir(Sistema.getInstance().getProductos());
			persistencia.escribir(Sistema.getInstance().getOperariosRegistrados());
			persistencia.escribir(Sistema.getInstance().getMesas());
			persistencia.escribir(Sistema.getInstance().getPromocionProds());
			persistencia.escribir(Sistema.getInstance().getPromocionesTemp());
			persistencia.escribir(Sistema.getInstance().getComandas());
			persistencia.escribir(Sistema.getInstance().getContrasena());
			persistencia.escribir(Sistema.getInstance().getFuncionalidadOperario());
			persistencia.escribir(Sistema.getInstance().getFuncionalidadAdmin());
			persistencia.escribir(Sistema.getInstance().getOperarioActual());
			
			System.out.println("Escribe");
			persistencia.cerrarOutput();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}	
	
	public void leer() throws IOException {
		
		persistencia.abrirInput("Archivo.xml");
		try {
			System.out.println("Entre");
			Sistema.getInstance().setMozos((HashMap<String, Mozo>) persistencia.leer());
			Sistema.getInstance().setProductos((HashMap<Integer, Producto>) persistencia.leer());
			System.out.println(Sistema.getInstance().getProductos());
			Sistema.getInstance().setOperariosRegistrados((HashMap<String, Operario>) persistencia.leer());
			Sistema.getInstance().setMesas((HashMap<Integer, Mesa>) persistencia.leer());
			Sistema.getInstance().setPromocionProds((HashMap<Integer, PromocionProd>) persistencia.leer());
			Sistema.getInstance().setPromocionesTemp((ArrayList<PromocionTemporal>) persistencia.leer());
			Sistema.getInstance().setComandas((ArrayList<Comanda>) persistencia.leer());
			Sistema.getInstance().setContrasena((HashMap<String, String>) persistencia.leer());
			Sistema.getInstance().setFuncionalidadOperario((FuncionalidadOperario) persistencia.leer());
			Sistema.getInstance().setFuncionalidadAdmin((FuncionalidadAdmin) persistencia.leer());
			Sistema.getInstance().setOperarioActual((Operario) persistencia.leer());
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		persistencia.cerrarInput();
		
		
		
	}
}
