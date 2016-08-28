package com.spanish.english.controller;

import java.util.HashMap;
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
import com.spanish.english.services.AdminServices;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.OperatorServices;



@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	OperatorServices operatorServices;
	
	@Autowired
	EstablishmentServices establishmentServices;
	
	@Autowired
	AdminServices adminServices;

	@Autowired
	MachineServices machineServices;
	
	@RequestMapping("/operators")
	public String adminHome(@ModelAttribute("operator") Operator operator,ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		
		Set<Operator> operatorList= operatorServices.getOperatorList();
		model.addAttribute("opratorActive", "operatorActive");
		model.addAttribute(new Operator());
		model.addAttribute("operatorList", operatorList);
		return "operatorsList";
	}
	
	@RequestMapping(value="/operatorsList")
	public String allOperatorList(@ModelAttribute("operator") Operator operator,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		
		String action="action";
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		
		System.out.println("Action: "+action);
		if(action!=null){
			if(action.equals("add")){
				System.out.println("add operator");
				operator.setAdmin(loggedAdmin);
				
				if(operatorServices.addOrUpdateOperator(operator)){
					System.out.println("operator added");
				}
			}else if(action.equals("edit")){
				Operator op = operatorServices.getOperatorById(operator.getId());
				/*System.out.println("getAddress"+operator.getAddress() + "\tgetEmail"+operator.getEmail() + "\tgetFirstname"+ operator.getFirstname() + "\tgetId"+operator.getId() + "\tgetLastname"+operator.getLastname()+
						"\tgetPassword"+operator.getPassword() + "\tgetTelephone"+operator.getTelephone() + "\tgetUsername"+operator.getUsername());*/
				op.setAddress(operator.getAddress());
				op.setEmail(operator.getEmail());
				op.setBusiness(operator.getBusiness());
				op.setSector(operator.getSector());
				op.setIdentity_card(operator.getIdentity_card());
				op.setPopulation(operator.getPopulation());
				op.setProvince(operator.getProvince());
				op.setName(operator.getName());
				op.setPassword(operator.getPassword());
				op.setTelephone(operator.getTelephone());
				op.setUsername(operator.getUsername());
				if(operatorServices.addOrUpdateOperator(op)){
					System.out.println("operator edited");
				}
			}
		}
		Set<Operator> operatorList= operatorServices.getOperatorList();
		model.addAttribute("opratorActive", "operatorActive");
		model.addAttribute(new Operator());
		model.addAttribute("operatorList", operatorList);
		return "operatorsList";
	}
	
	@RequestMapping(value = "/deleteOperatorList")
	public String deleteEmployeeList(@RequestParam("list") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			
			int id = Integer.parseInt(str1[i]);
			
			
			operatorServices.deleteOperator(id);
		
			
			//model.addAttribute(new School());
			
		}
		Set<Operator> operatorList= operatorServices.getOperatorList();
		model.addAttribute("opratorActive", "operatorActive");
		model.addAttribute(new Operator());
		model.addAttribute("operatorList", operatorList);
		return "operatorsList";
	}


	
	
	@RequestMapping("/establishment")
	public String establishmentHome(@ModelAttribute("establishment") Establishment establishment,ModelMap model){
		Set<Establishment> establishmentList= establishmentServices.getEstablishmentList();
		model.addAttribute("establishmentActive", "establishmentActive");
		model.addAttribute(new Establishment());
		model.addAttribute("establishmentList", establishmentList);
		return "establishmentList";
	}
	
	@RequestMapping(value="/establishmentList")
	public String allestablishmentList(@ModelAttribute("establishment") Establishment establishment,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		
		String action="action";
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		
		System.out.println("Action: "+action);
		if(action!=null){
			if(action.equals("add")){
				System.out.println("add establishment");
				establishment.setAdmin(loggedAdmin);
				/*Set<Establishment> establishmentSet = loggedAdmin.getEstablishment();
				establishmentSet.add(establishment);*/
				
				if(establishmentServices.addOrUpdateEstablishment(establishment)){
					System.out.println("establishment added");
				}
			}else if(action.equals("edit")){
				Establishment est= establishmentServices.getEstablishmentById(establishment.getId());
				/*System.out.println("getAddress"+operator.getAddress() + "\tgetEmail"+operator.getEmail() + "\tgetFirstname"+ operator.getFirstname() + "\tgetId"+operator.getId() + "\tgetLastname"+operator.getLastname()+
						"\tgetPassword"+operator.getPassword() + "\tgetTelephone"+operator.getTelephone() + "\tgetUsername"+operator.getUsername());*/
				est.setAddress(establishment.getAddress());
				est.setFund(establishment.getFund());
				est.setEstablishmentsType(establishment.getEstablishmentsType());
				est.setSector(establishment.getSector());
				est.setDischargeDate(establishment.getDischargeDate());
				est.setHours(establishment.getHours());
				est.setLoans(establishment.getLoans());
				est.setPercentage(establishment.getPercentage());
				est.setPrepayments(establishment.getPrepayments());
				est.setPopulation(establishment.getPopulation());
				est.setProvince(establishment.getProvince());
				est.setEstablishmentName(establishment.getEstablishmentName());
				est.setPassword(establishment.getPassword());
				est.setPhone(establishment.getPhone());
				est.setStatus(establishment.getStatus());
				est.setWithdrawals(establishment.getWithdrawals());
				est.setUsername(establishment.getUsername());
                est.setGeolocation(establishment.getGeolocation());  

				
				if(establishmentServices.addOrUpdateEstablishment(est)){
					System.out.println("establishment edited");
				}
			}
		}
		Set<Establishment> establishmentList= establishmentServices.getEstablishmentList();
		model.addAttribute("establishmentActive", "establishmentActive");
		model.addAttribute(new Establishment());
		model.addAttribute("establishmentList", establishmentList);
		return "establishmentList";
	}
	
	
	
	
	@RequestMapping(value = "/deleteEstablishmentList")
	public String deleteEstablishments(@RequestParam("list") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			
			int id = Integer.parseInt(str1[i]);
			
			
			establishmentServices.deleteEstablishment(id);
		
			
			//model.addAttribute(new School());
			
		}
		Set<Establishment> establishmentList= establishmentServices.getEstablishmentList();
		model.addAttribute("establishmentActive", "establishmentActive");
		model.addAttribute(new Establishment());
		model.addAttribute("establishmentList", establishmentList);
		return "establishmentList";
	}

	@RequestMapping("/machine")
	public String machineHome(@ModelAttribute("machine") Machine machine,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		
		
		String action="action";
		
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		
		System.out.println("Action: "+action);
		if(action!=null){
			if(action.equals("add")){
				System.out.println("add machine");
				machine.setAdmin(loggedAdmin);
				if(machineServices.addOrUpdateMachine(machine)){
					System.out.println("machine added");
				}
			}else if(action.equals("edit")){
				Machine mch= machineServices.getMachineById(machine.getId());
				
				mch.setMachineControl(machine.getMachineControl());
				mch.setMachineEntries(machine.getMachineEntries());
				mch.setMachineHopper(machine.getMachineHopper());
				mch.setMachineIMEI(machine.getMachineIMEI());
				mch.setMachinelock(machine.getMachinelock());
				mch.setMachineNumber(machine.getMachineNumber());
				mch.setMachineOutput(machine.getMachineOutput());
				mch.setMachineStatus(machine.getMachineStatus());
				mch.setMachineType(machine.getMachineType());
				mch.setManufacturingDate(machine.getManufacturingDate());
			
				if(machineServices.addOrUpdateMachine(mch)){
					System.out.println("machine edited");
				}
			}
		}
		
		Set<Machine> machineList= machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		return "machineList";
	}

	@RequestMapping(value = "/deleteMachine")
	public String deleteMachines(@RequestParam("list") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			
			int id = Integer.parseInt(str1[i]);
			machineServices.deleteMachine(id);
		
		}
		
		Set<Machine> machineList= machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		return "machineList";
	}

	
	@RequestMapping("/assignMachines")
	public String assignMachines(@ModelAttribute("machine") Machine machine,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		System.out.println("ohh great work aniket!!!");
		return null;
	}
}
