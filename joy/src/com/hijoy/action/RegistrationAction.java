package com.hijoy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hijoy.utilcommon.Base64Encoder;
import com.hijoy.utilcommon.Email;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.hijoy.dao.MerchantDao;
import com.hijoy.object.Merchant;
import com.opensymphony.xwork2.ActionSupport;

public class RegistrationAction extends ActionSupport {
	private Merchant merchant;
	public String redirPage;

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
		String merchantId = merchantDao.insertNewMerchant(merchant);

        //send verifying email
        Email email = new Email();
        email.setHostName("smtp.163.com");
        email.setSource("hijoy2014@163.com");
        email.setPassword("hijoygogogo");
        email.setDestination(merchant.getEmail());
        email.setTitle("Welcome from HiJoy");
        email.setContent("<HTML>"+merchant.getName()+"的商家，您好"
                + ": 欢迎加入HiJoy，请点击下面的链接完成验证：<br />"
                + " <a href='http://localhost:8080/merchant/validateAccount?VC="+merchantDao.generateEmailVerificationCode(merchantId)
                + "'>创建您的账户</a></HTML>");
        email.send();

        //return to page
		if (!merchantId.equals(""))
            redirPage = "/signupSuccess.jsp?MerchantID=" + merchantId;
		else
            redirPage = "/fail.jsp";
		return "success";
	}

}
