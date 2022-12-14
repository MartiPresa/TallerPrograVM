package prueba;

import java.io.IOException;

import controlador.ControladorVistaAdmin;
import controlador.ControladorVistaAgregaProducto;
import controlador.ControladorVistaAgregaProductoPromocion;
import controlador.ControladorVistaAgregaPromocionTemporal;
import controlador.ControladorVistaAltaMozo;
import controlador.ControladorVistaGestionMesaAdmin;
import controlador.ControladorVistaGestionMesaOp;
import controlador.ControladorVistaGestionMozoAdmin;
import controlador.ControladorVistaGestionMozoOp;
import controlador.ControladorVistaGestionProductoAdmin;
import controlador.ControladorVistaGestionProductoOp;
import controlador.ControladorVistaGestionPromociones;
import controlador.ControladorVistaInicial;
import controlador.ControladorVistaModificaDatosOperario;
import controlador.ControladorVistaModificaMesaAdmin;
import controlador.ControladorVistaModificaMesaOp;
import controlador.ControladorVistaModificaMozoAdmin;
import controlador.ControladorVistaModificaMozoOp;
import controlador.ControladorVistaModificaProducto;
import controlador.ControladorVistaModificaProductoPromocion;
import controlador.ControladorVistaModificaPromocionTemporal;
import controlador.ControladorVistaMostrarEstadisticas;
import controlador.ControladorVistaOperario;
import controlador.ControladorVistaRegistrarOperario;
import excepciones.CantComensalesInvalida_Exception;
import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.PromoRepetida_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import modelo.Administrador;
import modelo.Enumerados;
import modelo.Mozo;
import negocio.FuncionalidadAdmin;
import negocio.FuncionalidadOperario;
import negocio.Sistema;
import persistencia.Persiste;
import vista.Ventana;
import vista.VistaAdmin;
import vista.VistaAgregaProducto;
import vista.VistaAgregaProductoPromocion;
import vista.VistaAgregarPromocionTemporal;
import vista.VistaAltaMozo;
import vista.VistaCambiaContrasena;
import vista.VistaGestionMesaAdmin;
import vista.VistaGestionMesaOp;
import vista.VistaGestionMozoAdmin;
import vista.VistaGestionMozoOp;
import vista.VistaGestionProductoAdmin;
import vista.VistaGestionProductoOp;
import vista.VistaGestionPromociones;
import vista.VistaInicial;
import vista.VistaModificaDatosPersonales;
import vista.VistaModificaMozoAdmin;
import vista.VistaModificaMozoOp;
import vista.VistaModificaProducto;
import vista.VistaModificaProductoPromocion;
import vista.VistaModificaPromocionTemporal;
import vista.VistaModificarMesaAdmin;
import vista.VistaModificarMesaOp;
import vista.VistaMostrarEstadisticas;
import vista.VistaOperario;
import vista.VistaRegistrarOperario;

public class Prueba {

	public static void main(String[] args) {
		
		try {
			Persiste.getInstancia().leer();
		} catch (IOException e2) {

			e2.printStackTrace();
			Mozo mozo = new Mozo("Marti", 3);
			Mozo mozo2 = new Mozo("Valen", 0);
			Mozo mozo3 = new Mozo("Pau", 2);
			Sistema.getInstance().getMozos().put("Marti", mozo);
			Sistema.getInstance().getMozos().put("Valen", mozo2);
			Sistema.getInstance().getMozos().put("Pau", mozo3);
			Sistema.getInstance().seteaAdmin();
			Sistema.getInstance().setFuncionalidadAdmin(new FuncionalidadAdmin(Administrador.getInstance()));
			try {
				Sistema.getInstance().getFuncionalidadAdmin().agregaProducto("Pizza", 10, 20, 10);
				Sistema.getInstance().getFuncionalidadAdmin().agregaProducto("Agua", 10, 20, 10);
			} catch (precioInvalido_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Sistema.getInstance().getFuncionalidadAdmin().registraOperario("Juan", "juan", "Carlos1234", Enumerados.estadoOperario.ACTIVO);
			} catch (UserNameRepetido_Exception | ContrasenaIncorrecta_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				Sistema.getInstance().getFuncionalidadOperario().agregaPromocionProd(0, Enumerados.diasDePromo.MARTES,
						false, true, 3, 12, true);
			} catch (PromoInvalida_Exception | NoExisteID_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			try {
				Sistema.getInstance().getFuncionalidadOperario().agregaPromocionTemporal(true,
						Enumerados.diasDePromo.MARTES, "Promo1", Enumerados.formaDePago.CTADNI, 20, false, 0, 2);
			} catch (PromoRepetida_Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Persiste.getInstancia().persistir();
		}
		finally {
			VistaGestionMozoOp vistaMozoOp = new VistaGestionMozoOp();
			VistaGestionMozoAdmin vistaMozoAdmin = new VistaGestionMozoAdmin();
			VistaInicial vistaInicial = new VistaInicial();
			VistaGestionMesaOp vistaMesaOp = new VistaGestionMesaOp();
			VistaGestionMesaAdmin vistaMesaAdmin = new VistaGestionMesaAdmin();
			VistaCambiaContrasena vistaCambiaContra = new VistaCambiaContrasena();
			VistaOperario vistaOp = new VistaOperario();
			VistaAdmin vistaAdmin = new VistaAdmin();
			VistaGestionProductoOp vistaProductoOp = new VistaGestionProductoOp();
			VistaGestionProductoAdmin vistaProductoAdmin = new VistaGestionProductoAdmin();
			VistaGestionPromociones vistaGestionPromociones = new VistaGestionPromociones();
			VistaModificarMesaAdmin vistaModificarMesa = new VistaModificarMesaAdmin();
			VistaModificarMesaOp vistaModificaMesaOp = new VistaModificarMesaOp();
			VistaModificaMozoAdmin vistaModificaMozoAdmin = new VistaModificaMozoAdmin();
			VistaModificaMozoOp vistaModificaMozoOp = new VistaModificaMozoOp();
			VistaAltaMozo vistaAltaMozo = new VistaAltaMozo();
			VistaAgregaProducto vistaAgregaProducto = new VistaAgregaProducto();
			VistaAgregaProductoPromocion vistaAgregaProductoPromocion = new VistaAgregaProductoPromocion();
			VistaModificaDatosPersonales vistaModificaDatosPersonales = new VistaModificaDatosPersonales();
			VistaModificaProducto vistaModificaProducto = new VistaModificaProducto();
			VistaModificaProductoPromocion vistaModificaProductoPromocion = new VistaModificaProductoPromocion();
			VistaModificaPromocionTemporal vistaModificaPromocionTemporal = new VistaModificaPromocionTemporal();
			VistaRegistrarOperario vistaRegistraOp = new VistaRegistrarOperario();
			VistaAgregarPromocionTemporal vistaAgregaPromoTemp = new VistaAgregarPromocionTemporal();
			VistaModificaPromocionTemporal vistaModificaPromoTemp = new VistaModificaPromocionTemporal();
			VistaMostrarEstadisticas vistaMostrarEstadisticas = new VistaMostrarEstadisticas();

			try {
				Sistema.getInstance().getFuncionalidadAdmin().agregaMesa(4);
				Sistema.getInstance().getFuncionalidadAdmin().agregaMesa(5);
				// System.out.println(Sistema.getInstance().getMesas().get(0).getCantPax());
			} catch (CantComensalesInvalida_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Ventana v = new Ventana(vistaInicial, vistaMozoOp, vistaMozoAdmin, vistaMesaOp, vistaMesaAdmin,
					vistaGestionPromociones, vistaCambiaContra, vistaOp, vistaAdmin, vistaProductoOp, vistaProductoAdmin,
					vistaModificarMesa, vistaModificaMesaOp, vistaModificaMozoAdmin, vistaAltaMozo, vistaAgregaProducto,
					vistaAgregaProductoPromocion, vistaModificaDatosPersonales, vistaModificaProducto,
					vistaModificaProductoPromocion, vistaModificaPromocionTemporal, vistaRegistraOp, vistaModificaMozoOp,
					vistaAgregaPromoTemp, vistaMostrarEstadisticas);

			ControladorVistaOperario cOperario = new ControladorVistaOperario(vistaOp, v);
			ControladorVistaAdmin cAdmin = new ControladorVistaAdmin(vistaAdmin, v);
			ControladorVistaInicial cInicial = new ControladorVistaInicial(vistaInicial, v);
			ControladorVistaGestionMozoOp cMozoOp = new ControladorVistaGestionMozoOp(vistaMozoOp, v);
			ControladorVistaGestionMozoAdmin cMozoAdmin = new ControladorVistaGestionMozoAdmin(vistaMozoAdmin, v);
			ControladorVistaGestionMesaOp cMesaOp = new ControladorVistaGestionMesaOp(vistaMesaOp, v);
			ControladorVistaGestionMesaAdmin cMesaAdmin = new ControladorVistaGestionMesaAdmin(vistaMesaAdmin, v);
			ControladorVistaGestionProductoAdmin cProductoAdmin = new ControladorVistaGestionProductoAdmin(
					vistaProductoAdmin, v);
			ControladorVistaGestionProductoOp cProductoOp = new ControladorVistaGestionProductoOp(vistaProductoOp, v);
			ControladorVistaModificaMesaAdmin cModificaMesa = new ControladorVistaModificaMesaAdmin(vistaModificarMesa, v);
			ControladorVistaModificaMesaOp cModificaMesaOp = new ControladorVistaModificaMesaOp(vistaModificaMesaOp, v);
			ControladorVistaModificaMozoAdmin cModificaMozoAdmin = new ControladorVistaModificaMozoAdmin(
					vistaModificaMozoAdmin, v);
			ControladorVistaModificaMozoOp cModificaMozoOp = new ControladorVistaModificaMozoOp(vistaModificaMozoOp, v);
			ControladorVistaModificaDatosOperario cModificaDatosOp = new ControladorVistaModificaDatosOperario(
					vistaModificaDatosPersonales, v);
			ControladorVistaRegistrarOperario cRegistraOp = new ControladorVistaRegistrarOperario(vistaRegistraOp, v);
			ControladorVistaAltaMozo cAltaMozo = new ControladorVistaAltaMozo(vistaAltaMozo, v);
			ControladorVistaModificaProducto cModificaProducto = new ControladorVistaModificaProducto(vistaModificaProducto,
					v);
			ControladorVistaGestionPromociones cGestionPromociones = new ControladorVistaGestionPromociones(
					vistaGestionPromociones, v);
			ControladorVistaAgregaProducto cAgregaProd = new ControladorVistaAgregaProducto(vistaAgregaProducto, v);
			ControladorVistaAgregaProductoPromocion cAgregaProdPromo = new ControladorVistaAgregaProductoPromocion(
					vistaAgregaProductoPromocion, v);
			ControladorVistaModificaProductoPromocion cModificaProdPromo = new ControladorVistaModificaProductoPromocion(
					vistaModificaProductoPromocion, v);
			ControladorVistaAgregaPromocionTemporal cModificaTemp = new ControladorVistaAgregaPromocionTemporal(
					vistaAgregaPromoTemp, v);
			ControladorVistaModificaPromocionTemporal cModificaPromoTemp = new ControladorVistaModificaPromocionTemporal(
					vistaModificaPromocionTemporal, v);
			ControladorVistaMostrarEstadisticas cMuestraEstad = new ControladorVistaMostrarEstadisticas(vistaMostrarEstadisticas, v);
		}
	}

}
