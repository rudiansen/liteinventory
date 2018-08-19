package com.liteinventory.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liteinventory.model.Barang;
import com.liteinventory.service.BarangService;
import com.liteinventory.service.KategoriBarangService;
import com.liteinventory.service.SatuanService;

@Controller
public class BarangController {

	private BarangService barangService;
	private KategoriBarangService kbService;
	private SatuanService satService;

	@Autowired
	public void setBarangService(BarangService barangService) {
		this.barangService = barangService;
	}
	
	@Autowired
	public void setKbService(KategoriBarangService kbService) {
		this.kbService = kbService;
	}

	@Autowired
	public void setSatService(SatuanService satService) {
		this.satService = satService;
	}

	@RequestMapping(value = {"barang", "barang/{message}"}, method = RequestMethod.GET)
	public String list(@PathVariable Optional<String> message, Model model) {				
		model.addAttribute("barangs", barangService.listAllBarang());
		
		if (message.isPresent()) {
			switch (message.get()) {
				case "success":
					model.addAttribute("success_message", true);
					break;
				case "error":
					model.addAttribute("error_message", true);
					break;
				default:
					break;
			}
		}
		
		return "barang";
	}
	
	@RequestMapping("barang/edit/{kdBarang}")
	public String edit(@PathVariable String kdBarang, Model model) {
		model.addAttribute("barang", barangService.getBarangById(kdBarang));
		model.addAttribute("jenisbarangs", kbService.listAllKategoriBarang());
		model.addAttribute("satuans", satService.listAllSatuan());
		
		return "barangform";
	}
	
	@RequestMapping("barang/new")
	public String newBarang(Model model) {
		model.addAttribute("barang", new Barang());		
		model.addAttribute("jenisbarangs", kbService.listAllKategoriBarang());
		model.addAttribute("satuans", satService.listAllSatuan());
		
		return "barangform";
	}
	
	@RequestMapping(value = "barang", method = RequestMethod.POST)
	public String save(@Valid Barang barang, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("jenisbarangs", kbService.listAllKategoriBarang());
			model.addAttribute("satuans", satService.listAllSatuan());
			
			return "barangform";
		}
		
		// Hardcoded for temporary
		barang.setIdPerusahaan("1");
		
		barangService.save(barang);
		
		return "redirect:/barang/success";
	}
	
	@RequestMapping("barang/delete/{kdBarang}")
	public String delete(@PathVariable String kdBarang) {
		barangService.delete(kdBarang);
		
		return "redirect:/barang";
	}
}
