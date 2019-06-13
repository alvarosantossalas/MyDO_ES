package com.mydo.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import com.mydo.core.dao.connection.DBConnection;
import com.mydo.core.model.Project;

/**
 * Define la funcionalidad del objecto Project para interactuar con la base de
 * datos
 * 
 * @author Álvaro Santos
 * @version 30/05/2019 A
 */
public class ProjectDAO {

	private static String query;

	private Connection con = null;
	private static ProjectDAO instance = null;

	/**
	 * <b>Constructor</b> Usa la clase DBConnection para recoger la sesión de la
	 * conexión con la base de datos a través del método getConnection()
	 * 
	 * @throws SQLException
	 */
	private ProjectDAO() throws SQLException {
		con = DBConnection.getConnection();
	} /* close contructor */

	/**
	 * <b>getInstance()</b> Crea una instancia de la clase para trabajar con ella
	 * más adelante
	 * 
	 * @return Una instancia de ProjectDAO
	 * @throws SQLException
	 */
	public static ProjectDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new ProjectDAO();
		} /* close if */
		return instance;
	} /* close method */

	/**
	 * <b>insert()</b> Inserta un proyecto en la base de datos
	 * 
	 * @param project Este objeto es creado previamente con los valores que el
	 *                usuario ha introducido en un formulario HTML
	 * @throws SQLException
	 */
	public void insert(Project project) throws SQLException {
		query = "INSERT INTO tfg_project (_id_project, _name, _status, _subject, _project_manager) VALUES (?,?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, project.getId_project());
			ps.setString(2, project.getName());
			ps.setInt(3, project.getStatus());
			ps.setString(4, project.getSubject());
			ps.setString(5, project.getProject_manager());
			ps.executeUpdate();
			ps.close();
		} /* close try */
	} /* close method */

	/**
	 * <b>listAll()</b> Lista todos los proyectos existentes en la base de datos
	 * 
	 * @return ArrayList<Project> que contiene todos los proyectos existentes de la
	 *         base de datos
	 * @throws SQLException
	 */
	public ArrayList<Project> listAll() throws SQLException {
		query = "SELECT * FROM tfg_project;";
		ArrayList<Project> result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				} /* close if */
				result.add(new Project(rs.getString("_id_project"), rs.getString("_name"), rs.getInt("_status"),
						rs.getString("_subject"), rs.getString("_project_manager")));
			} /* close while */
			rs.close();
		} /* close try */
		return result;
	} /* close method */

	/**
	 * <b>listById()</b> Lista un proyecto que existe en la base de datos </b>
	 * 
	 * @param id_project Se usa para filtrar por id dentro de la tabla tfg_project
	 * @return un objecto Project con los valores recuperados de la base de datos
	 * @throws SQLException
	 */
	public Project listById(String id_project) throws SQLException {
		query = "SELECT * FROM tfg_project WHERE _id_project = ?;";
		Project result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = new Project(rs.getString("_id_project"), rs.getString("_name"), rs.getInt("_status"),
							rs.getString("_subject"), rs.getString("_project_manager"));
				} /* close if */
			} /* close try2 */
		} /* close try1 */
		return result;
	} /* close method */

	/**
	 * <b>remove()</b> Usa el método remove(String id) que gestiona la query que
	 * elimina el proyecto
	 * 
	 * @param project Un objecto Project del cuál se seleccionará su id para
	 *                eliminarlo
	 * @throws SQLException
	 */
	public void remove(Project project) throws SQLException {
		remove(project.getId_project());
	} /* close method */

	/**
	 * <b>remove()</b> Busca el id del proyecto que se quiere eliminar de la base de
	 * datos y si encuentra algún resultado lo elimina permanentemente
	 * 
	 * @param id_project Es el filtro por el cual se elimina una fila en la base de
	 *                   datos
	 * @throws SQLException
	 */
	public void remove(String id_project) throws SQLException {
		if ("".equals(id_project)) {
			return;
		} /* close if */
		query = "DELETE FROM tfg_project WHERE _id_project = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			ps.executeUpdate();
		} /* close try */
	} /* close method */

	/**
	 * <b>update()</b> Recoge los atributos del proyecto que se quiere actualizar y
	 * actualiza los datos en la base de datos
	 * 
	 * @param project Objecto Proyecto en el cual están ya las modificaciones
	 *                deseadas
	 * @throws SQLException
	 */
	public void update(Project project) throws SQLException {
		if ("".equals(project.getId_project())) {
			return;
		} /* close if */
		query = "UPDATE tfg_project SET _id_project=?, _name=?, _status=?, _subject=?, _project_manager=? WHERE _id_project=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, project.getId_project());
			ps.setString(2, project.getName());
			ps.setInt(3, project.getStatus());
			ps.setString(4, project.getSubject());
			ps.setString(5, project.getProject_manager());
			ps.setString(6, project.getId_project());
			ps.executeUpdate();
			ps.close();
		} /* close try */
	} /* close method */

	/**
	 * <b>selectIdProjectByName</b> Devuelve un id de un proyecto en el caso de que
	 * el nombre que se busca exista en la base de datos como nombre de proyecto. Si
	 * existen dos proyectos con el mismo nombre sólo retornará el primer proyecto
	 * 
	 * @param projectName Nombre del proyecto del que se quiere saber el id
	 * @return el id del proyecto que hemos buscado
	 * @throws SQLException
	 */
	public String selectIdProjectByName(String projectName) throws SQLException {
		query = "SELECT _id_project FROM tfg_project WHERE _name = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, projectName);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_id_project");
				} /* close if */
			} /* close second try */
		} /* cierre first try */
		return result;
	} /* close method */

	/**
	 * <b>selectNameByIdProject()</b> Devuelve un nombre de un proyecto en el caso
	 * de que el id que se busca exista en la base de datos como id de proyecto.
	 * 
	 * @param id_project Id del proyecto del que se quiere saber el nombre
	 * @return el nombre del proyecto que hemos buscado
	 * @throws SQLException
	 */
	public String selectNameByIdProject(String id_project) throws SQLException {
		query = "SELECT _name FROM tfg_project WHERE _id_project = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_name");
				} /* close if */
			} /* close second try */
		} /* close first try */
		return result;
	} /* close method */

	/**
	 * <b>listAllNames()</b> Retorna un ArrayList<String> que contiene todos los
	 * nombres de los proyectos existentes en la base de datos
	 * 
	 * @return una lista con todos los nombres de los proyectos existentes en la
	 *         base de datos
	 * @throws SQLException
	 */
	public ArrayList<String> listAllNames() throws SQLException {
		query = "SELECT _name FROM tfg_project;";
		ArrayList<String> result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				} /* close if */
				result.add(rs.getString("_name"));
			} /* close while */
			rs.close();
		} /* close try */
		return result;
	} /* close method */

	/**
	 * <b>CreateTaskInProject()</b> Inserta una relación en la base de datos entre
	 * una tarea, el proyecto al que pertenece, y el equipo responsable. Este método
	 * se usa generalmente cuando se crea una tarea o en las pantallas de
	 * administración
	 * 
	 * @param id_project String que se usará para relacionar el proyecto
	 * @param id_task    String que se usará para relacionar la tarea
	 * @param id_team    String que se usará para relacionar el equipo
	 * @throws SQLException
	 */
	public void createTasksInProject(String id_project, String id_task, String id_team) throws SQLException {
		query = "INSERT INTO tfg_tasks_in_projects (_id_tasks_in_projects, _id_project, _id_task, _id_team) VALUES (?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, UUID.randomUUID().toString());
			ps.setString(2, id_project);
			ps.setString(3, id_task);
			ps.setString(4, id_team);
			ps.executeUpdate();
			ps.close();
		} /* close try */
		System.out.println("Relation inserted");
	} /* close method */

	/**
	 * <b>listAllProjectForOneUser()</b> Retorna un ArrayList<String> que contiene
	 * todos los nombres de los proyectos en los que un equipo está involucrado
	 * 
	 * @param id_user String Filtra todos los equipos a los que pertenece un
	 *                usuario, una vez que se tienen todos los equipos, busca todos
	 *                los proyectos que pertenecen a esos equipos
	 * @return una lista de los nombres a los que pertenece un usuario con id =
	 *         id_user
	 * @throws SQLException
	 */
	public ArrayList<String> listAllProjectsForOneUser(String id_user) throws SQLException {
		query = "SELECT _name FROM tfg_project WHERE _id_project IN (SELECT _id_project FROM tfg_tasks_in_projects WHERE _id_team IN (SELECT _id_team FROM tfg_members_team WHERE _id_user = ?));";
		ArrayList<String> result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>(); // se instancia
					} /* close if */
					result.add(rs.getString("_name"));
				} /* close while */
			} /* close second try */
		} /* close first try */
		return result;
	} /* close method */

	/**
	 * <b>countHowManyTasks()</b>
	 * Cuenta cuantas tareas existen dentro de un proyecto, sin especificar ningún criterio.
	 * 
	 * @param id_project String Se contarán las tareas que existen dentro del proyecto que tenga este id.
	 * @return el número de tareas que existen para un proyecto con id = id_project
	 * @throws SQLException
	 */
	public int countHowManyTasks(String id_project) throws SQLException {
		int result = 0;
		query = "SELECT COUNT('_id_task') FROM tfg_tasks_in_projects WHERE _id_project = '" + id_project + "';";
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				result = rs.getInt(1); 
			} /* close if */
		} /* close try */
		return result;
	} /* close method */

	/**
	 * Retorna todas las tareas de un proyecto
	 * 
	 * @param id_project se usará para filtrar el proyecto del que queremos sacar
	 *                   todas las tareas
	 * @return una lista con los nombres de todas las tareas que pertenecen a un
	 *         proyecto
	 * @throws SQLException
	 */
	public ArrayList<String> listAllTasksForOneProject(String id_project) throws SQLException {
		query = "SELECT _id_task FROM tfg_tasks_in_projects WHERE _id_project = ?;";
		ArrayList<String> result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>(); // la instancia
					} /* close if */
					result.add(rs.getString("_id_task"));
				} /* close while */
			} /* close second try */
		} /* close first try */
		return result;
	} /* close method */

	/**
	 * <b>listAllProjectsForOneTask()</b>
	 * Selecciona todos los proyectos a los que pertenece una tarea.
	 * 
	 * @param id_task String Parámetro que se usará para filtrar los proyectos a los que
	 *                pertenece una tarea
	 * @return una lista con todos los nombres de los proyectos los cuales exista la
	 *         tarea
	 * @throws SQLException
	 */
	public ArrayList<String> listAllProjectsForOneTask(String id_task) throws SQLException {
		query = "SELECT _name FROM tfg_project WHERE _id_project IN (SELECT _id_project FROM tfg_tasks_in_projects WHERE _id_task = ?);";
		ArrayList<String> result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_task);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>(); 
					} /* close if */
					result.add(rs.getString("_name"));
				} /* close while */
			} /* close second try */
		} /* close first try */
		return result;
	} /* close method */

	/**
	 * <b>selectProjectManagerById()</b>
	 * Retorna el usuario de tipo project manager para un proyecto en concreto
	 * 
	 * @param id_project para filtrar el proyecto del que queremos saber qué usuario
	 *                   es project manager
	 * @return un String que contiene el valor del project manager para el proyecto
	 *         seleccionado
	 * @throws SQLException
	 */
	public String selectProjectManagerForProjectById(String id_project) throws SQLException {
		query = "SELECT _project_manager FROM tfg_project WHERE _id_project = ?;";
		String result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_project_manager");
				} /* close if */
			} /* close second try */
		} /* close first try */
		return result;
	} /* close method */

} /* close class */