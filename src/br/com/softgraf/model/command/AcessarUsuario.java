/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.softgraf.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.softgraf.model.bean.Funcionario;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;

/**
 *
 * @author Usuario
 */
public class AcessarUsuario implements InterfaceCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
    
    	Funcionario usuario = null;
    	
    	DAOImpl<Funcionario> daoFuncionario = new DAOImpl<Funcionario>(Funcionario.class, (Session)request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
    	
		    	
    	
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    
    if(login == null) {
        return "login_usuario.jsp";                
    }
    
    usuario = daoFuncionario.getFuncionario(login, senha);
    
    if (usuario == null){
    	
    	return "login_usuario.jsp";
    	
    }else {    	    
    	//return "login_usuario.jsp";  
    	return "SoftgrafController?cmd=iniciarSoftgraf";
    
    }

}

    
}