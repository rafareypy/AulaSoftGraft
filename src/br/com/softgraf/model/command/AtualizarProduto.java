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



public class AtualizarProduto implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Produto produto = null;
		try {
			DAO<Produto> produtoDAO = new DAOImpl<Produto>(Produto.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
			produto = produtoDAO.getBean(Integer.valueOf(request.getParameter("codigo")));
			BeanUtils.populate(produto, request.getParameterMap());
			DAO<Fornecedor> fornecedorDAO = new DAOImpl<Fornecedor>(Fornecedor.class, (Session)request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
			request.setAttribute("fornecedores", fornecedorDAO.getBeans());
			DAO<Unidade> unidadeDAO = new DAOImpl<Unidade>(Unidade.class, (Session)request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
			request.setAttribute("unidades", unidadeDAO.getBeans());
			if(request.getMethod().equalsIgnoreCase("post"))
			{
				produto.setUnidade(unidadeDAO.getBean(Integer.valueOf(request.getParameter("unidade_codigo"))));
				produto.setFornecedor(fornecedorDAO.getBean(Integer.valueOf(request.getParameter("fornecedor_codigo"))));
				request.setAttribute("mensagem", "Preencha os campos obrigat�rios");				
			}
			request.setAttribute("produto", produto);
			if(produto.isValido() && request.getMethod().equalsIgnoreCase("post"))
			{
				produtoDAO.atualizar(produto);
				request.setAttribute("mensagem", "Produto atualizado com sucesso: "+produto.getDescricao());
			}
		} catch (IllegalAccessException e) {
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean: "+e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean: "+e.getMessage());			
			e.printStackTrace();
		}catch (org.apache.commons.beanutils.ConversionException e)
		{
			request.setAttribute("mensagem", "Problemas com preenchimento do Bean: "+e.getMessage());			
			e.printStackTrace();
		}catch(Exception e)
		{
			request.setAttribute("mensagem", "Problemas com a grava��o: "+e.getMessage());			
			e.printStackTrace();
		}
		return "atualiza_produto.jsp";
	}
}
