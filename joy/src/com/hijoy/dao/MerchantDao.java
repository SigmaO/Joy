package com.hijoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.hijoy.object.Merchant;
import com.hijoy.utilcommon.Base64Encoder;

public class MerchantDao {

	public String insertNewMerchant(Merchant m) {
		String id = "";
		Connection conn = DataBaseDao.getConnection();
		if (conn == null) {
			System.out.println("con is null");
		}
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into merchant(password,email,telephone,name,addressline1,addressline2,addressline3,state,city,district,province,area,registertime) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, m.getPassword());
            ps.setString(2, m.getEmail());
            ps.setString(3, m.getTelephone());
            ps.setString(4, m.getName());
            ps.setString(5, m.getAddressLine1());
            ps.setString(6, m.getAddressLine2());
            ps.setString(7, m.getAddressLine3());
            ps.setInt(8, m.getVerified());
            ps.setString(9, m.getCity());
            ps.setString(10, m.getDistrict());
            ps.setString(11, m.getProvince());
            ps.setString(12, m.getArea());

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ps.setString(13,df.format(new Date()));

            ps.execute();
            ps = conn.prepareStatement("select @@identity as id");
			ResultSet rs = ps.executeQuery();
			rs.next();
			id = rs.getString("id");

			//System.out.println(id);
            ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return id;
	}

	public ResultSet getMerchant(String merchantId) {
		Connection conn = DataBaseDao.getConnection();
		String query = "select * from merchant where id=" + merchantId;
		
		ResultSet rs = null;
		if (conn == null) {
			System.out.println("con is null");
		}
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

    public String generateEmailVerificationCode(String merchantId){
        Long randomNum = (long)(Math.random()*System.currentTimeMillis());
        String str = merchantId+"joy"+randomNum.toString();
        System.out.println(str+"--"+System.currentTimeMillis());
        Connection conn = DataBaseDao.getConnection();
        String sql = "Insert into Merchant_Verification_Code(MerchantId,VerificationCode,RequestTime) values (?,?,?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,merchantId);
            ps.setString(2,str);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ps.setString(3,df.format(new Date()));
            ps.execute();
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return Base64Encoder.Base64.encodeToString(str);
    }

    public String getMerchantIdByVerificationCode(String code){
        String merchantId = "";
        Connection conn = DataBaseDao.getConnection();
        System.out.println(code+"----");
        System.out.println(Base64Encoder.Base64.decodeToString(code));
        String sql = "SELECT MerchantID from Merchant_Verification_Code where VerificationCode='"
                    + Base64Encoder.Base64.decodeToString(code) + "' order by RequestTime Desc limit 1";
        System.out.println(sql);
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            merchantId = rs.getString("MerchantID");
            ps.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return merchantId;
    }
}
