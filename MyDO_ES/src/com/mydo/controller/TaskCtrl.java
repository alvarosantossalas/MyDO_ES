package com.mydo.controller;

import com.mydo.core.model.Task;
import com.mydo.core.dao.TaskDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskCtrl {

	private static TaskCtrl instance = null;

	public static TaskCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new TaskCtrl();
		return instance;
	}

	// insert task object
	public void insert(Task task) throws SQLException {
		TaskDAO.getInstance().insert(task);
	}

	// update task object
	public void update(Task task) throws SQLException {
		TaskDAO.getInstance().update(task);
	}

	// remove task object
	public void remove(String id) throws SQLException {
		TaskDAO.getInstance().remove(id);
	}

	// list all the existing task objects
	public ArrayList<Task> listAll() throws SQLException {
		return TaskDAO.getInstance().listAll();
	}

	// list task object by id task
	public Task listById(String id) throws SQLException {
		Task result = TaskDAO.getInstance().listById(id);
		return result;
	}

	// returns an int and admin if a project object is created or not
	public int projectIsCreaterOrNot(String subject) throws SQLException {
		return TaskDAO.getInstance().projectIsCreatedOrNot(subject);
	}

	// select id by name
	public String selectIdTaskByName(String name) throws SQLException {
		return TaskDAO.getInstance().selectIdTaskByName(name);
	}

	// list of all projects objects related to a team object to show them the user
	// when creating a task object
	public ArrayList<String> listAllProjectsForATeam(String id) throws SQLException {
		return TaskDAO.getInstance().listAllProjectsForATeam(id);
	}

	// list all names for a concrete project object
	public ArrayList<String> listAllNamesForConcreteProject(String id) throws SQLException {
		return TaskDAO.getInstance().listAllNamesForConcreteProjects(id);
	}

	public void insertTaskAndTeamRelationShip(String id_team, String id_task) throws SQLException {
		TaskDAO.getInstance().insertTaskAndTeamRelationShip(id_team, id_task);
	}

	public ArrayList<Task> listAllTasksForOneUser(String id_user) throws SQLException {
		return TaskDAO.getInstance().listAllTasksForOneUser(id_user);
	}

	public int selectPercentageOfProgress(String id) throws SQLException {
		Task task = listById(id);
		return (100 * task.getConsumed_time() / task.getEstimated_time());
	}

	public String selectTaskNameByIdTask(String id) throws SQLException {
		return TaskDAO.getInstance().selectTaskNameByIdTask(id);
	}

	public String returnValueOfStatusForSelectedTask(Task task) {
		String str = "";
		if (task.getStatus().equals("btn-secondary")) {
			str += "<option value='btn-secondary' selected>Prioridad baja</option>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning'>Prioridad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>" + "<option value='btn-success'>Cumplida</option>";
		} else if (task.getStatus().equals("btn-primary")) {
			str += "<option value='btn-secondary'>Prioridad baja</option>"
					+ "<option value='btn-primary' selected>Prioridad normal</option>"
					+ "<option value='btn-warning'>Prioridad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>" + "<option value='btn-success'>Cumplida</option>";
		} else if (task.getStatus().equals("btn-warning")) {
			str += "<option value='btn-secondary'>Prioridad baja</option>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning' selected>Prioridad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>" + "<option value='btn-success'>Cumplida</option>";
		} else if (task.getStatus().equals("btn-danger")) {
			str += "<option value='btn-secondary'>Prioridad baja</option>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning'>Prioridad alta</option>"
					+ "<option value='btn-danger' selected>Abortada</option>"
					+ "<option value='btn-success'>Cumplida</option>";
		} else if (task.getStatus().equals("btn-success")) {
			str += "<option value='btn-secondary'>Priodidad baja</otpion>"
					+ "<option value='btn-primary'>Prioridad normal</option>"
					+ "<option value='btn-warning'>Priodidad alta</option>"
					+ "<option value='btn-danger'>Abortada</option>" + "<option value='btn-success'>Cumplida</option>";
		}
		return str;
	}

	public String returnValueOfTypeForSelectedTask(Task task) {
		String str = "";
		if (task.getType().equals("trabajo")) {
			str += "<option value='trabajo' selected>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal'>Personal</option>" + "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>";
		} else if (task.getType().equals("estudios")) {
			str += "<option value='trabajo'>Trabajo</option>" + "<option value='estudios' selected>Estudios</option>"
					+ "<option value='personal'>Personal</option>" + "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>";
		} else if (task.getType().equals("personal")) {
			str += "<option value='trabajo'>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal' selected>Personal</option>"
					+ "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>";
		} else if (task.getType().equals("importante")) {
			str += "<option value='trabajo'>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal'>Personal</option>"
					+ "<option value='importante' selected>Importante</option>"
					+ "<option value='recordatorio'>Recordatorio</option>";
		} else if (task.getType().equals("recordatorio")) {
			str += "<option value='trabajo'>Trabajo</option>" + "<option value='estudios'>Estudios</option>"
					+ "<option value='personal'>Personal</option>" + "<option value='importante'>Importante</option>"
					+ "<option value='recordatorio' selected>Recordatorio</option>";
		}
		return str;
	}

	public String showTaskInBoard(String id_user) throws SQLException {
		String str = "";
		if (listAllTasksForOneUser(id_user) != null) {
			ArrayList<Task> tasks = listAllTasksForOneUser(id_user);

			if (tasks.isEmpty()) {
				System.out.println("No existen tareas");
			} else {
				for (int i = 0; i < tasks.size(); i++) {
					str += "<tr class='" + tasks.get(i).getStatus() + "'>" + "<th scope='row'>"
							+ "<a href='http://localhost:8080/MyDO_ES/task.jsp?id_task=" + tasks.get(i).getId_task()
							+ "'>"
							+ "<button target='_blank' class='btn'><img src='icons/icon-settings_24px.png'></button>"
							+ "</a>" + "</th>" + "<th scope='row'><a href='DeleteTask?id_task="
							+ tasks.get(i).getId_task()
							+ "'><button class='btn'><img src='icons/icon-trash_24px.png'></button></a></th>" + "<td>"
							+ tasks.get(i).getName() + "</td>" + "<td>" + tasks.get(i).getSubject() + "</td>" + "<td>"
							+ tasks.get(i).getDescription() + "</td>" + "<td>" + tasks.get(i).getType() + "</td>"
							+ "<td><div class='progress' style='height:38px;'><div class='progress-bar progress-bar-striped bg-success' role='progressbar' style='width:"
							+ selectPercentageOfProgress(tasks.get(i).getId_task())
							+ "%' aria-valuenow='25' aria-voluemin='0' aria-valuemax='100'></div></div></td>";
					String team_name = TeamCtrl.getInstance().selectNameTeamById(tasks.get(i).getId_team());
					str += "<td>" + team_name + "</td>";
				}
			}
		} else {
			str += "<th class='btn-primary text-center display-4' colspan='8'>No existen tareas</th>";
		}
		return str;
	}

	public String showFirstPartOfPercentageInTask(String id_task, Task selected_task) throws SQLException {
		String str = "";
		if (selectPercentageOfProgress(id_task) >= 100) {
			str += "Progreso: 100%";
			selected_task.setStatus("btn-success");
			update(selected_task);
		} else {
			str += "Progreso: " + selectPercentageOfProgress(id_task) + "%";
		}
		return str;
	}

	public String showSecondPartOfPercentageInTask(String id_task) throws SQLException {
		return "<div class='progress-bar progress-bar-striped bg-success' role='progressbar' style='width:"
				+ selectPercentageOfProgress(id_task)
				+ "%' aria-valuenow='25' aria-valuemin='0' aria-valuemax='100'></div>";
	}
	
	public String inputTypeTextForSubject(Task task) {
		return "<input type='text' class='form-control' value='" + task.getSubject() + "' name='_subject' required>";
	}
	
	public String textAreaForDescription(Task task) {
		return "<textarea class='form-control' id='_description' name='_description' rows='10' required>" + task.getDescription() + "</textarea>";
	}
	
	public String inputTypeTextForConsumedTime(Task task) {
		return "Tiempo consumido: <input type='number' class='form-control' value='" + task.getConsumed_time() + "' name='_estimated_time' required>";
	}
	
	public String inputTypeTextForEstimatedTime(Task task) {
		return "Tiempo estimado: <input type='number' class='form-control' value='" + task.getEstimated_time() + "' name='_estimated_time' required>";
	}
	
	public String showDeleteTaskButton(String id_task) {
		return "<a class='btn btn-danger' href='http://localhost:8080/MyDO_ES/DeleteTask?id_task=" + id_task + "'>Eliminar tarea</a><input type='hidden' name='_id_task' value='"+id_task+"'>";
	}

}




























