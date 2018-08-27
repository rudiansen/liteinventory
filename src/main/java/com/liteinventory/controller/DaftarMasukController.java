package com.liteinventory.controller;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.liteinventory.editor.DetilMasukIdEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liteinventory.model.DaftarMasuk;
import com.liteinventory.model.DaftarMasukDetil;
import com.liteinventory.model.DaftarMasukDetilId;
import com.liteinventory.service.BarangService;
import com.liteinventory.service.DaftarMasukService;
import com.liteinventory.service.KategoriBarangService;
import com.liteinventory.service.SatuanService;

@Controller
public class DaftarMasukController {

	private DaftarMasukService dmService;
	private BarangService barangService;
	private KategoriBarangService kbService;
	private SatuanService satService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DaftarMasukDetilId.class, new DetilMasukIdEditor());
	}

	@Autowired
	public void setDmService(DaftarMasukService dmService) {
		this.dmService = dmService;
	}
	
	@Autowired
	public void setKbService(KategoriBarangService kbService) {
		this.kbService = kbService;
	}

	@Autowired
	public void setSatService(SatuanService satService) {
		this.satService = satService;
	}
	
	@Autowired
	public void setBarangService(BarangService barangService) {
		this.barangService = barangService;
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
	
	@RequestMapping(value = {"daftarmasuk/{idMasuk}/detil/{noItem}" , "daftarmasuk/{idMasuk}/detil/new"})
	public String editDetilBarang(@PathVariable Long idMasuk, @PathVariable Optional<Integer> noItem, Model model) {
		Collection<DaftarMasukDetil> dmDetils = dmService.getDaftarMasukById(idMasuk).get().getDaftarMasukDetil();
		
		model.addAttribute("daftarMasukDetils", dmDetils);
		if (noItem.isPresent()) {
			model.addAttribute("daftarMasukDetil", dmDetils.stream()
					.filter(d -> d.getId().getNoItem() == noItem.get())
					.findFirst().get());
		} else {
			DaftarMasukDetil dmDetil = new DaftarMasukDetil();
			DaftarMasukDetilId id = new DaftarMasukDetilId();
			id.setIdMasuk(idMasuk);
			
			dmDetil.setId(id);
			
			model.addAttribute("daftarMasukDetil", dmDetil);
		}
		
		model.addAttribute("barangs", barangService.listAllBarang());
		model.addAttribute("jenisbarangs", kbService.listAllKategoriBarang());
		model.addAttribute("satuans", satService.listAllSatuan());
		
		return "daftarmasukformdetil";
	}

	@RequestMapping(value = "daftarmasuk/{idMasuk}/detil")
	public String listDetilBarang(@PathVariable Long idMasuk, Model model) {
		List<DaftarMasukDetil> dmDetils = dmService.getDaftarMasukById(idMasuk).get().getDaftarMasukDetil();

		model.addAttribute("daftarMasukDetils", dmDetils);

		DaftarMasukDetil dmDetil = new DaftarMasukDetil();
		DaftarMasukDetilId id = new DaftarMasukDetilId();
		id.setIdMasuk(idMasuk);

		dmDetil.setId(id);

		model.addAttribute("daftarMasukDetil", dmDetil);
		model.addAttribute("barangs", barangService.listAllBarang());
		model.addAttribute("jenisbarangs", kbService.listAllKategoriBarang());
		model.addAttribute("satuans", satService.listAllSatuan());

		return "daftarmasukdetil";
	}

	@RequestMapping(value = "daftarmasuk", method = RequestMethod.POST)
	public String save(@Valid DaftarMasuk daftarMasuk, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			return "daftarmasukform";
		}					
		
		if (daftarMasuk.getIdMasuk() == 0) {
			// Hardcoded for temporary
			daftarMasuk.setIdPerusahaan("GOV022000001");
			daftarMasuk.setServerDatetime(new Timestamp(System.currentTimeMillis()));
		}
		
		dmService.save(daftarMasuk);
		
		return "redirect:/daftarmasuk";
	}
	
	@RequestMapping(value = "daftarmasukdetil", method = RequestMethod.POST)
	public String saveDetil(@Valid DaftarMasukDetil daftarMasukDetil, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			
			return "daftarmasukformdetil";
		}
				
		DaftarMasuk dm = dmService.getDaftarMasukById(daftarMasukDetil.getId().getIdMasuk()).get();
		List<DaftarMasukDetil> dmDetils = dm.getDaftarMasukDetil();
		int count = dm.getDaftarMasukDetil().size();
		
		daftarMasukDetil.getId().setNoItem(count+1); // Increment by 1
		
		dmDetils.add(daftarMasukDetil);
		dm.setDaftarMasukDetil(dmDetils);
		
		dmService.save(dm);
		
		return "redirect:/daftarmasuk/"+ daftarMasukDetil.getId().getIdMasuk() + "/detil";
	}
	
	@RequestMapping("daftarmasuk/delete/{idMasuk}")
	public String delete(@PathVariable Long idMasuk) {
		
		dmService.delete(idMasuk);
		
		return "redirect:/daftarmasuk";
	}
	
	@RequestMapping("daftarmasuk/{idMasuk}/detil/delete/{noItem}")
	public String deleteDetil(@PathVariable Long idMasuk, @PathVariable Integer noItem) {
		
		dmService.deleteDetil(new DaftarMasukDetilId(idMasuk, noItem));
		
		return "redirect:/daftarmasuk";
	}
}
