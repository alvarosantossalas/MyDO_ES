package com.mydo.core.dao;

import com.mydo.core.model.Notify;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotifyDAO {

	// Variable that will be used throughout the program to manage queries in the
	// database
	private static String query;

	private Connection con = null;
	private static NotifyDAO instance = null;

	// Method that returns the database connection
	public NotifyDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	// Create an instance of the class NotifyDAO
	public static NotifyDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new NotifyDAO();
		}
		return instance;
	}

	// Insert simple Notify object in the database
	public void insert(Notify notify) throws SQLException {
		query = "INSERT INTO tfg_notify (_id_notify, _title, _message, _image) VALUES (?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, notify.getId_notify());
			ps.setString(2, notify.getTitle());
			ps.setString(3, notify.getMessage());
			ps.setString(4, notify.getImage());
			ps.executeUpdate();
			ps.close();
		}
	}

	// This method list all the existing Notify objects in the database
	public ArrayList<Notify> listAll() throws SQLException {
		query = "SELECT * FROM tfg_notify;";
		ArrayList<Notify> result;
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				result.add(new Notify(rs.getString("_id_notify"), rs.getString("_title"), rs.getString("_message"),
						rs.getString("_image")));
			}
		}
		return result;
	}

	// List Notify object by id_notify
	public Notify listById(String id_notify) throws SQLException {
		query = "SELECT * FROM tfg_notify WHERE _id_notify = ?;";
		Notify result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_notify);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = new Notify(rs.getString("_id_notify"), rs.getString("_title"), rs.getString("_message"),
							rs.getString("_image"));
				}
			}
		}
		return result;
	}

	// Remove Notify object in the database
	public void remove(Notify notify) throws SQLException {
		remove(notify.getId_notify());
	}

	// Remove Notify object in the database by id_notify
	public void remove(String id_notify) throws SQLException {
		if ("".equals(id_notify)) {
			return;
		}
		query = "DELETE FROM tfg_notify WHERE _id_notify  = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_notify);
			ps.executeUpdate();
		}
	}

	// Update a Notify object in the database
	public void update(Notify notify) throws SQLException {
		if ("".equals(notify.getId_notify())) {
			return;
		}
		query = "UPDATE tfg_notify SET _id_notify=?, _title=?, _message=?, _image=? WHERE _id_notify=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, notify.getId_notify());
			ps.setString(2, notify.getTitle());
			ps.setString(3, notify.getMessage());
			ps.setString(4, notify.getImage());
			ps.setString(5, notify.getId_notify());
			ps.executeUpdate();
			ps.close();
		}
	}

}
