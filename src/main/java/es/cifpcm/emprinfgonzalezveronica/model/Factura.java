package es.cifpcm.emprinfgonzalezveronica.model;

import java.sql.*;
import java.util.List;

public class Factura {
	Integer idFactura;
	Timestamp fecha;
	String cliente;
	String nombreTienda;
	Integer idTienda;
	List<FacturaComponente> componentes;

	/**
	 * @return the idFactura
	 */
	public Integer getIdFactura() {
		return idFactura;
	}

	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the nombreTienda
	 */
	public String getNombreTienda() {
		return nombreTienda;
	}

	/**
	 * @param nombreTienda the nombreTienda to set
	 */
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}

	/**
	 * @return the idTienda
	 */
	public Integer getIdTienda() {
		return idTienda;
	}

	/**
	 * @param idTienda the idTienda to set
	 */
	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	/**
	 * @return the componentes
	 */
	public List<FacturaComponente> getComponentes() {
		return componentes;
	}

	/**
	 * @param componentes the componentes to set
	 */
	public void setComponentes(List<FacturaComponente> componentes) {
		this.componentes = componentes;
	}

	/**
	 * @param date
	 * @param cliente
	 * @param idTienda
	 */
	public Factura(Timestamp fecha, String cliente, Integer idTienda) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.idTienda = idTienda;
	}

	/**
	 * @param fecha
	 * @param cliente
	 * @param nombreTienda
	 * @param idTienda
	 * @param componentes
	 */
	public Factura(Timestamp fecha, String cliente, String nombreTienda, Integer idTienda,
			List<FacturaComponente> componentes) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.nombreTienda = nombreTienda;
		this.idTienda = idTienda;
		this.componentes = componentes;
	}

}