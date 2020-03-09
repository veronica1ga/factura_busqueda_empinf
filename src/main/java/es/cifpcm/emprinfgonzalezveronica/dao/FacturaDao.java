package es.cifpcm.emprinfgonzalezveronica.dao;

import es.cifpcm.emprinfgonzalezveronica.model.*;

public interface FacturaDao {
	Factura getFactura(Integer numeroabuscar);
	FacturaComponente getFactura1(Integer numeroabuscar);
}
