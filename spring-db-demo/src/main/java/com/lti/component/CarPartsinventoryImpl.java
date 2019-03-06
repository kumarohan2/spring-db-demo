package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CarPartsinventoryImpl implements CarPartInventory{
	Connection conn = null;
	PreparedStatement stmt = null;

	public void addNewPart(CarPart carPart) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			String sql = "insert into TBL_CARPART values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, carPart.getPartNo());
			stmt.setString(2, carPart.getName());
			stmt.setString(3, carPart.getCarModel());
			stmt.setInt(4, carPart.getStock());
			stmt.executeUpdate();
		}

		catch (ClassNotFoundException | SQLException e) {

			throw new CarPartsInventoryException("problem in addNewPart method", e);

		} finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
		
		
		
		
		
		
	}

	@Override
	public List<CarPart> getAvailableParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStock(int partNo, int quantity) {
		// TODO Auto-generated method stub
		
	}
}

/*
 * public List<CarPart> getAvailableParts() { try {
 * Class.forName("oracle.jdbc.driver.OracleDriver"); conn =
 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr",
 * "Newuser123"); String sql = "select * from TBL_CARPART where stock > 1";
 * 
 * stmt = conn.prepareStatement(sql);
 * 
 * }
 * 
 * catch (Exception e) { // bad, should catch individual exception(s)
 * e.printStackTrace(); // very bad, should throw user defined exception instead
 * 
 * } finally { try { rs.close(); } catch (Exception e) { } try { stmt.close(); }
 * catch (Exception e) { } try { conn.close(); } catch (Exception e) { }
 */
