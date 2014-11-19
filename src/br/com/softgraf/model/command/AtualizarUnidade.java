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


public class AtualizarUnidade implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Unidade unidade = new Unidade();
		
		try {
			BeanUtils.populate(unidade, request.getParameterMap());
			if(unidade.isValido())
			{
				DAO<Unidade> unidadeDAO = new DAOImpl<Unidade>(Unidade.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));

				unidadeDAO.atualizar(unidade);
				request.setAttribute("mensagem", "Unidade atualizada com sucesso.");
			}else if (request.getMethod().equalsIgnoreCase("post")) {
				request.setAttribute("unidade", unidade);
				request.setAttribute("mensagem", "Preencha os campos obrigat�rios.");
				return "atualiza_unidade.jsp";
			}else{
				DAO<Unidade> unidadeDAO = new DAOImpl<Unidade>(Unidade.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
				Integer codigo = Integer.valueOf(request.getParameter("codigo"));
				request.setAttribute("unidade", unidadeDAO.getBean(codigo));
				return "atualiza_unidade.jsp";
			}
		} catch (IllegalAccessException e) {
			request.setAttribute("mensagem", "Problemas com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			request.setAttribute("mensagem", "Problemas com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
		}
		return "SoftgrafController?cmd=consultarUnidade";
	}
}
