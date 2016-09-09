package com.spanish.english.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spanish.english.form.Admin;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.Machine;
import com.spanish.english.form.Operator;
import com.spanish.english.form.Technician;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.TechnicianServices;

@Controller
@RequestMapping("/establishment")
public class EstablishmentController {

	@Autowired
	EstablishmentServices establishmentServices; 
	
	@Autowired
	MachineServices machineServices;
	
	@Autowired
	TechnicianServices technicianServices;
	
	@RequestMapping("/machine")
	public String machineHome(@ModelAttribute("machine") Machine machine,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		
		Establishment loggedEstablishment = establishmentServices.getEstablishmentByUsername(userName);
		
		System.out.println(loggedEstablishment.getEstablishmentName());
		
		Set<Machine> machineList = machineServices.getMachineListByEstablishmentId(loggedEstablishment.getId());
		
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		
		return "machineEstablishment";
	}
	
	@RequestMapping(value="/technician")
	public String allestablishmentList(@ModelAttribute("technician") Technician technician,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Establishment loggedEstablishment = establishmentServices.getEstablishmentByUsername(userName);
		
		String action="action";
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		
		System.out.println("Action: "+action);
		if(action!=null){
			if(action.equals("add")){
				System.out.println("add technician");
				technician.setEstablishment(loggedEstablishment);
				
				
				if(technicianServices.addOrUpdateTechnician(technician)){
					System.out.println("technician added");
				}
			}else if(action.equals("edit")){
				Technician oldTechnician = technicianServices.getTechnicianById(technician.getId());
				oldTechnician.setAddress(technician.getAddress());
				oldTechnician.setPhone(technician.getPhone());
				oldTechnician.setTechnicianName(technician.getTechnicianName());
				if(technicianServices.addOrUpdateTechnician(oldTechnician)){
					System.out.println("technician edited");
				}
			}
		}
		Set<Technician> technicianList= technicianServices.getTechnicianList();
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);
		return "technicianList";
	}
	
	@RequestMapping(value = "/deleteTechnician")
	public String deleteMachines(@RequestParam("list") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			
			int id = Integer.parseInt(str1[i]);
			technicianServices.deleteTechnician(id);
		
		}
		
		Set<Technician> technicianList= technicianServices.getTechnicianList();
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);
		return "technicianList";
	}
	
	/*@RequestMapping("/assignMachines")
	public String assignMachines(@ModelAttribute("machine") Machine machine,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Establishment loggedEstablishment = establishmentServices.getEstablishmentByUsername(userName);
		
		Set<Machine> machineList = machineServices.getMachineListByEstablishmentId(loggedEstablishment.getId());
		Set<Technician> technicianList = technicianServices.getTechnicianList();
		
	
		  
		model.addAttribute("machineList", machineList);
		model.addAttribute("technicianList", technicianList);
		
		return "assignMachineOperator";
	}*/

}
