package com.ecodeup.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import com.ecodeup.conexion.Conexion;
import com.ecodeup.negocio.Cliente;
import com.ecodeup.negocio.Reclamo;

public class ReclamoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//GUARDAR
		public boolean guardar(Reclamo reclamo) throws SQLException, MessagingException {
			String sql = null;
			estadoOperacion = false;
			connection=obtenerConexion();
			
			try {
				connection.setAutoCommit(false);
				sql="insert into reclamos (idReclamo,tipo,subtipo,idCliente,created_at) values (?,?,?,?,?)";
				statement=connection.prepareStatement(sql);
				
				statement.setString(1, null);
				statement.setString(2, reclamo.getTipo());
				statement.setString(3, reclamo.getSubtipo());
				statement.setInt(4, reclamo.getIdCliente());
				statement.setDate(5, reclamo.getCreated_at());
				
				estadoOperacion = statement.executeUpdate()>0;
				
				connection.commit();
				
				sql="insert into detallereclamos (idDetalle, idReclamo,marcaProducto,modelo,serie,empleado,local,fechaincidente,descripcion,estado) values (?,(SELECT idReclamo FROM reclamos ORDER BY idReclamo DESC LIMIT 1),?,?,?,?,?,?,?,?)";
				statement=connection.prepareStatement(sql);
				
				statement.setString(1, null);
				statement.setString(2, reclamo.getMarcaProducto());
				statement.setString(3, reclamo.getModelo());
				statement.setString(4, reclamo.getSerie());
				statement.setString(5, reclamo.getEmpleado());
				statement.setString(6, reclamo.getLocal());
				statement.setString(7, reclamo.getFechaincidente());
				statement.setString(8, reclamo.getDescripcion());
				statement.setString(9,"0");
				
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
		
		//OBTENER LISTA DE RECLAMOS
		public List<Reclamo> obtenerReclamos(int idCliente) throws SQLException {
			ResultSet resultSet=null;
			List<Reclamo> listaReclamos = new ArrayList<>();
			
			String sql = null;
			estadoOperacion = false;
			connection=obtenerConexion();
			
			try {
				
				sql="SELECT t1.*,t2.* FROM reclamos t1 left JOIN detallereclamos t2 ON t1.idReclamo=t2.idReclamo WHERE t1.deleted_at is null and t1.idCliente="+idCliente;
				statement=connection.prepareStatement(sql);
				resultSet=statement.executeQuery(sql);
				
				while(resultSet.next()) {
					Reclamo r =new Reclamo();
					r.setIdReclamo(resultSet.getInt(1));
					r.setTipo(resultSet.getString(2));
					r.setSubtipo(resultSet.getString(3));
					r.setIdCliente(resultSet.getInt(4));
					r.setCreated_at(resultSet.getDate(5));
					r.setUpdated_at(resultSet.getDate(6));
					r.setIdDetalle(resultSet.getInt(8));
					r.setMarcaProducto(resultSet.getString(10));
					r.setModelo(resultSet.getString(11));
					r.setSerie(resultSet.getString(12));
					r.setEmpleado(resultSet.getString(13));
					r.setLocal(resultSet.getString(14));
					r.setFechaincidente(resultSet.getString(15));
					r.setDescripcion(resultSet.getString(16));
					r.setEstado(resultSet.getString(17));
					r.setAtencion_detalle(resultSet.getString(18));
					
					listaReclamos.add(r);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listaReclamos;
		}
		
		//OBTENER LISTA DE TODOS  RECLAMOS
				public List<Reclamo> obtenerTodosReclamos() throws SQLException {
					ResultSet resultSet=null;
					List<Reclamo> listaReclamos = new ArrayList<>();
					
					String sql = null;
					estadoOperacion = false;
					connection=obtenerConexion();
					
					try {
						
						sql="SELECT t1.*,t2.*, t3.nombreCliente FROM reclamos t1 left JOIN detallereclamos t2 ON t1.idReclamo=t2.idReclamo left JOIN clientes t3 ON t3.idCliente=t1.idCliente WHERE t1.deleted_at is null";
						statement=connection.prepareStatement(sql);
						resultSet=statement.executeQuery(sql);
						
						while(resultSet.next()) {
							Reclamo r =new Reclamo();
							r.setIdReclamo(resultSet.getInt(1));
							r.setTipo(resultSet.getString(2));
							r.setSubtipo(resultSet.getString(3));
							r.setIdCliente(resultSet.getInt(4));
							r.setCreated_at(resultSet.getDate(5));
							r.setUpdated_at(resultSet.getDate(6));
							r.setIdDetalle(resultSet.getInt(8));
							r.setMarcaProducto(resultSet.getString(10));
							r.setModelo(resultSet.getString(11));
							r.setSerie(resultSet.getString(12));
							r.setEmpleado(resultSet.getString(13));
							r.setLocal(resultSet.getString(14));
							r.setFechaincidente(resultSet.getString(15));
							r.setDescripcion(resultSet.getString(16));
							r.setEstado(resultSet.getString(17));
							r.setAtencion_detalle(resultSet.getString(18));
							
							listaReclamos.add(r);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					return listaReclamos;
				}
		
		//OBTENER VER DE RECLAMO
		public Reclamo obtenerReclamo(int idReclamo) throws SQLException {
			ResultSet resultSet=null;
					
			String sql = null;
			estadoOperacion = false;
			connection=obtenerConexion();
			
			Reclamo r =new Reclamo();
			
			try {
						
				sql="SELECT t1.*,t2.* FROM reclamos t1 left JOIN detallereclamos t2 ON t1.idReclamo=t2.idReclamo WHERE t1.idReclamo="+idReclamo;
				statement=connection.prepareStatement(sql);
				resultSet=statement.executeQuery(sql);
						
						if(resultSet.next()) {
							
							r.setIdReclamo(resultSet.getInt(1));
							r.setTipo(resultSet.getString(2));
							r.setSubtipo(resultSet.getString(3));
							r.setIdCliente(resultSet.getInt(4));
							r.setCreated_at(resultSet.getDate(5));
							r.setUpdated_at(resultSet.getDate(6));
							r.setIdDetalle(resultSet.getInt(8));
							r.setMarcaProducto(resultSet.getString(10));
							r.setModelo(resultSet.getString(11));
							r.setSerie(resultSet.getString(12));
							r.setEmpleado(resultSet.getString(13));
							r.setLocal(resultSet.getString(14));
							r.setFechaincidente(resultSet.getString(15));
							r.setDescripcion(resultSet.getString(16));
							r.setEstado(resultSet.getString(17));
							r.setAtencion_detalle(resultSet.getString(18));
							
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					return r;
				}
		
		//GUARDAR
		public boolean actualizar(Date update_at, String estado, String detalle, int idReclamo) throws SQLException, MessagingException {
			String sql = null;
			estadoOperacion = false;
			connection=obtenerConexion();
					
			try {
				connection.setAutoCommit(false);
				sql="update reclamos set updated_at=? where idReclamo=?";
				statement=connection.prepareStatement(sql);
						
				statement.setDate(1, update_at);
				statement.setInt(2, idReclamo);
						
				estadoOperacion = statement.executeUpdate()>0;
						
				connection.commit();
						
				sql="update detallereclamos set estado=?, atencion_detalle=? where idReclamo=?";
				statement=connection.prepareStatement(sql);
						
				statement.setString(1, estado);
				statement.setString(2, detalle);
				statement.setInt(3, idReclamo);
				
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
		
	//OBTENER CONEXION POOL
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
