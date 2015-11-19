package com.view.action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.controller.ValidaUsuario;
import com.view.form.LoginForm;

public class LoginAction extends Action {
	
	public LoginAction() {
		super();
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		HttpSession session = request.getSession(false);

        String target = null;
        LoginForm loginForm = (LoginForm) form;
        ValidaUsuario valida = new ValidaUsuario();
            
        if( valida.valida(loginForm.getUserName(), loginForm.getPassword()) ){
        	
            request.setAttribute("message", loginForm.getPassword());
            target = "Config";
            
            //Agrega el usuario a la session.
            session = request.getSession(true);
            session.setAttribute("usuario", valida.getUsuario());
        	
        } else {
        	session.invalidate();
            target = "Fail";
        }
        
         
        return mapping.findForward(target);
    }
	
	
	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {

	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
	}

}
