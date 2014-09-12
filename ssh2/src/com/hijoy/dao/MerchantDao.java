package com.hijoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hijoy.object.Merchant;

public class MerchantDao {
	private Connection con;
	private PreparedStatement pt;
	private ResultSet rs;

	public int insertNewMerchant(Merchant m) {
		int status = 0;
		con = DataBaseDao.getConnection();
		try {
			pt = con.prepareStatement("insert into merchant(id,password,email,telephone,name,addressline1,addressline2,addresssline3,verified,city,district,province,area) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pt.setString(1, m.getId());
			pt.setString(1, m.getPassword());
			pt.setString(3, m.getEmail());
			pt.setString(4, m.getTelephone());
			pt.setString(5, m.getName());
			pt.setString(6, m.getAddressLine1());
			pt.setString(7, m.getAddressLine2());
			pt.setString(8, m.getAddressLine3());
			pt.setInt(9, m.getVerified());
			pt.setString(10, m.getCity());
			pt.setString(11, m.getDistrict());
			pt.setString(12, m.getProvince());
			pt.setString(13, m.getArea());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
