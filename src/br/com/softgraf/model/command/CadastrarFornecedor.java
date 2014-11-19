
package br.com.softgraf.model.command;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import br.com.softgraf.model.bean.*;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class CadastrarFornecedor implements InterfaceCommand {

    public CadastrarFornecedor() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
    	Fornecedor fornecedor = new Fornecedor();
    	
    	try {
    		BeanUtils.populate(fornecedor, request.getParameterMap());
			
    
    		System.out.println(fornecedor.toString());
    		
    		if(fornecedor.isValid())
			{
    			DAO<Fornecedor> fornecedorDao = new DAOImpl<Fornecedor>(Fornecedor.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
    			fornecedorDao.salvar(fornecedor);
				request.setAttribute("mensagem", "Fornecedor gravado com sucesso: "+fornecedor.getNome());
			}else{
				System.out.println("falta dados");
				request.setAttribute("mensagem", "Preencha os campos obrigat�rios");
			}			
			
		} catch (IllegalAccessException e) {
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean");
			e.printStackTrace();
		
		}catch (InvocationTargetException e){
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean");
			e.printStackTrace();
		}
    	
    	
    
    	return "cadastra_fornecedor.jsp";
    }
    
}
