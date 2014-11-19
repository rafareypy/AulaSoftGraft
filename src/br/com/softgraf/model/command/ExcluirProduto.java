package br.com.softgraf.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.softgraf.model.bean.Produto;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;

public class ExcluirProduto implements InterfaceCommand{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		DAO<Produto> produtoDAO = new DAOImpl<Produto>(Produto.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
		Integer codigo = Integer.valueOf(request.getParameter("codigo"));
		Produto produto = produtoDAO.getBean(codigo);
		produtoDAO.excluir(produto);
		request.setAttribute("mensagem", "Produto exclu�do com sucesso: "+produto.getDescricao());
		return "SoftgrafController?cmd=consultarProduto";
	}
}
