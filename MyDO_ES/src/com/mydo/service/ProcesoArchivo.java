package com.mydo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ProcesoArchivo
 */
@WebServlet("/ProcesoArchivo")
@MultipartConfig
public class ProcesoArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static PrintWriter out;
	private static String nomb;
	private static Part arch;
	private static InputStream is;
	private static File f;
	private static FileOutputStream ous;
	private static int dato;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesoArchivo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		out = response.getWriter();
		out.println("Bienvenido");
		
		nomb = request.getParameter("nombre");
		arch = request.getPart("archivo");
		is = arch.getInputStream();
		f = new File("C:/Users/alvaro.santos/git/my_do_es/MyDO_ES/WebContent/user_images/" + nomb);
		ous = new FileOutputStream(f);
		
		dato = is.read();
		// Cuando read devuelva -1 es que no hay mas datos que leer
		while (dato != -1) {
			ous.write(dato);
			dato = is.read();
		}
		ous.close();
		is.close();
	}

}
