package com.hijoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hijoy.object.Merchant;
import com.hijoy.utilcommon.SendEmail;

public class MerchantDao {

	public String insertNewMerchant(Merchant m) {
		String id = "ok";
		Connection con = DataBaseDao.getConnection();
		if (con == null) {
			System.out.println("con is null");
		}
		try {
			PreparedStatement pt = con
					.prepareStatement("insert into merchant(password,email,telephone,name,addressline1,addressline2,addressline3,verified,city,district,province,area) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			pt.setString(1, m.getPassword());
			pt.setString(2, m.getEmail());
			pt.setString(3, m.getTelephone());
			pt.setString(4, m.getName());
			pt.setString(5, m.getAddressLine1());
			pt.setString(6, m.getAddressLine2());
			pt.setString(7, m.getAddressLine3());
			pt.setInt(8, m.getVerified());
			pt.setString(9, m.getCity());
			pt.setString(10, m.getDistrict());
			pt.setString(11, m.getProvince());
			pt.setString(12, m.getArea());
			pt.execute();
			pt = con.prepareStatement("select @@identity as id");
			ResultSet rs = pt.executeQuery();
			rs.next();
			id = rs.getString("id");
			SendEmail se = new SendEmail();
			se.setHostName("smtp.163.com");
			se.setSource("hijoy2014@163.com");
			se.setPassword("hijoygogogo");
			se.setDestination(m.getEmail());
			se.setTitle("Welcome from HiJoy");
			se.setContent("Hi," + m.getName()
					+ ": welcome to join HiJoy, enjoy your time");
			se.send();

			System.out.println(id);
			pt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return id;
	}

	public ResultSet getMerchant(String id) {
		Connection con = DataBaseDao.getConnection();
		String query = "select * from merchant where id=" + id;
		
		ResultSet rs = null;
		if (con == null) {
			System.out.println("con is null");
		}
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
