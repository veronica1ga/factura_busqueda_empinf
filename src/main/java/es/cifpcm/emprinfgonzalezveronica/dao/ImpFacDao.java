package es.cifpcm.emprinfgonzalezveronica.dao;


import org.slf4j.LoggerFactory;

import java.sql.*;

import org.slf4j.Logger;

import es.cifpcm.emprinfgonzalezveronica.model.Factura;
import es.cifpcm.emprinfgonzalezveronica.model.FacturaComponente;
import es.cifpcm.emprinfgonzalezveronica.dao.DaoFactory;

public class ImpFacDao implements FacturaDao {
	private final Logger logger=LoggerFactory.getLogger(Factura.class);
	boolean pedidos=false;
	Connection conexion = null;
	


	public ImpFacDao(DaoFactory daoFactory) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public Factura getFactura(Integer numeroabuscar) {
		// TODO Auto-generated method stub
		Factura facturas = null;
		 
		String sql = "SELECT * FROM factura";
		//conexion = con.getJdbcConnection();
		
		try {
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				//for (Factura facturas : factura) {
				facturas = new Factura(res.getTimestamp("fecha"), res.getString("cliente"),
						res.getInt("idTienda"));
				//}
			}
			statement.setInt(1, numeroabuscar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facturas;
	}



	@Override
	public FacturaComponente getFactura1(Integer numeroabuscar) {
		// TODO Auto-generated method stub
		FacturaComponente facturascom = null;
		 
		String sql = "SELECT * FROM facturacomponente";
		
		try {
			PreparedStatement statement = conexion.prepareStatement(sql);
			ResultSet re = statement.executeQuery();
			if (re.next()) {
				
				facturascom = new FacturaComponente(re.getInt("Id"), re.getInt("NFactura"),
						re.getString("CodComponente"),re.getString("Referencia"),re.getInt("Cantidad"),re.getFloat("PrecioAplicado"));
			}
			statement.setInt(1, numeroabuscar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facturascom;
	}

}
