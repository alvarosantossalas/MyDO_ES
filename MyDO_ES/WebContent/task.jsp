<%@page import="com.mydo.utilities.structure.Head"%>
<%@page import="com.mydo.utilities.structure.FooterWith"%>
<%@page import="com.mydo.utilities.structure.HeaderWith"%>
<%@page import="com.mydo.utilities.structure.HeaderWithout"%>
<%@ page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.mydo.controller.TeamCtrl"%>
<%@page import="com.mydo.controller.TaskCtrl"%>
<%@page import="com.mydo.controller.ProjectCtrl"%>
<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="com.mydo.core.model.User"%>
<%@page import="com.mydo.core.model.Task"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<%
	out.println(Head.getInstance().returnHead());
%>
</head>
<body>
	<%
		if ((String) session.getAttribute("id_user") != null) {
			String id_user_logado = (String) session.getAttribute("id_user");
			System.out.println("ID user_logado en task: " + id_user_logado);

			String id_task = request.getParameter("id_task");
			Task selected_task = TaskCtrl.getInstance().listById(id_task);
			out.println(HeaderWith.getInstance().returnHeaderWithLogin());
	%>
	<div class="jumbotron text-light"
		style="background: url(images/partearriba.PNG);">
		<div class="container"></div>
	</div>
	<form action="UpdateTask" method="POST">
		<div id="centro-registro" class="text-center">
			<div id="task_board" class="container text-left">
				<% out.println("<p class='display-4'>" + selected_task.getName() + "</p>");	%>
				<dl class="row">
					<dt class="col-sm-2">Asunto</dt>
					<dd class="col-sm-12">
						<% out.println(TaskCtrl.getInstance().inputTypeTextForSubject(selected_task)); %>
					</dd>
					<dt class="col-sm-2">Descripción</dt>
					<dd class="col-sm-12">
					<% out.println(TaskCtrl.getInstance().textAreaForDescription(selected_task)); %>
					</dd>
					<dt class="col-sm-2">Tipo de tarea</dt>
					<dd class="col-sm-2">
						<select class="form-control" name="_type">
							<% out.println(TaskCtrl.getInstance().returnValueOfTypeForSelectedTask(selected_task)); %>
						</select>
					</dd>
					<dt class="col-sm-2 text-truncate">Equipo responsable:</dt>
					<dd class="col-sm-2">
						<select class="form-control" name="_team">
							<% out.println(TeamCtrl.getInstance().showResponsibleTeamForATask(id_user_logado, selected_task)); %>
						</select>
					</dd>
					<dt class="col-sm-1">Estado</dt>
					<dd class="col-sm-3">
						<select class="form-control" name="_status">
							<% out.println(TaskCtrl.getInstance().returnValueOfStatusForSelectedTask(selected_task)); %>
						</select>
					</dd>
					<dt class="col-sm-2">Horas consumidas</dt>
					<dd class="col-sm-3">
						<% out.println(TaskCtrl.getInstance().inputTypeTextForConsumedTime(selected_task)); %>
					</dd>
					<dd class="col-sm-3">
						<% out.println(TaskCtrl.getInstance().inputTypeTextForEstimatedTime(selected_task)); %>
					</dd>
					<dd class="col-sm-4">
						<% out.println(TaskCtrl.getInstance().showFirstPartOfPercentageInTask(id_task, selected_task)); %>
						<div class="progress" style="height: 38px;">
							<% out.println(TaskCtrl.getInstance().showSecondPartOfPercentageInTask(id_task)); %>
						</div>
					</dd>
					<br><br><br><br>
					<dt class="col-sm-2">En proyecto:</dt>
					<% out.println(ProjectCtrl.getInstance().showProjectsWhereTaskExistIn(id_user_logado)); %>
					<br><br><br>
				</dl>
			</div>
		</div>
		<div class="btn-group text-center" role="group"
			style="margin-left: 40%">
			<% out.println(TaskCtrl.getInstance().showDeleteTaskButton(id_task)); %>
			<input type="submit" class="btn btn-success" value="Guardar cambios">
		</div>
	</form>
	<br>
	<section id="info" style="background: url(images/pruebaabajo.PNG);">
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para tí</p>
	</section>
	<% out.println(FooterWith.getInstance().returnFooterWithLogin()); %>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<%
		} else {
			session.invalidate();
			System.out.println("La sesión ha sido invalidada en board.jsp");
			response.sendRedirect("error403.html");
		}
	%>
</body>
</html>