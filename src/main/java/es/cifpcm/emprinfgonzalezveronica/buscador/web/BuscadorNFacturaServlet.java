package es.cifpcm.emprinfgonzalezveronica.buscador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cifpcm.emprinfgonzalezveronica.dao.DaoConfig;
import es.cifpcm.emprinfgonzalezveronica.model.*;

/**
 * Servlet implementation class BuscadorNFacturaServlet
 */
@WebServlet(urlPatterns = { "/buscadornfactura" }, initParams = {
		@WebInitParam(name = "app.config", value = "empresasinformaticas", description = "para el fichero properties de la base de datos") })
public class BuscadorNFacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(BuscadorNFacturaServlet.class);
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	private DaoConfig daoCfg = new DaoConfig();
	/* FacturaDao fdao = new ImpFacDao(); */
	Connection connection = null;
	PreparedStatement stmt;
	public static List<Factura> facturas = new ArrayList<Factura>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscadorNFacturaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Entrando en processRequest de la app: {}", request.getContextPath());
		logger.debug("Parámetro numero: {}", request.getParameter("numberToSearch"));
		StringBuilder sb = new StringBuilder();
		response.setContentType("text/html;charset=UTF-8");
		String cssTag;
		cssTag = "<link rel='stylesheet' type='text/css' href='main.css'>";
		try (PrintWriter out = response.getWriter()) {
			sb.append("<!DOCTYPE html>");
			sb.append("<html>");
			sb.append("<head>");
			sb.append("<title>Buscador de Facturas</title>");
			sb.append("</head>");
			sb.append("<body>" + cssTag);
			String numerofactura = request.getParameter("numberToSearch");
			if (numerofactura == null) {
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			} else {
				sb.append("<h3>Información sobre factura " + numerofactura + "</h3><br><br>");
				String sql = "SELECT * FROM factura where Nfactura=" + numerofactura;
				String com = "SELECT * FROM facturacomponente where NFactura=" + numerofactura;
				try {
					// conexión de datos employees
					connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
					stmt = connection.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery(sql);
					sb.append("<table>");
					// Creación de la tabla

					while (rs.next()) {

						sb.append("<tr><td>IdFactura</td><td>Fecha</td><td>Cliente</td><td>Tienda</tr>");
						if (sql.contains(numerofactura)) {
							sb.append("<tr><td>");
							sb.append(rs.getInt("NFactura"));
							sb.append("</td>");
							sb.append("<td>");
							sb.append(rs.getTimestamp(2));
							sb.append("</td>");
							sb.append("<td>");
							sb.append(rs.getString(3));
							sb.append("</td>");
							sb.append("<td>");
							sb.append(rs.getInt(4));
							sb.append("</td></tr></table><br><br>");
						}
						
					}
					stmt = connection.prepareStatement(com);
					ResultSet r = stmt.executeQuery(com);
					while (r.next()) {
						sb.append("<table><tr><td>CodigoComponente</td><td>Referencia</td><td>Cantidad</td><td>PrecioAplicado</tr>");
						if (com.contains(numerofactura)) {
							sb.append("<tr><td>");
							sb.append(r.getString(3));
							sb.append("</td>");
							sb.append("<td>");
							sb.append(r.getString(4));
							sb.append("</td>");
							sb.append("<td>");
							sb.append(r.getInt(5));
							sb.append("</td><td>");
							sb.append(r.getFloat(6));
							sb.append("</td></tr></table>");
						}

					}
					sb.append("</body>");
					sb.append("</html>");
					out.println(sb.toString());
				} catch (SQLException ex) {
					logger.error(ex.getMessage());
					getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

				} finally { // Se cierra la conexión con la base de datos.
					try {
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException ex) {
						logger.error(ex.getMessage());
						getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

					}
				}

			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			String configBundleName = config.getInitParameter("app.config");
			ResourceBundle rb = ResourceBundle.getBundle(configBundleName);
			this.dbUrl = rb.getString("database.url");
			this.dbUser = rb.getString("database.user");
			this.dbPassword = rb.getString("database.password");
			String driverClassName = rb.getString("database.driver");
			Class.forName(driverClassName);
		} catch (ClassNotFoundException ex) {
			// Logger.getLogger(BuscadorNFacturaServlet.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
	}

}
