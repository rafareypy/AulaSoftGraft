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


public class CadastrarUnidade implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Unidade unidade = new Unidade();
		try {
			BeanUtils.populate(unidade, request.getParameterMap());
			if(unidade.isValido())
			{
				DAO<Unidade> unidadeDAO = new DAOImpl<Unidade>(Unidade.class, (Session) request.getAttribute(HibernateUtil.HIBERNATE_SESSION));
				unidadeDAO.salvar(unidade);
				request.setAttribute("mensagem", "Unidade cadastrada com sucesso: "+unidade.getDescricao());
			}else
				request.setAttribute("mensagem", "Preencha os campos obrigat�rios");
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

		return "cadastro_unidade.jsp";
	}

}
