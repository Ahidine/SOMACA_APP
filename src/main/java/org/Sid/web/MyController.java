package org.Sid.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Sid.dao.MyTableRepository;
import org.Sid.entities.MyTable;
import org.Sid.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController {
	@Autowired
	MyTableRepository mytableRepository; 
	@Autowired
	FileService fileServices;
	
	@RequestMapping(value={"/","/index","/home"})	
	public String index(Model model)
	{
		//Page MyData = mytableRepository.findAll(PageRequest.of(page, size));
		List MyData=mytableRepository.findAll();
		model.addAttribute("MyData",MyData);
		System.out.println(MyData);
		return "tables";
	}
	@RequestMapping(value="/login")
	public String login()
	{
		return "SeConnecter";
	}
	@RequestMapping("/Deconnecter")
	public String deconnecter( HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession(false);
		return "redirect:/login?logout";
	}
	@RequestMapping(value="/delete")
	public String delete(Long id , RedirectAttributes att) {
		System.out.println("####################");
		MyTable ligne= mytableRepository.findById(id).get();
		System.out.println("################### here :"+ligne.getDesignation());
		mytableRepository.delete(ligne);
		String message ="l enregistrement du departement  "+ligne.getDepartement()+" a été bien supprimer ";
		att.addFlashAttribute("message",message);
		 return "redirect:/index";
	}
	
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	public String add(String departement , String equipement , String sous_equipement ,
			String designation, String reference,String etat_PDR, String Type_PDR,
	 String code_mabic, String mode_gestionnaire )
	{
		MyTable ligne=  new MyTable(departement, equipement, sous_equipement, designation, reference, etat_PDR, code_mabic, mode_gestionnaire,Type_PDR);
		mytableRepository.save(ligne);
		 return "redirect:/index";
	}
	@RequestMapping("/Update")
	public String Update(Long id,String departement , String equipement , String sous_equipement ,
			String designation, String reference,String etat_PDR, String Type_PDR,
	 String code_mabic, String mode_gestionnaire, RedirectAttributes att )
	{
		MyTable ligne= mytableRepository.findById(id).get();
		ligne.setDepartement(departement);
		ligne.setCode_mabic(code_mabic);
		ligne.setDesignation(designation);
		ligne.setEtat_PDR(etat_PDR);
		ligne.setMode_gestionnaire(mode_gestionnaire);
		ligne.setType_PDR(Type_PDR);
		ligne.setSous_equipement(sous_equipement);
		ligne.setEquipement(equipement);
		ligne.setReference(reference);
		
		String message ="l' enregistrement du departement "+ligne.getDepartement()+" a été bien modifier ";
		mytableRepository.save(ligne);
		att.addFlashAttribute("message",message);
		return "redirect:/index";
	}
	@RequestMapping(value="/",method=RequestMethod.POST)
	    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file,@RequestParam("what") String what, Model model) {
		System.out.println("what :"+what);
		if(what.equals("1"))
		{ 
			mytableRepository.deleteAll();
			System.out.println("bye bye");
		}
		
		
			try {
				System.out.println("TEEEEEEEST2");

			fileServices.store(file);
				model.addAttribute("messageT", "File uploaded successfully!");
			} catch (Exception e) {
				System.out.println("TEEEEEEEST3");

				model.addAttribute("messageT", "Fail! -> uploaded filename: " + file.getOriginalFilename());
			}
	        return "redirect:/";
	    }

}
