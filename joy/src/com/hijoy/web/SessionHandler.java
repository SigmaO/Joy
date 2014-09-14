package com.hijoy.web;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
/**
 * Created by vincent on 14-9-14.
 */
public class SessionHandler {
    private Map session;
    public String getSessionOnce(String name){
        String tmpSession = getSession(name);
        removeSession(name);
        return tmpSession;
    }
    public String getSession(String name){
        session = ActionContext.getContext().getSession();
        if(session.get(name)==null){
            return "";
        }else {
            return session.get(name).toString();
        }
    };

    public void removeSession(String name){
        String tmpSession = getSession(name);
        if(tmpSession+""!="")session.remove(name);
    }
}
