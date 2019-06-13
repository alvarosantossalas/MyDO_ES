package com.mydo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydo.core.dao.TaskDAO;
import com.mydo.core.model.Task;

public class TaskCtrl {

	private static TaskCtrl instance = null;

	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static TaskCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new TaskCtrl();
		return instance;
	}

	/**
	 * Inserta una tarea
	 * @param task
	 * @throws SQLException
	 */
	public void insert(Task task) throws SQLException {
		TaskDAO.getInstance().insert(task);
	}

	/**
	 * Actualiza una tarea
	 * @param task
	 * @throws SQLException
	 */
	public void update(Task task) throws SQLException {
		TaskDAO.getInstance().update(task);
	}

	/**
	 * Elimina una tarea filtrando por id
	 * @param id
	 * @throws SQLException
	 */
	public void remove(String id) throws SQLException {
		TaskDAO.getInstance().remove(id);
	}

	/**
	 * Retorna todas las tareas existentes
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Task> listAll() throws SQLException {
		return TaskDAO.getInstance().listAll();
	}

	/**
	 * Retorna una tarea filtrando por id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Task listById(String id) throws SQLException {
		return TaskDAO.getInstance().listById(id);
	}

	/**
	 * Determina si un proyecto se crea automáticamente o no
	 * @param subject
	 * @return
	 * @throws SQLException
	 */
	public int projectIsCreaterOrNot(String subject) throws SQLException {
		return TaskDAO.getInstance().projectIsCreatedOrNot(subject);
	}

	/**
	 * Retorna el id de una tarea filtrando por su nombre
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public String selectIdTaskByName(String name) throws SQLException {
		return TaskDAO.getInstance().selectIdTaskByName(name);
	}

	/**
	 * Retorna una lista de los proyectos a los que pertenece un equipo
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllProjectsForATeam(String id) throws SQLException {
		return TaskDAO.getInstance().listAllProjectsForATeam(id);
	}

	/**
	 * Retorna los nombres para un proyecto concreto
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllNamesForConcreteProject(String id) throws SQLException {
		return TaskDAO.getInstance().listAllNamesForConcreteProjects(id);
	}

	/**
	 * Crea una tarea y la relaciona con un equipo
	 * @param id_team
	 * @param id_task
	 * @throws SQLException
	 */
	public void insertTaskAndTeamRelationShip(String id_team, String id_task) throws SQLException {
		TaskDAO.getInstance().insertTaskAndTeamRelationShip(id_team, id_task);
	}

	/**
	 * Retorna todas las tareas a las que pertenece un usuario
	 * @param id_user
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Task> listAllTasksForOneUser(String id_user) throws SQLException {
		return TaskDAO.getInstance().listAllTasksForOneUser(id_user);
	}

	/**
	 * Devuelve el porcentaje de progreso de una tarea en concreto
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int selectPercentageOfProgress(String id) throws SQLException {
		Task task = listById(id);
		return (100 * task.getConsumed_time() / task.getEstimated_time());
	}

	/**
	 * Retorna el nombre de una tarea filtrando por su id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectTaskNameByIdTask(String id) throws SQLException {
		return TaskDAO.getInstance().selectTaskNameByIdTask(id);
	}

	/**
	 * Retorna el valor del estado para la tarea seleccionada
	 * @param task
	 * @return
	 */
	public String returnValueOfStatusForSelectedTask(Task task) {
		StringBuffer sb = new StringBuffer();
		switch (task.getStatus()) {
		case "btn-secondary":
			sb.append("<option value='btn-secondary' selected>Prioridad baja</option>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning'>Prioridad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>" + "<option value='btn-success'>Cumplida</option>");
			break;
		case "btn-primary":
			sb.append("<option value='btn-secondary'>Prioridad baja</option>"
					+ "<option value='btn-primary' selected>Prioridad normal</option>"
					+ "<option value='btn-warning'>Prioridad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>" + "<option value='btn-success'>Cumplida</option>");
			break;
		case "btn-warning":
			sb.append("<option value='btn-secondary'>Prioridad baja</option>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning' selected>Prioridad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>" + "<option value='btn-success'>Cumplida</option>");
			break;
		case "btn-danger":
			sb.append("<option value='btn-secondary'>Prioridad baja</option>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning'>Prioridad alta</option>"
					+ "<option value='btn-danger' selected>Abortada</option>"
					+ "<option value='btn-success'>Cumplida</option>");
			break;
		case "btn-success":
			sb.append("<option value='btn-secondary'>Priodidad baja</otpion>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning'>Priodidad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>"
					+ "<option value='btn-success' selected>Cumplida</option>");
			break;
		}
		return sb.toString();
	}

	/**
	 * Retorna el valor del tipo para la tarea seleccionada
	 * @param task
	 * @return
	 */
	public String returnValueOfTypeForSelectedTask(Task task) {
		StringBuffer sb = new StringBuffer();
		switch (task.getType()) {
		case "trabajo":
			sb.append("<option value='trabajo' selected>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal'>Personal</option>" + "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>");
			break;
		case "estudios":
			sb.append("<option value='trabajo'>Trabajo</option>" + "<option value='estudios' selected>Estudios</option>"
					+ "<option value='personal'>Personal</option>" + "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>");
			break;
		case "personal":
			sb.append("<option value='trabajo'>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal' selected>Personal</option>"
					+ "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>");
			break;
		case "importante":
			sb.append("<option value='trabajo'>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal'>Personal</option>"
					+ "<option value='importante' selected>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>");
			break;
		case "recordatorio":
			sb.append("<option value='trabajo'>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal'>Personal</option>" + "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio' selected>Recordatorio</option>");
			break;
		}
		return sb.toString();
	}

	/**
	 * <b>showTaskInBoard()</b>
	 * Retorna en forma de lista todas las tareas en el tablero de un usuario.
	 * 
	 * @param id_user El usuario del cual queremos mostrar todas sus tareas
	 * @return String Retorna un String que contiene una tabla en HTML con los datos recogidos de la base de datos
	 * @throws SQLException
	 */
	public String showTaskInBoard(String id_user) throws SQLException {
		StringBuilder sb = new StringBuilder();
		if (listAllTasksForOneUser(id_user) != null) {
			ArrayList<Task> tasks = listAllTasksForOneUser(id_user);
			if (tasks.isEmpty()) {
				System.out.println("No existen tareas");
			} else {
				for (int i = 0; i < tasks.size(); i++) {
					sb.append("<tr class='" + tasks.get(i).getStatus() + "'>" + "<th scope='row'>"
							+ "<a href='http://localhost:8080/MyDO_ES/task.jsp?id_task=" + tasks.get(i).getId_task()
							+ "'>"
							+ "<button target='_blank' class='btn'><img src='icons/icon-settings_24px.png'></button>"
							+ "</a>" + "</th>" + "<th scope='row'><a href='DeleteTask?id_task="
							+ tasks.get(i).getId_task()
							+ "'><button class='btn'><img src='icons/icon-trash_24px.png'></button></a></th>" + "<td class='h6'>"
							+ tasks.get(i).getName() + "</td>" + "<td>" + tasks.get(i).getSubject() + "</td>" + "<td>"
							+ tasks.get(i).getDescription() + "</td>" + "<td>" + tasks.get(i).getType() + "</td>"
							+ "<td><div class='progress' style='height:38px;'><div class='progress-bar progress-bar-striped bg-success' role='progressbar' style='width:"
							+ selectPercentageOfProgress(tasks.get(i).getId_task())
							+ "%' aria-valuenow='25' aria-voluemin='0' aria-valuemax='100'></div></div></td>");
					sb.append("<td>" + TeamCtrl.getInstance().selectNameTeamById(tasks.get(i).getId_team()) + "</td>");
				}
			}
		} else {
			sb.append("<th class='btn-primary text-center display-4' colspan='8'>No existen tareas</th>");
		}
		return sb.toString();
	}

	/**
	 * Retorna la primera parte del porcentaje de la tarea
	 * @param id_task
	 * @param selected_task
	 * @return
	 * @throws SQLException
	 */
	public String showFirstPartOfPercentageInTask(String id_task, Task selected_task) throws SQLException {
		StringBuffer sb = new StringBuffer();
		if (selectPercentageOfProgress(id_task) >= 100) {
			sb.append("Progreso: 100%");
			selected_task.setStatus("btn-success");
			update(selected_task);
		} else {
			sb.append("Progreso: " + selectPercentageOfProgress(id_task) + "%");
		}
		return sb.toString();
	}

	/**
	 * Retorna la segunda parte del porcentaje de la tarea
	 * @param id_task
	 * @return
	 * @throws SQLException
	 */
	public String showSecondPartOfPercentageInTask(String id_task) throws SQLException {
		return "<div class='progress-bar progress-bar-striped bg-success' role='progressbar' style='width:"
				+ selectPercentageOfProgress(id_task)
				+ "%' aria-valuenow='25' aria-valuemin='0' aria-valuemax='100'></div>";
	}

	/**
	 * Retorna el valor del asunto de la tarea seleccionada.
	 * @param task
	 * @return
	 */
	public String inputTypeTextForSubject(Task task) {
		return "<input type='text' class='form-control' value='" + task.getSubject() + "' name='_subject' required>";
	}

	/**
	 * Retorna el valor de la descripción de la tarea seleccionada
	 * @param task
	 * @return
	 */
	public String textAreaForDescription(Task task) {
		return "<textarea class='form-control' id='_description' name='_description' rows='10' required>"
				+ task.getDescription() + "</textarea>";
	}

	/**
	 * Retorna el valor del tiempo consumido de la tarea
	 * @param task
	 * @return
	 */
	public String inputTypeTextForConsumedTime(Task task) {
		System.out.println("Tiempo consumido: " + task.getConsumed_time());
		return "Tiempo consumido: <input type='number' class='form-control' value='" + task.getConsumed_time()
				+ "' name='_consumed_time' required>";
	}

	/**
	 * Retorna el valor del tiempo estimado de la tarea seleccionada
	 * @param task
	 * @return
	 */
	public String inputTypeTextForEstimatedTime(Task task) {
		return "Tiempo estimado: <input type='number' class='form-control' value='" + task.getEstimated_time()
				+ "' name='_estimated_time' required>";
	}

	/**
	 * Retorna un botón para eliminar una tarea
	 * @param id_task
	 * @return
	 */
	public String showDeleteTaskButton(String id_task) {
		return "<a class='btn btn-danger' href='http://localhost:8080/MyDO_ES/DeleteTask?id_task=" + id_task
				+ "'>Eliminar tarea</a><input type='hidden' name='_id_task' value='" + id_task + "'>";
	}

}
