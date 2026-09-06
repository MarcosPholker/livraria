package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;

@RestController
public class ProdutoController {
	
	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@PostMapping("/produtos")
	public Produto addProduto(@RequestBody Produto produto) {
		return produtoService.addProduto(produto);
	}
	
	@GetMapping("/produtos")
	public List<Produto> listarProdutos() {
		return produtoService.listarProduto();
	}
	
	@PutMapping("/produtos/{id}")
	public Produto atualizarProduto(@PathVariable Long id,@RequestBody Produto produto) {
		return produtoService.atualizarProduto(id, produto);
	}
	
	@DeleteMapping("/produtos/{id}")
	public Long deletarProduto(@PathVariable Long id) {
		return produtoService.deletarProduto(id);
	}
	
	@GetMapping("/produtos/{id}")
	public Produto encontrarProduto(@PathVariable Long id) {
		return produtoService.encontrarProduto(id);
	}
	
}
