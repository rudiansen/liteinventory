package com.liteinventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liteinventory.model.KategoriBarang;
import com.liteinventory.service.KategoriBarangService;

@Controller
public class KategoriBarangController {

	private KategoriBarangService kbService;

	@Autowired
	public void setKbService(KategoriBarangService kbService) {
		this.kbService = kbService;
	}
	
	@RequestMapping(value = "jenisbarang", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("jenisbarangs", kbService.listAllKategoriBarang());
		
		return "jenisbarang";
	}
	
	@RequestMapping("jenisbarang/edit/{kdKategori}")
	public String edit(@PathVariable String kdKategori, Model model) {
		model.addAttribute("kategoriBarang", kbService.getKategoriBarangById(kdKategori));
		
		return "jenisbarangform";
	}
	
	@RequestMapping("jenisbarang/new")
	public String newKategoriBarang(Model model) {
		model.addAttribute("kategoriBarang", new KategoriBarang());
		
		return "jenisbarangform";
	}
	
	@RequestMapping(value = "jenisbarang", method = RequestMethod.POST)
	public String save(@Valid KategoriBarang kategoriBarang, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			return "jenisbarangform";
		}
		
		kbService.save(kategoriBarang);
		
		return "redirect:/jenisbarang";
	}
	
	@RequestMapping("jenisbarang/delete/{kdKategori}")
	public String delete(@PathVariable String kdKategori) {
		kbService.delete(kdKategori);
		
		return "redirect:/jenisbarang";
	}
}
