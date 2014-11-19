package br.com.softgraf.model.helper;

import br.com.softgraf.model.command.*;
import br.com.softgraf.model.command.InterfaceCommand;

import javax.servlet.http.HttpServletRequest;

import  br.com.softgraf.model.command.CadastrarFornecedor;

import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class SoftGrafHelper {
    
    private HttpServletRequest request;
    
    public SoftGrafHelper (HttpServletRequest request){
        super();
        this.request = request;
    }
    
    public InterfaceCommand getCommnand()
    {
    	
        String cmd = request.getParameter("cmd");
        System.out.println("Cmd passo = "+ cmd);
        if (cmd == null ) {
            return new AcessarUsuario();
        }
        else if (cmd.equals("iniciarSoftgraf"))
        {        
            return new CadastrarFornecedor();
            
        }
        else if(cmd.equals("acessarUsuario")) 
        {        	
            return new AcessarUsuario();
        }
        else if(cmd.equals("cadastrarFornecedor"))
        {        
        	return new CadastrarFornecedor();
    	}
        
        if(cmd.equals("cadastrarFornecedor"))
			return new CadastrarFornecedor();
		if(cmd.equals("consultarFornecedor"))
			return new ConsultarFornecedor();
		if(cmd.equals("excluirFornecedor"))
			return new ExcluirFornecedor();
		if(cmd.equals("atualizarFornecedor"))
			return new AtualizarFornecedor();
		if(cmd.equals("cadastrarUnidade"))
			return new CadastrarUnidade();
		if(cmd.equals("consultarUnidade"))
			return new ConsultarUnidade();
		if(cmd.equals("excluirUnidade"))
			return new ExcluirUnidade();
		if(cmd.equals("atualizarUnidade"))
			return new AtualizarUnidade();
		if(cmd.equals("cadastrarProduto"))
			return new CadastrarProduto();
		if(cmd.equals("consultarProduto"))
			return new ConsultarProduto();
		if(cmd.equals("excluirProduto"))
			return new ExcluirProduto();
		if(cmd.equals("atualizarProduto"))
			return new AtualizarProduto();
		if(cmd.equals("pesquisarFornecedor"))
			return new PesquisarFornecedor();        
        
        
		return new AcessarUsuario();
          
                
    }
    
    
    
}
