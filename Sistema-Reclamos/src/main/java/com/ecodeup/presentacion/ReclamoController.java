package com.ecodeup.presentacion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecodeup.negocio.Cliente;
import com.ecodeup.negocio.Reclamo;
import com.ecodeup.persistencia.ReclamoDAO;

/**
 * Servlet implementation class ReclamoController
 */
@WebServlet(name = "reclamo", urlPatterns = { "/reclamo" })
public class ReclamoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReclamoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sessioncliente= (HttpSession) request.getSession();
		Cliente cli= (Cliente) sessioncliente.getAttribute("cliente");
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("seguimientoreclamo")) {
			ReclamoDAO recdao = new ReclamoDAO();
			List<Reclamo> lista = new ArrayList<>();
			
			try {
				lista  = recdao.obtenerReclamos(cli.getIdCliente());
				
				request.setAttribute("listareclamos", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/seguimientoreclamo.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("ver")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ReclamoDAO recdao = new ReclamoDAO();
			Reclamo reclamo = new Reclamo();
			
			try {
				reclamo = recdao.obtenerReclamo(id);
				request.setAttribute("reclamo", reclamo);
				request.setAttribute("usuario", cli);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/detallereclamo.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(opcion.equals("todosreclamos")) {
			ReclamoDAO recdao = new ReclamoDAO();
			List<Reclamo> lista = new ArrayList<>();
			
			try {
				lista  = recdao.obtenerTodosReclamos();
				
				request.setAttribute("listareclamos", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/todosreclamos.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession sessioncliente= (HttpSession) request.getSession();
		Cliente cli= (Cliente) sessioncliente.getAttribute("cliente");
		
		
		String opcion = request.getParameter("opcion");
		ReclamoDAO recdao = new ReclamoDAO();
		Reclamo reclamo = new Reclamo();
		Date fechaactual = new Date();
		
		reclamo.setTipo(request.getParameter("tipo"));
		reclamo.setSubtipo(request.getParameter("subtipo"));
		reclamo.setIdCliente(cli.getIdCliente());
		reclamo.setCreated_at(new java.sql.Date(fechaactual.getTime()));
		reclamo.setUpdated_at(null);
		
		reclamo.setIdReclamo(1);
		reclamo.setMarcaProducto(request.getParameter("marcaProducto"));
		reclamo.setModelo(request.getParameter("modelo"));
		reclamo.setSerie(request.getParameter("serie"));
		reclamo.setEmpleado(request.getParameter("empleado"));
		reclamo.setLocal(request.getParameter("local"));
		reclamo.setFechaincidente(request.getParameter("fechaincidente"));
		reclamo.setDescripcion(request.getParameter("descripcion"));
		reclamo.setEstado("0");

		if(opcion.equals("guardar")) {
			try {
				recdao.guardar(reclamo);
				request.setAttribute("msgtitulo", "<center><h1>Registrar Reclamo</h1></center>");
				request.setAttribute("msgdetalle", "¡Reclamo / Queja Registrada Exitosamente!<br>Su Reclamo / Queja se registró de manera exitosa. Se envió un mensaje al correo electrónico asociado a su cuenta para poder realizar el seguimiento o también lo puede hacer en la pestaña'Seguimiento Reclamo'<br>Nosotros estaremso informandole el progreso y solución a su reclamo ¡Gracias!");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/mensajereclamo.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(opcion.equals("accionreclamo")) {
			try {
				
				recdao.actualizar(new java.sql.Date(fechaactual.getTime()), request.getParameter("estado"), request.getParameter("descripcion"), Integer.parseInt(request.getParameter("idReclamo")));
				
				List<Reclamo> lista = new ArrayList<>();
				
				try {
					lista  = recdao.obtenerTodosReclamos();
					
					request.setAttribute("listareclamos", lista);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/todosreclamos.jsp");
					requestDispatcher.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/mensajereclamo.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException | MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
