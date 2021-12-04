package com.ecodeup.negocio;

import java.sql.Date;

public class Reclamo {
	private int idReclamo, idCliente;
	private String tipo, subtipo;
	private Date fechaRegistro, created_at, updated_at, deleted_at;
	
	private int idDetalle;
	private String marcaProducto, modelo, serie, empleado, local, descripcion, estado, atencion_detalle, fechaincidente;
	
	
	public Reclamo() {
	}
	
	public Reclamo(int idReclamo, int idCliente, String tipo, String subtipo, Date fechaRegistro, Date created_at,
			Date updated_at, Date deleted_at, int idDetalle, String marcaProducto, String modelo, String serie,
			String empleado, String local, String descripcion, String estado, String fechaincidente) {
		super();
		this.idReclamo = idReclamo;
		this.idCliente = idCliente;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.fechaRegistro = fechaRegistro;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.idDetalle = idDetalle;
		this.marcaProducto = marcaProducto;
		this.modelo = modelo;
		this.serie = serie;
		this.empleado = empleado;
		this.local = local;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaincidente = fechaincidente;
	}
	public Reclamo(int idReclamo, int idCliente, String tipo, String subtipo, Date fechaRegistro, Date created_at,
			Date updated_at, Date deleted_at, int idDetalle, String marcaProducto, String modelo, String serie,
			String empleado, String local, String descripcion, String estado, String atencion_detalle,
			String fechaincidente) {
		super();
		this.idReclamo = idReclamo;
		this.idCliente = idCliente;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.fechaRegistro = fechaRegistro;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
		this.idDetalle = idDetalle;
		this.marcaProducto = marcaProducto;
		this.modelo = modelo;
		this.serie = serie;
		this.empleado = empleado;
		this.local = local;
		this.descripcion = descripcion;
		this.estado = estado;
		this.atencion_detalle = atencion_detalle;
		this.fechaincidente = fechaincidente;
	}
	public int getIdReclamo() {
		return idReclamo;
	}
	public void setIdReclamo(int idReclamo) {
		this.idReclamo = idReclamo;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSubtipo() {
		return subtipo;
	}
	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}
	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	public String getMarcaProducto() {
		return marcaProducto;
	}
	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAtencion_detalle() {
		return atencion_detalle;
	}
	public void setAtencion_detalle(String atencion_detalle) {
		this.atencion_detalle = atencion_detalle;
	}
	public String getFechaincidente() {
		return fechaincidente;
	}
	public void setFechaincidente(String fechaincidente) {
		this.fechaincidente = fechaincidente;
	}
	
	
}
