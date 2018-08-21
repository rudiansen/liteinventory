package com.liteinventory.controller;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liteinventory.model.DaftarMasuk;
import com.liteinventory.model.DaftarMasukDetil;
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
		DaftarMasuk newDM = new DaftarMasuk();
		newDM.setServerDatetime(new Timestamp(System.currentTimeMillis()));
		
		model.addAttribute("daftarMasuk", newDM);
		
		return "daftarmasukform";
	}
	
	@RequestMapping("daftarmasuk/edit/{idMasuk}")
	public String edit(@PathVariable Long idMasuk, Model model) {
		model.addAttribute("daftarMasuk", dmService.getDaftarMasukById(idMasuk).get());
		
		return "daftarmasukform";
	}
	
	@RequestMapping(value = {"daftarmasuk/{idMasuk}/detil", "daftarmasuk/{idMasuk}/detil/{noItem}"})
	public String editDetil(@PathVariable Long idMasuk, @PathVariable Optional<Integer> noItem, Model model) {
		Collection<DaftarMasukDetil> dmDetils = dmService.getDaftarMasukById(idMasuk).get().getDaftarMasukDetil();
		
		model.addAttribute("daftarMasukDetils", dmDetils);
		if (noItem.isPresent()) {
			model.addAttribute("daftarMasukDetil", dmDetils.stream()
					.filter(d -> d.getId().getNoItem() == noItem.get())
					.findFirst());
		} else {
			model.addAttribute("daftarMasukDetil", new DaftarMasukDetil());
		}
		
		return "daftarmasukformdetil";
	}
	
	@RequestMapping(value = "daftarmasuk", method = RequestMethod.POST)
	public String save(@Valid DaftarMasuk daftarMasuk, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			return "daftarmasukform";
		}					
		
		if (daftarMasuk.getIdMasuk() == 0) {
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
