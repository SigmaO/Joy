package com.hijoy.action;

import com.hijoy.dao.MerchantDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by vincent on 14-9-15.
 */
public class EmailVerificationAction extends ActionSupport {
    private String VC;
    public String redirPage;
    public String getVC()
    {
        return VC;
    }
    public void setVC(String verificationCode)
    {
        this.VC = verificationCode;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        MerchantDao merchantDao = new MerchantDao();
        System.out.println("abc");
        String merchantId = merchantDao.getMerchantIdByVerificationCode(VC);
        System.out.println(merchantId);
        //return to page
        if (!merchantId.equals("")){
            redirPage = "/signupSuccess.jsp?MerchantID=" + merchantId;}
        else
            redirPage = "/fail.jsp";
        return "success";
    }
}
