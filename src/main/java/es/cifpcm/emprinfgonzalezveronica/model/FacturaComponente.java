package es.cifpcm.emprinfgonzalezveronica.model;

public class FacturaComponente {
	private Integer Id;
	private Integer NFactura;
	private String CodComponente;
	private String Referencia;
	private Integer Cantidad;
	private float PrecioAplicado;

	public FacturaComponente(Integer Id, Integer NFactura, String CodComponente, String Referencia, Integer Cantidad,
			float PrecioAplicado) {
		super();
		this.Id = Id;
		this.NFactura = NFactura;
		this.CodComponente = CodComponente;
		this.Referencia = Referencia;
		this.Cantidad = Cantidad;
		this.PrecioAplicado = PrecioAplicado;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getNFactura() {
		return NFactura;
	}

	public void setNFactura(Integer nFactura) {
		NFactura = nFactura;
	}

	public String getCodComponente() {
		return CodComponente;
	}

	public void setCodComponente(String codComponente) {
		CodComponente = codComponente;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public float getPrecioAplicado() {
		return PrecioAplicado;
	}

	public void setPrecioAplicado(float precioAplicado) {
		PrecioAplicado = precioAplicado;
	}
}
