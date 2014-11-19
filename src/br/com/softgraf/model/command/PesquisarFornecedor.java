package br.com.softgraf.model.command;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import br.com.softgraf.model.bean.Fornecedor;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;


public class PesquisarFornecedor implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Fornecedor fornecedor = new Fornecedor();
		try {
			BeanUtils.populate(fornecedor, request.getParameterMap());
			DAO<Fornecedor> fornecedorDAO = new DAOImpl<Fornecedor>(Fornecedor.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
			List<Fornecedor> fornecedores;
			if(request.getParameter("criteria") != null)
			{
				fornecedores = ((DAOImpl) fornecedorDAO).getFornecedoresSemEstado();
				request.setAttribute("fornecedores", fornecedores);				
				return "consulta_fornecedor.jsp";
			}
			else if(request.getParameter("hql") != null)
			{
				fornecedores = ((DAOImpl) fornecedorDAO).getFornecedoresSemProdutoHQL();
				request.setAttribute("fornecedores", fornecedores);				
				return "consulta_fornecedor.jsp";
			}else
				fornecedores = fornecedorDAO.getBeansByExample(fornecedor);
			request.setAttribute("fornecedor", fornecedor);
			request.setAttribute("fornecedores", fornecedores);
			
		} catch (IllegalAccessException e) {
			request.setAttribute("mensagem", "Problemas com a consulta.");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			request.setAttribute("mensagem", "Problemas com a consulta.");
			e.printStackTrace();
		}
		return "consulta_fornecedor.jsp";
	}

}
