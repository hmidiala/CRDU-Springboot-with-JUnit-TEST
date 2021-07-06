package com.example.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Produit;
import com.example.demo.repos.ProduitRepository;

@SpringBootTest
class ProductApplicationTests {

	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC Dell",2200.500, new Date());
		Produit prod2 = new Produit("PC HP",2800.0, new Date());

		produitRepository.save(prod);
		produitRepository.save(prod2);

	}
	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(2L).get();
		System.out.println(p);
		
	}
	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(2L).get();
		p.setPrixProduit(3500.0);
		produitRepository.save(p);
		System.out.println(p);
		
	}
	@Test
	public void testDeleteProduit() {
		
		produitRepository.deleteById(1L);
		//produitRepository.deleteAll();

	}
	@Test
	public void testShowProduit() {
		
		List<Produit> pr = produitRepository.findAll();
		for(Produit p:pr)
			System.out.println(p);

	}
}
