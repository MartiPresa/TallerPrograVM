package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados;
import modelo.Enumerados.estadoMesa;

public interface IVistaModificarMesa {

	int getCantSillas();
	estadoMesa getEstado();
	void addActionListener(ActionListener actionListener);
}
