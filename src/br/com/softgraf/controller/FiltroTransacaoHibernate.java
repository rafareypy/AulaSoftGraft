package br.com.softgraf.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import br.com.softgraf.util.HibernateUtil;

public class FiltroTransacaoHibernate implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException,
			ServletException {
			Session session = null;
			
		try {
			String cmd = request.getParameter("cmd");	
			session = HibernateUtil.getSessionfactory().openSession();
			session.beginTransaction();
			
			
			((HttpServletRequest)request).setAttribute(HibernateUtil.HIBERNATE_SESSION, session);
			
			fc.doFilter(request, response);
			session = (Session)((HttpServletRequest)request).getAttribute(HibernateUtil.HIBERNATE_SESSION);
			session.flush();
			session.getTransaction().commit();
			session.close();
			} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			}finally{
			//session.close();
			}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
