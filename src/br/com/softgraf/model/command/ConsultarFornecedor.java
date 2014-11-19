package br.com.softgraf.model.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.softgraf.model.bean.*;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;

public class ConsultarFornecedor implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		DAO<Fornecedor> fornecedorDAO = new DAOImpl<Fornecedor>(Fornecedor.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
		List<Fornecedor> fornecedores = fornecedorDAO.getBeans();
		request.setAttribute("fornecedores", fornecedores);
		return "consulta_fornecedor.jsp";
	}

}
