package com.ecodeup.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.negocio.Cliente;

public class ClienteDAO {
	private static final String senderEmail = "****"; //correo origen
	private static final String senderPassword = "****"; 
	
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//ENVIO DE CORREO
	public static void sendAsHtml(String to, String title, String html) throws MessagingException {
		//System.out.println("Se envio correo al gmail " + to);
		
		Session session = createSession();
		
	}
	private static Session createSession() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smpt.host", "smtp.gmail.com");
		props.put("mail.smpt.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		});
		return session;	
	}
	
	//GUARDAR
	public boolean guardar(Cliente cliente) throws SQLException, MessagingException {
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="insert into clientes (idCliente,nombreCliente,apellidoCliente,dni,telefono,correo,usuario,contrasenia,created_at,updated_at) values (?,?,?,?,?,?,?,?,?,?)";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setString(2, cliente.getNombreCliente());
			statement.setString(3, cliente.getApellidoCliente());
			statement.setString(4, cliente.getDni());
			statement.setString(5, cliente.getTelefono());
			statement.setString(6, cliente.getCorreo());
			statement.setString(7, cliente.getUsuario());
			statement.setString(8, cliente.getContrasenia());
			statement.setDate(9, cliente.getCreated_at());
			statement.setDate(10, cliente.getUpdated_at());
			
			estadoOperacion = statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
			
			//this.sendAsHtml("joues983@gmail.com", "Prueba de Correo", "<h2>Ejemplo de envio de correo electronico</h2><p>Hola, correoenviado desde Java");
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		
		return estadoOperacion;
	}
	
	//EDITAR
	public boolean editar(Cliente cliente) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update clientes set nombreCliente=?,apellidoCliente=?,dni=?,telefono=?,correo=?,updated_at=? where idCliente=?";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, cliente.getNombreCliente());
			statement.setString(2, cliente.getApellidoCliente());
			statement.setString(3, cliente.getDni());
			statement.setString(4, cliente.getTelefono());
			statement.setString(5, cliente.getCorreo());
			statement.setDate(6, cliente.getUpdated_at());
			statement.setInt(7, cliente.getIdCliente());
			
			estadoOperacion = statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//ELIMINAR
	public boolean eliminar(int idCliente, Date deleted_at) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update clientes set deleted_at=? where idCliente=?";
			statement=connection.prepareStatement(sql);
			
			statement.setDate(1, deleted_at);
			statement.setInt(2, idCliente);
			
			estadoOperacion = statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//CAMBIAR CONTRASENIA
	public boolean cambiarContrasenia(String correo, Date updated_at, String contrasenia) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql="update clientes set contrasenia=?, updated_at=? where correo=?";
			statement=connection.prepareStatement(sql);
			
			statement.setString(1, contrasenia);
			statement.setDate(2, updated_at);
			statement.setString(3, correo);
			
			estadoOperacion = statement.executeUpdate()>0;
			
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	//OBTENER LISTA DE CLIENTES
	public List<Cliente> obtenerClientes() throws SQLException {
		ResultSet resultSet=null;
		List<Cliente> listaClientes = new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from clientes where deleted_at is null";
			resultSet=statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Cliente c =new Cliente();
				c.setIdCliente(resultSet.getInt(1));
				c.setNombreCliente(resultSet.getString(2));
				c.setApellidoCliente(resultSet.getString(3));
				c.setDni(resultSet.getString(4));
				c.setTelefono(resultSet.getString(5));
				c.setCorreo(resultSet.getString(6));
				c.setUsuario(resultSet.getString(7));
				c.setContrasenia(resultSet.getString(8));
				c.setCreated_at(resultSet.getDate(9));
				c.setUpdated_at(resultSet.getDate(10));
				
				listaClientes.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	
	//OBTENER CLIENTE
	public Cliente obtenerCliente(int idCliente) throws SQLException {
		ResultSet resultSet=null;
		Cliente c =new Cliente();
		
		String sql = null;
		estadoOperacion = false;
		connection=obtenerConexion();
		
		try {
			
			sql="select * from clientes where deleted_at is null and idCliente=?";
			statement=connection.prepareStatement(sql);
			statement.setInt(1, idCliente);
			
			resultSet=statement.executeQuery();
			
			if(resultSet.next()) {
				c.setIdCliente(resultSet.getInt(1));
				c.setNombreCliente(resultSet.getString(2));
				c.setApellidoCliente(resultSet.getString(3));
				c.setDni(resultSet.getString(4));
				c.setTelefono(resultSet.getString(5));
				c.setCorreo(resultSet.getString(6));
				c.setUsuario(resultSet.getString(7));
				c.setContrasenia(resultSet.getString(8));
				c.setCreated_at(resultSet.getDate(9));
				c.setUpdated_at(resultSet.getDate(10));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	//INGRESAR CLIENTE
		public Cliente ingresarCliente(String usuario, String contrasenia) throws SQLException {
			ResultSet resultSet=null;
			Cliente c =new Cliente();
			
			String sql = null;
			estadoOperacion = false;
			connection=obtenerConexion();
			
			try {
				
				sql="select * from clientes where deleted_at is null and usuario=? and contrasenia=?";
				statement=connection.prepareStatement(sql);
				statement.setString(1, usuario);
				statement.setString(2, contrasenia);
				
				resultSet=statement.executeQuery();
				
				if(resultSet.next()) {
					c.setIdCliente(resultSet.getInt(1));
					c.setNombreCliente(resultSet.getString(2));
					c.setApellidoCliente(resultSet.getString(3));
					c.setDni(resultSet.getString(4));
					c.setTelefono(resultSet.getString(5));
					c.setCorreo(resultSet.getString(6));
					c.setUsuario(resultSet.getString(7));
					c.setContrasenia(resultSet.getString(8));
					c.setCreated_at(resultSet.getDate(9));
					c.setUpdated_at(resultSet.getDate(10));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return c;
		}
	
	//OBTENER CONEXION POOL
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
	
}
