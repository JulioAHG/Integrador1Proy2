package com.ecodeup.negocio;

import java.sql.Date;

public class Cliente {
	private int idCliente;
	private String nombreCliente, apellidoCliente, dni, telefono, correo, usuario, contrasenia;
	private Date created_at, updated_at, deleted_at;
	
	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String dni, String telefono,
			String correo, String usuario, String contrasenia, Date created_at, Date updated_at) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String dni, String telefono,
			String correo, String usuario, String contrasenia, Date created_at, Date updated_at, Date deleted_at) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
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

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", dni=" + dni + ", telefono=" + telefono + ", correo=" + correo + ", usuario="
				+ usuario + ", contrasenia=" + contrasenia + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", deleted_at=" + deleted_at + "]";
	}	
	
}
