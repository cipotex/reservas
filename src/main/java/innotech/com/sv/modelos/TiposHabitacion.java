package innotech.com.sv.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tiposhabitaciones")
public class TiposHabitacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha_ins;
	
	@PrePersist
	public void preinsert() {
		this.fecha_ins = new Date();
	}
	
	@ManyToOne
    @NotNull
	private Empresa empresa;
	
	@ManyToOne
	private Promocion promocion;
	
	//@NotNull(message = "Debe indicar una descripción de la habitación")
	@NotBlank(message = "Debe indicar una descripción de la habitación")
	private String descripcion;
	
	
	@NotNull(message = "Debe indicar el precio de renta por dia")
	private double preciodia;
	
	@NotNull(message = "Debe indicar el precio de renta por semana")
	//@NotBlank(message = "Debe indicar el precio de renta por semana")
	private double preciosemana;
	
	@NotNull(message = "Debe indicar el precio de renta por mes")
	private double preciomes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha_ins() {
		return fecha_ins;
	}

	public void setFecha_ins(Date fecha_ins) {
		this.fecha_ins = fecha_ins;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPreciodia() {
		return preciodia;
	}

	public void setPreciodia(double preciodia) {
		this.preciodia = preciodia;
	}

	public double getPreciosemana() {
		return preciosemana;
	}

	public void setPreciosemana(double preciosemana) {
		this.preciosemana = preciosemana;
	}
 
	public double getPreciomes() {
		return preciomes;
	}

	public void setPreciomes(double preciomes) {
		this.preciomes = preciomes;
	}
	
	
	
}
