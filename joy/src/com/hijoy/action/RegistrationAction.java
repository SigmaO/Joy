package com.hijoy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.hijoy.dao.MerchantDao;
import com.hijoy.object.Merchant;
import com.opensymphony.xwork2.ActionSupport;

public class RegistrationAction extends ActionSupport {
	private Merchant merchant;
	public String jumpPage;

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant mer) {
		this.merchant = mer;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		MerchantDao merchantDao = new MerchantDao();
		String ret = merchantDao.insertNewMerchant(merchant);
		if (!ret.equals(""))
			jumpPage = "/signupSuccess.jsp?MerchantID=" + ret;
		else
			jumpPage = "/fail.jsp";
		return "success";
	}

}
