package com.mydo.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class ChangePhoto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(404);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getPart("foto").getSize() > 0) {
			// nos aseguramos que el archivo es una imagen y que no excede de unos 8mb
			if (request.getPart("foto").getContentType().contains("image") == false
					|| request.getPart("foto").getSize() > 8388608) {
				// tipo de archivo no valido
				response.sendRedirect("index.jsp");
				System.out.println("El formato no es correcto");
			} else {
				// obtenemos la ruta absoluta del sistema donde queremos guardar la imagen
				String fileName = this.getServletContext().getRealPath("user-images");
				// Guardamos la imagen en disco con la ruta que hemos obtenido en el paso
				// anterior
				boolean ok = guardarImagenDeUsuarioEnElSistemaDeFicheros(request.getPart("foto").getInputStream(),
						fileName);
				if (ok == false) {
					response.sendError(403);
					System.out.println("Fallo al guardar el archivo");
					System.out.println("Ocurrió un error guardando la imagen");
				}
			}
		}
		// Todo correcto se redirige a una página de visualización
		

	}

	public static boolean guardarImagenDeUsuarioEnElSistemaDeFicheros(InputStream input, String fileName)
			throws ServletException {
		FileOutputStream output = null;
		boolean ok = false;
		try {
			output = new FileOutputStream(fileName);
			int leido = 0;
			leido = input.read();
			while (leido != -1) {
				output.write(leido);
				leido = input.read();
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, ex.getMessage());
		} catch (IOException ex) {
			Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, ex.getMessage());
		} finally {
			try {
				output.flush();
				output.close();
				input.close();
				ok = true;
			} catch (IOException ex) {
				Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, "Error cerrando flujo de salida", ex);
			}
		}
		return ok;
	}

}
