package com.ecodeup.presentacion;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecodeup.negocio.Cliente;
import com.ecodeup.persistencia.ClienteDAO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(description = "Controla login de usuarios y cambio de contrasenias", urlPatterns = { "/cliente" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom rnd = new SecureRandom();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("crear")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crearcuenta.jsp");
			requestDispatcher.forward(request, response);
		}else if(opcion.equals("listarreclamos")){
		}else if(opcion.equals("recuperar")){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cambiarcontrasenia.jsp");
			requestDispatcher.forward(request, response);
		}else if(opcion.equals("registrarreclamo")){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crearreclamo.jsp");
			requestDispatcher.forward(request, response);
		}else if(opcion.equals("inicio")){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/portada.jsp");
			requestDispatcher.forward(request, response);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = request.getParameter("opcion");
		ClienteDAO clidao = new ClienteDAO();
		Cliente cliente = new Cliente();
		Date fechaactual = new Date();
		
		cliente.setNombreCliente(request.getParameter("nombre"));
		cliente.setApellidoCliente(request.getParameter("apellido"));
		cliente.setDni(request.getParameter("dni"));
		cliente.setTelefono(request.getParameter("telefono"));
		cliente.setCorreo(request.getParameter("correo"));
		cliente.setUsuario(request.getParameter("usuario"));
		cliente.setContrasenia(request.getParameter("contrasenia"));
		cliente.setCreated_at(new java.sql.Date(fechaactual.getTime()));
		cliente.setUpdated_at(new java.sql.Date(fechaactual.getTime()));
		
		if(opcion.equals("guardar")) {
			try {
				clidao.guardar(cliente);
				request.setAttribute("msgtitulo", "Cuenta Creada");
				request.setAttribute("msgdetalle", "Se creó tu cuenta de manera exitosa.<br>Se enviaron tus datos de acceso a tu correo electrónico asociado, verifica tu Bandeja de entrada o Spam.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/mensajelogin.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("ingresar")) {
			Cliente cli = new Cliente();
			try {
				cli = clidao.ingresarCliente(request.getParameter("usuario"),request.getParameter("contrasenia"));
				
				if(cli.getNombreCliente()!="" || cli.getNombreCliente()!=null) {
					HttpSession sessioncliente= request.getSession(true);
					sessioncliente.setAttribute("cliente",cli);
					
					request.setAttribute("cliente", cli);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/portada.jsp");
					requestDispatcher.forward(request, response);
				}else {
					request.setAttribute("msglogin", "El usuario no existe");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("recuperar")) {
			try {
				StringBuilder sb = new StringBuilder(8);
				for(int i = 0; i < 8; i++)
				      sb.append(AB.charAt(rnd.nextInt(AB.length())));
				
				String ncontrasenia = sb.toString();
				clidao.cambiarContrasenia(request.getParameter("correo"), new java.sql.Date(fechaactual.getTime()), ncontrasenia);
				request.setAttribute("msgtitulo", "Cuenta Recuperada");
				request.setAttribute("msgdetalle", "Se realizó la actualización de contraseña de tu cuenta y se enviaron los nuevos datos de acceso a tu correo electrónico asociado, verifica tu bandeja de entrada o Spam.");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/mensajelogin.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//doGet(request, response);
	}

}
