package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Produto;

@Service
public class ProdutoService {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public ProdutoService() {
		produtos.add(new Produto(1L, "teclado", 150.00));
		produtos.add(new Produto(2L, "mouse", 150.00));
		produtos.add(new Produto(3L, "celular", 150.00));
		produtos.add(new Produto(4L, "mesa Gamer", 150.00));
		produtos.add(new Produto(4L, "Notebook", 150.00));
	}

	public List<Produto> listarProduto() {
		return produtos;
	}
	
	public Produto atualizarProduto(Long id, Produto produto){
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getId().equals(id)) {
				produto.setId(id);
				produtos.set(i, produto);
				
				return produto;
				
			}
		} 
		
		return null;
	}
	
	public Long deletarProduto(Long id) {
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getId().equals(id)) {
				produtos.remove(i);
				return id;
			}
		}
		return null;
	}

	public Produto addProduto(Produto produto) {
		produtos.add(produto);
		return produto;
	}

	public Produto encontrarProduto(Long id) {
		for(int i = 0; i < produtos.size(); i++) {
			if(produtos.get(i).getId().equals(id)) {
				return produtos.get(i);
			}
		}
		return null;
	}
}