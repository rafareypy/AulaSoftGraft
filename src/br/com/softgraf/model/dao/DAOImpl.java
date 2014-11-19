package br.com.softgraf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.softgraf.model.bean.*;
import br.com.softgraf.util.HibernateUtil;

public class DAOImpl<T> implements DAO<T> {

	private Class<T> classe;
	private Session session;
	
	public DAOImpl(Class<T> classe,Session session)
	{
		super();
		this.classe = classe;
		this.session = session;
				
	}
	
	@Override
	public void salvar(T bean) {
		session.save(bean);
		
		
	}

	@Override
	public void atualizar(T bean) {
		session.update(bean);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(T bean) {
		session.delete(bean);
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getBean(Serializable codigo) {
		T bean = (T)session.get(classe, codigo);
		
		return bean;
		
	}

	@Override
	public List<T> getBeans() {
		List<T> beans= (List<T>)session.createCriteria(classe).list();
		
		return beans;
		
	}
	
	public Funcionario getFuncionario(String login, String senha){
		
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		
		return getFuncionarioToCriteria(login, senha);
	
				
	}
	public Funcionario getFuncionarioToCriteria(String login, String senha)
	{	
		
		Criteria criteria = session.createCriteria(Funcionario.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("senha", senha));
		
		List<Funcionario> lista = (List<Funcionario>)criteria.list();

		for (Funcionario funcionario : lista) {
			System.out.println("Funcionario encontrado");
			System.out.println(funcionario.toString());
		}
		
		if (lista == null || lista.size() <= 0){
			return null;
			
		}else {
			return lista.get(0);
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	public List<Fornecedor> getFornecedoresSemProdutoHQL()
	{
		String hql = "from Fornecedor f where f.codigo not in (select fornecedor.codigo from Produto)";
		return (List<Fornecedor>) session.createQuery(hql).list();
	}
	
	public List<Fornecedor> getFornecedoresSemEstado()
	{
		Criteria criteria = session.createCriteria(Fornecedor.class);
		criteria.add(Restrictions.or(Restrictions.isNull("estado"),Restrictions.eq("estado", "")));
		return (List<Fornecedor>)criteria.list();
	}

	@Override	
	public List<T> getBeansByExample(T bean) {
		Example example = Example.create(bean);
		example.enableLike(MatchMode.ANYWHERE);
		example.ignoreCase();
		return session.createCriteria(classe).add(example).list();
	}
	

}
