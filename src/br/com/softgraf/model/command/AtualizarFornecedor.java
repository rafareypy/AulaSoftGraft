package br.com.softgraf.model.command;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import br.com.softgraf.model.bean.*;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;


public class AtualizarFornecedor implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Fornecedor fornecedor = new Fornecedor();
		
		try {
			BeanUtils.populate(fornecedor, request.getParameterMap());
			if(fornecedor.isValid())
			{
				DAO<Fornecedor> fornecedorDAO = new DAOImpl<Fornecedor>(Fornecedor.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
				fornecedorDAO.atualizar(fornecedor);
				request.setAttribute("mensagem", "Fornecedor atualizado com sucesso.");
			}else if (request.getMethod().equalsIgnoreCase("post")) {
				request.setAttribute("fornecedor", fornecedor);
				request.setAttribute("mensagem", "Preencha os campos obrigat�rios.");
				return "atualiza_fornecedor.jsp";
			}else{
				DAO<Fornecedor> fornecedorDAO = new DAOImpl<Fornecedor>(Fornecedor.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
				Integer codigo = Integer.valueOf(request.getParameter("codigo"));
				request.setAttribute("fornecedor", fornecedorDAO.getBean(codigo));
				return "atualiza_fornecedor.jsp";
			}
		} catch (IllegalAccessException e) {
			request.setAttribute("mensagem", "Problemas com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			request.setAttribute("mensagem", "Problemas com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
		}
		return "SoftgrafController?cmd=consultarFornecedor";
	}
}
