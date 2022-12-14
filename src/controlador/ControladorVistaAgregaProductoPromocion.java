package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import excepciones.NoExisteID_Exception;
import excepciones.PromoInvalida_Exception;
import modelo.Producto;
import negocio.Sistema;
import vista.IVistaAgregaProductoPromocion;
import vista.Ventana;

public class ControladorVistaAgregaProductoPromocion implements ActionListener{
	
	private IVistaAgregaProductoPromocion vista = null;
	private Ventana ventana = null;
	private JPanel contentPane = null;
	
	public ControladorVistaAgregaProductoPromocion(IVistaAgregaProductoPromocion vista, Ventana ventana) {
		this.vista = vista;
		this.vista.addActionListener(this);
		this.ventana = ventana;
		this.contentPane = this.ventana.getContentPane();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		CardLayout cl = (CardLayout) contentPane.getLayout();
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("CONFIRMAR")) {
			try {
			Sistema.getInstance().getFuncionalidadOperario().agregaPromocionProd(this.vista.getIdProd(), this.vista.getDiasDePromo(), this.vista.isAplica2x1(),this.vista.isAplicaDtoPorCant(),this.vista.getDtoPorCant_CantMinima(), this.vista.getDtoPorCant_PrecioUnitario(),  this.vista.getActiva());
			} catch (PromoInvalida_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			} catch (NoExisteID_Exception e1) {
				this.vista.ventanaEmergente(e1.getMessage());
			}
			cl.show(contentPane, ventana.getVistaGestionPromociones());
		}
		else if (comando.equalsIgnoreCase("VOLVER")) 
			cl.show(contentPane, ventana.getVistaGestionPromociones());
	}

}
