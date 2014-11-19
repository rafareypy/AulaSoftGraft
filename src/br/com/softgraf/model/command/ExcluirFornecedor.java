package br.com.softgraf.model.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.softgraf.model.bean.*;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;

public class ExcluirFornecedor implements InterfaceCommand{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) 
	{
		DAO<Fornecedor> fornecedorDAO = new DAOImpl<Fornecedor>(Fornecedor.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
		
		Integer codigo = Integer.valueOf(request.getParameter("codigo"));
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodigo(codigo);
		fornecedorDAO.excluir(fornecedor);
		request.setAttribute("mensagem", "Fornecedor exclu�do com sucesso.");
		return "SoftgrafController?cmd=consultarFornecedor";
	}
}
