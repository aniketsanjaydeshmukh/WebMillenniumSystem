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
import org.springframework.web.bind.annotation.RequestMethod;

import com.spanish.english.form.Establishment;
import com.spanish.english.form.Machine;
import com.spanish.english.form.Operator;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.OperatorServices;

@Controller
@RequestMapping("/operator")
public class OperatorController {


	@Autowired
	MachineServices machineServices;
	
	@Autowired
	OperatorServices operatorServices;
	
	@Autowired
	EstablishmentServices establishmentServices;
	
	@RequestMapping("/machine")
	public String machineHome(@ModelAttribute("machine") Machine machine,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Operator loggedOperator = operatorServices.getOperatorByUsername(userName);
		
		Set<Machine> machineList = machineServices.getMachineListByOperatorId(loggedOperator.getId());
		
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		
		return "machineOperator";
	}
	
	@RequestMapping("/assignMachines")
	public String assignMachines(@ModelAttribute("machine") Machine machine,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Operator loggedOperator = operatorServices.getOperatorByUsername(userName);
		
		Set<Machine> machineList = machineServices.getMachineListByOperatorId(loggedOperator.getId());
		Set<Establishment> establishmentList = establishmentServices.getEstablishmentList();
		
	
		  
		model.addAttribute("machineList", machineList);
		model.addAttribute("establishmentList", establishmentList);
		
		return "assignMachineOperator";
	}
	
	@RequestMapping(value="/assignMachined", method=RequestMethod.POST)
	public String assignMachined(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Operator loggedOperator = operatorServices.getOperatorByUsername(userName);
		
		String mID = request.getParameter("machineID");
		String eID = request.getParameter("establishmentID");
		
		
		long machineID = Long.parseLong(mID);
		long establishmentID = Long.parseLong(eID);
		Machine machine = machineServices.getMachineById(machineID);
		Establishment establishment = establishmentServices.getEstablishmentById(establishmentID);
		System.out.println("EstablishmentName:"+establishment.getEstablishmentName());
		machine.setEstablishment(establishment);
		machine.setMachineStatus("assignedToEstablishment");
		machineServices.addOrUpdateMachine(machine);
		Set<Machine> machineList = machineServices.getMachineListByOperatorId(loggedOperator.getId());
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		return "machineOperator";
	}
}
