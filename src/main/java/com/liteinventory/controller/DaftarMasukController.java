package com.liteinventory.controller;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liteinventory.model.DaftarMasuk;
import com.liteinventory.service.DaftarMasukService;

@Controller
public class DaftarMasukController {

	private DaftarMasukService dmService;

	@Autowired
	public void setDmService(DaftarMasukService dmService) {
		this.dmService = dmService;
	}
	
	@RequestMapping(value = "daftarmasuk", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("daftarMasuks", dmService.listAllDaftarMasuk());
		
		return "daftarmasuk";
	}
	
	@RequestMapping("daftarmasuk/new")
	public String newDaftarMasuk(Model model) {
		model.addAttribute("daftarMasuk", new DaftarMasuk());
		
		return "daftarmasukform";
	}
	
	@RequestMapping("daftarmasuk/edit/{idMasuk}")
	public String edit(@PathVariable Long idMasuk, Model model) {
		model.addAttribute("daftarMasuk", dmService.getDaftarMasukById(idMasuk).get());
		
		return "daftarmasukform";
	}
	
	@RequestMapping(value = "daftarmasuk", method = RequestMethod.POST)
	public String save(@Valid DaftarMasuk daftarMasuk, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			return "daftarmasukform";
		}					
		
		if (daftarMasuk.getIdMasuk() == -1) {
			// Hardcoded for temporary
			daftarMasuk.setIdPerusahaan("1");
			daftarMasuk.setServerDatetime(new Timestamp(System.currentTimeMillis()));
		}
		
		dmService.save(daftarMasuk);
		
		return "redirect:/daftarmasuk";
	}
	
	@RequestMapping("daftarmasuk/delete/{idMasuk}")
	public String delete(@PathVariable Long idMasuk) {
		
		dmService.delete(idMasuk);
		
		return "redirect:/daftarmasuk";
	}
}
