package br.com.softgraf.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.com.softgraf.model.bean.Unidade;
import br.com.softgraf.model.dao.DAO;
import br.com.softgraf.model.dao.DAOImpl;
import br.com.softgraf.util.HibernateUtil;


public class ExcluirUnidade implements InterfaceCommand{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		DAO<Unidade> unidadeDAO = new DAOImpl<Unidade>(Unidade.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
		Integer codigo = Integer.valueOf(request.getParameter("codigo"));
		Unidade unidade = new Unidade();
		unidade.setCodigo(codigo);
		unidadeDAO.excluir(unidade);
		request.setAttribute("mensagem", "Unidade exclu�da com sucesso.");
		return "SoftgrafController?cmd=consultarUnidade";
	}
}
