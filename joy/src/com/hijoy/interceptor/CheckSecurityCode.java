package com.hijoy.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * Created by vincent on 14-9-14.
 */
public class CheckSecurityCode implements Interceptor {

    @Override
    public void destroy() {
        System.out.println("------CheckSecurityCode.destroy------");
    }

    @Override
    public void init() {
        System.out.println("------CheckSecurityCode.init------");

    }

    //Struts2中Map类型的session
    private Map<String, Object> session;
    //接收客户端传来的验证码
    private String securityCode;

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map paramMap =actionInvocation.getInvocationContext().getParameters();
        securityCode = ((String[])paramMap.get("web.securityCode"))[0];
        Map session=ActionContext.getContext().getSession();
        session.put("MERCHANT_NAME",((String[])paramMap.get("merchant.name"))[0]);
        session.put("MERCHANT_EMAIL",((String[])paramMap.get("merchant.email"))[0]);
        String serverCode = session.get("SESSION_SECURITY_CODE").toString();
        if(!serverCode.equals(securityCode)){
            System.out.println(securityCode+"----");
            session.remove("SESSION_SECURITY_CODE");
            session.put("ERROR_MESSAGE","验证码错误");
            return "fail";
        }

        return actionInvocation.invoke();
    }


}
