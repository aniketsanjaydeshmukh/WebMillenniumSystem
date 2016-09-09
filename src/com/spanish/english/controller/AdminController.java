package com.spanish.english.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.spanish.english.form.Admin;
import com.spanish.english.form.BillValidatorType;
import com.spanish.english.form.BillsType;
import com.spanish.english.form.BillsValue;
import com.spanish.english.form.CoinValidatorType;
import com.spanish.english.form.CoinsType;
import com.spanish.english.form.CoinsValue;
import com.spanish.english.form.Country;
import com.spanish.english.form.CountryBillsValue;
import com.spanish.english.form.CountryCoinsValue;
import com.spanish.english.form.CountryTokensValue;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.HopperType;
import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineType;
import com.spanish.english.form.Operator;
import com.spanish.english.form.TokensType;
import com.spanish.english.form.TokensValue;
import com.spanish.english.services.AdminServices;
import com.spanish.english.services.BillValidatorTypeServices;
import com.spanish.english.services.BillsTypeServices;
import com.spanish.english.services.BillsValueServices;
import com.spanish.english.services.CoinValidatorTypeServices;
import com.spanish.english.services.CoinsTypeServices;
import com.spanish.english.services.CoinsValueServices;
import com.spanish.english.services.CountryBillsValueServices;
import com.spanish.english.services.CountryCoinsValueServices;
import com.spanish.english.services.CountryServices;
import com.spanish.english.services.CountryTokensValueServices;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.HopperTypeServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.MachineTypeServices;
import com.spanish.english.services.OperatorServices;
import com.spanish.english.services.TokensTypeServices;
import com.spanish.english.services.TokensValueServices;



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
	
	@Autowired
	CountryServices countryServices;
	
	@Autowired
	MachineTypeServices machineTypeServices;
	
	@Autowired
	HopperTypeServices hopperTypeServices;
	
	@Autowired
	CoinValidatorTypeServices coinValidatorTypeServices;
	
	@Autowired
	BillValidatorTypeServices billValidatorTypeServices;
	
	@Autowired
	CoinsTypeServices coinsTypeServices;
	
	@Autowired
	CoinsValueServices coinsValueServices;
	
	@Autowired
	TokensTypeServices tokensTypeServices;
	
	@Autowired
	TokensValueServices tokensValueServices;
	
	@Autowired
	BillsTypeServices billsTypeServices;
	
	@Autowired
	BillsValueServices billsValueServices;
	
	@Autowired
	CountryCoinsValueServices countryCoinsValueServices; 
	
	@Autowired
	CountryTokensValueServices countryTokensValueServices; 
	
	@Autowired
	CountryBillsValueServices countryBillsValueServices;
	
	
	public static HashMap<String, Long> machineTypeMap = new HashMap<String, Long>();
	
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
				/*operator.setAdmin(loggedAdmin);
				operator.setOperatorRole("ROLE_OPERATOR");
				if(operatorServices.addOrUpdateOperator(operator)){
					System.out.println("operator added");
				}*/
			}else if(action.equals("edit")){
				Operator op = operatorServices.getOperatorById(operator.getId());
				op.setAddress(operator.getAddress());
				op.setEmail(operator.getEmail());
				op.setBusiness(operator.getBusiness());
				op.setSector(operator.getSector());
				op.setIdentity_card(operator.getIdentity_card());
				op.setPopulation(operator.getPopulation());
				op.setProvince(operator.getProvince());
				op.setName(operator.getName());
				op.setOperatorPassword(operator.getPassword());
				op.setTelephone(operator.getTelephone());
				op.setOperatorUsername(operator.getUsername());
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
				est.setEstablishmentPassword(establishment.getEstablishmentPassword());
				est.setPhone(establishment.getPhone());
				est.setStatus(establishment.getStatus());
				est.setWithdrawals(establishment.getWithdrawals());
				est.setEstablishmentUsername(establishment.getEstablishmentUsername());
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
		
		Set<Machine> machineList = machineServices.getMachineListByStatus("inStock");
		Set<Operator> operatorList = operatorServices.getOperatorList();
		Set<Establishment> establishmentList = establishmentServices.getEstablishmentList();
	
		  
		model.addAttribute("machineList", machineList);
		model.addAttribute("operatorList", operatorList);
		model.addAttribute("establishmentList", establishmentList);
		
		return "assignMachine";
	}
	
	@RequestMapping(value="/assignMachined", method=RequestMethod.POST)
	public String assignMachined(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		/*String action = request.getParameter("action");*/
		String mID = request.getParameter("machineID");
		String oID = request.getParameter("operatorID");
		String eID = request.getParameter("establishmentID");
		
		long machineID = Long.parseLong(mID);
		Machine machine = machineServices.getMachineById(machineID);
		if(oID != null){
			long operatorID = Long.parseLong(oID);
			Operator operator = operatorServices.getOperatorById(operatorID);
			machine.setOperator(operator);
			machine.setMachineStatus("assignedToOperator");
		}else {
			long establishmentID = Long.parseLong(eID);
			Establishment establishment = establishmentServices.getEstablishmentById(establishmentID);
			machine.setEstablishment(establishment);
			machine.setMachineStatus("assignedToEstablishment");
		}
		
		machineServices.addOrUpdateMachine(machine);
		Set<Machine> machineList= machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		return "machineList";
	}

	@RequestMapping("/country")
	public String countyHome(@ModelAttribute("country") Country country,HttpServletRequest request,HttpServletResponse response,ModelMap model){
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
				System.out.println("add country");
				
				if(countryServices.addOrUpdateCountry(country)){
					System.out.println("country added");
				}
			}else if(action.equals("edit")){
				Country cutry= countryServices.getCountryById(country.getId());
				
				cutry.setCountry(country.getCountry());
				cutry.setCurrency(country.getCurrency());
				
				if(countryServices.addOrUpdateCountry(cutry)){
					System.out.println("country edited");
				}
			}
		}
		
		Set<Country> countryList= countryServices.getCountryList();
		model.addAttribute("countryActive", "countryActive");
		model.addAttribute(new Country());
		model.addAttribute("countryList", countryList);
		return "countryList";
	}

	
	
	@RequestMapping(value = "/deleteCountryList")
	public String deleteCountry(@RequestParam("list") String str,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		str = str.substring(0, str.length()-1);
		System.out.println(str);
		String[] str1 = str.split(",");
		
		for (int i = 0; i < str1.length; i++) {
			
			int id = Integer.parseInt(str1[i]);
			countryServices.deleteCountry(id);
		
		}
		
		Set<Country> countryList= countryServices.getCountryList();
		model.addAttribute("countryActive", "countryActive");
		model.addAttribute(new Country());
		model.addAttribute("countryList", countryList);
		return "countryList";
	}
	
	
	@RequestMapping("/machineType")
	public String machineType(@ModelAttribute("machineType") MachineType machineType,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		String hopper = null;
		String csv = null;
		String bv = null;
		long mvid = 0;
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("logged userName:"+userName);
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		
		String action="action";
		boolean isAdded = false; 
		
		
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		
		System.out.println("Action: "+action);
		
		if(action!=null){
			if(action.equals("add")){
				System.out.println(machineType.getMachineTypeName() +"\n" );
				for (int i = 0; i < machineType.getPaymentDevices().length; i++) {
					System.out.println(machineType.getPaymentDevices()[i]);
					if(machineType.getPaymentDevices()[i].equals("Hopper")){
						hopper = "hopper";
					}
					if(machineType.getPaymentDevices()[i].equals("CoinSelector")){
						csv = "coinSelector";
					}
					if(machineType.getPaymentDevices()[i].equals("BillValidator")){
						bv = "billValidator";
					}
					isAdded = true;
				}
					
				
				if(machineTypeServices.addOrUpdateMachineType(machineType)){
					System.out.println("machineType added");
					
					String key = "machineType" + loggedAdmin.getAdminUsername();
					
					Set<MachineType> mtList = machineTypeServices.getMachineTypeList();
					
					MachineType lastMT = machineTypeServices.getLastMachineType();
					
					machineTypeMap.put(key, lastMT.getId());
					System.out.println("mvid:"+lastMT.getId());
					mvid = lastMT.getId();
				}
				
			}else if(action.equals("edit")){
				/*Country cutry= countryServices.getCountryById(country.getId());
				
				cutry.setCountry(country.getCountry());
				cutry.setCurrency(country.getCurrency());
				
				if(countryServices.addOrUpdateCountry(cutry)){
					System.out.println("country edited");
				}*/
			}
		}
		
		if(isAdded == false){
		Set<MachineType> machineTypeList= machineTypeServices.getMachineTypeList();
		model.addAttribute("machineTypeActive", "machineTypeActive");
		model.addAttribute(new MachineType());
		model.addAttribute("machineTypeList", machineTypeList);
		return "machineTypeList";
		}
		else{
			model.addAttribute("mvid",mvid);
			model.addAttribute("hopper", hopper);
			model.addAttribute("csv", csv);
			model.addAttribute("bv", bv);
			return "paymentDevice";
		}
	}
	
	@RequestMapping(value="/paymentDevices", method=RequestMethod.POST)
	public String paymentDevices(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String action = null;
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		boolean isHopper = false;
		boolean isCS = false;
		boolean isBV = false;
		long mvId = 0;
		if(action.equals("addHopper")){
			String noOfHopperstr = request.getParameter("noOfHopper");
			String mvIdStr = request.getParameter("mvid");
			int noOfHopper = Integer.parseInt(noOfHopperstr);
			 mvId = Long.parseLong(mvIdStr);
			MachineType mt = machineTypeServices.getMachineTypeById(mvId);
			for (int i = 0; i < noOfHopper; i++) {
				HopperType ht = new HopperType();
				ht.setMachineType(mt);
				hopperTypeServices.addOrUpdateHopperType(ht);
			}
			isHopper = true;
		}else if(action.equals("addCoinSelector")){
			String noOfHopperstr = request.getParameter("noOfCoinSelector");
			String mvIdStr = request.getParameter("mvid");
			int noOfHopper = Integer.parseInt(noOfHopperstr);
			 mvId = Long.parseLong(mvIdStr);
			MachineType mt = machineTypeServices.getMachineTypeById(mvId);
			for (int i = 0; i < noOfHopper; i++) {
				CoinValidatorType cvt = new CoinValidatorType();
				cvt.setMachineType(mt);
				coinValidatorTypeServices.addOrUpdateCoinValidatorType(cvt);
				CoinsType ct = new CoinsType();
				ct.setCoinValidatorType(cvt);
				coinsTypeServices.addOrUpdateCoinsType(ct);
				
			}
			isCS = true;
		}else if(action.equals("addBillValidator")){
			String noOfHopperstr = request.getParameter("noOfBillValidator");
			String mvIdStr = request.getParameter("mvid");
			int noOfHopper = Integer.parseInt(noOfHopperstr);
			 mvId = Long.parseLong(mvIdStr);
			MachineType mt = machineTypeServices.getMachineTypeById(mvId);
			for (int i = 0; i < noOfHopper; i++) {
				BillValidatorType bvt = new BillValidatorType();
				bvt.setMachineType(mt);
				billValidatorTypeServices.addOrUpdateBillValidatorType(bvt);
				BillsType bt = new BillsType();
				bt.setBillValidatorType(bvt);
				billsTypeServices.addOrUpdateBillsType(bt);
			}
			isBV = true;
		}
		if(isHopper){
			model.addAttribute("mvid",mvId);
			return "hopperTypeInfo";
		}else if(isCS){
			model.addAttribute("mvid",mvId);
			CoinsType ct = new CoinsType();
			ct = coinsTypeServices.getLastCoinsType();
			model.addAttribute("ctid",ct.getId());
			return "coinsValueInfo";
		}else if(isBV){
			model.addAttribute("mvid",mvId);
			BillsType bt = new BillsType();
			bt = billsTypeServices.getLastBillsType();
			model.addAttribute("btid",bt.getId());
			return "billsValueInfo";
		}else{
			return null;
		}
	}
	
	
	@RequestMapping(value="/hopperTypeConfig", method=RequestMethod.POST)
	public String hopperTypeConfig(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String action = null;
		long mvId = 0;
		boolean isCoins = false;
		boolean isTokens = false;
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		if(action.equals("addHopperAccept")){
			String[] valueType=request.getParameterValues("valueType");
			
			if(valueType[0] != null){
				if(valueType[0].equals("coin")){
					String mvIdStr = request.getParameter("mvid");
					
					 mvId = Long.parseLong(mvIdStr);
					MachineType mt = machineTypeServices.getMachineTypeById(mvId);
					Set<HopperType> htSet = hopperTypeServices.getHopperTypeByMachineId(mt.getId());
					HopperType ht =null;
					for (HopperType hopperType : htSet) {
						//check if hopper capacity is zero, means other details are remaining.
						if(hopperType.getCapacity() == 0){
							ht = hopperType;
						}
					}
					CoinsType ct = new CoinsType();
					ct.setHopperType(ht);
					coinsTypeServices.addOrUpdateCoinsType(ct);
					if(valueType.length >1){
						if(valueType[1] != null){
							if(valueType[1].equals("token")){
								// add token for hopper 
								TokensType tt = new TokensType();
								tt.setHopperType(ht);
								tokensTypeServices.addOrUpdateTokensType(tt);
							}
						}
					}
									
					isCoins = true;
				}else if(valueType[0].equals("token")){
					String mvIdStr = request.getParameter("mvid");
					
					 mvId = Long.parseLong(mvIdStr);
					MachineType mt = machineTypeServices.getMachineTypeById(mvId);
					Set<HopperType> htSet = hopperTypeServices.getHopperTypeByMachineId(mt.getId());
					HopperType ht =null;
					for (HopperType hopperType : htSet) {
						//check if hopper capacity is zero, means other details are remaining.
						if(hopperType.getCapacity() == 0){
							ht = hopperType;
						}
					}
					TokensType tt = new TokensType();
					tt.setHopperType(ht);
					tokensTypeServices.addOrUpdateTokensType(tt);
					isTokens= true;
				}
			}
			
			
		}
		if(isCoins){
			CoinsType ct = new CoinsType();
			ct = coinsTypeServices.getLastCoinsType();
			model.addAttribute("ctid",ct.getId());
			return "coinsValueInfo";
		}else if(isTokens){
			TokensType tt = new TokensType();
			tt = tokensTypeServices.getLastTokensType();
			model.addAttribute("ttid", tt.getId());
			return "tokensValueInfo";
		}else{
			return null;
		}
	}
	
	
	@RequestMapping(value="/coinsValueInfo", method=RequestMethod.POST)
	public String coinsValueInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String action = null;
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		long ctid = 0;
		if(action.equals("addCoinValue")){
			String[] coinValueType=request.getParameterValues("coinValueType");
			String ctidStr = request.getParameter("ctid");
			
			ctid = Long.parseLong(ctidStr);
			CoinsType ct = coinsTypeServices.getCoinsTypeById(ctid);
			System.out.println("ctid:"+ct.getId());
			long cvValue = 0 ;
			for (int i = 0; i < coinValueType.length; i++) {
				System.out.println(coinValueType[i]);
				CoinsValue cv = new CoinsValue();
				cvValue = Long.parseLong(coinValueType[i]);
				cv.setValue(cvValue);
				cv.setCoinsType(ct);
				coinsValueServices.addOrUpdateCoinsValue(cv);
			}
			
			 
		}
		
		Set<Country> countryList = countryServices.getCountryList();
		Set<CoinsValue> cvSet =  coinsValueServices.getCoinsValueListByCoinsType(ctid);
		List<CoinsValue> cvList = new ArrayList<CoinsValue>(cvSet);
	
		model.addAttribute("ctid", ctid);
		model.addAttribute("coinValue", cvList.get(0));
		model.addAttribute("countryList", countryList);
		return "countryCoinValueInfo";
	}
	
	
	@RequestMapping(value="/countryCoinValueConfig", method=RequestMethod.POST)
	public String countryCoinValueConfig(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
		String cvidStr = request.getParameter("coinValueID");
		long cvid = Long.parseLong(cvidStr);
		System.out.println("cvid:"+cvid);
		CoinsValue coinsValue = coinsValueServices.getCoinsValueById(cvid);
		String ctidStr = request.getParameter("coinTypeID");
		long ctid = Long.parseLong(ctidStr);
		System.out.println("ctid:"+ctid);
		
		String[] countryCoinValuesID = request.getParameterValues("countryValuesID");
		long[] countryIds = new long[countryCoinValuesID.length];
		int i = 0;
		for (String string : countryCoinValuesID) {
			System.out.println("countryCoinValuesID:"+string);
			countryIds[i] = Long.parseLong(string);
			i++;
		}
		
		String[] countryCoinValues = request.getParameterValues("countryValues");
		double[] countryValuesForCoin = new double[countryCoinValues.length];
		int j = 0;
		for (String string : countryCoinValues) {
			System.out.println("countryCoinValues:"+string);
			countryValuesForCoin[j] = Long.parseLong(string);
			j++;
		}
		
		for (int j2 = 0; j2 < countryValuesForCoin.length; j2++) {
			CountryCoinsValue ccv = new CountryCoinsValue();
			ccv.setCoinsValue(coinsValue);
			Country country = countryServices.getCountryById(countryIds[j2]);
			ccv.setCountry(country);
			ccv.setValue(countryValuesForCoin[j2]);
			countryCoinsValueServices.addOrUpdateCountryCoinsValue(ccv);
		}
		coinsValue.setDone(true);
		coinsValueServices.addOrUpdateCoinsValue(coinsValue);
		Set<CoinsValue> cvSet = coinsValueServices.getCoinsValueListByCoinsType(ctid);
		CoinsValue cv = null;
		for (CoinsValue coinsValue2 : cvSet) {
			if(coinsValue2.isDone() == false){
				cv = coinsValue2;
			}
		}
		if(cv != null){
		Set<Country> countryList = countryServices.getCountryList();
		
		model.addAttribute("ctid", ctid);
		model.addAttribute("coinValue", cv);
		model.addAttribute("countryList", countryList);
		return "countryCoinValueInfo";
		}else{
			//check if there any token for the same hopper Id
			System.out.println("coin Type ID:"+ctid);
			CoinsType ct = coinsTypeServices.getCoinsTypeById(ctid);
			System.out.println("coin Type:"+ct.getId());
			
			if(ct.getHopperType() != null){
				System.out.println("hopper typr in coin type:"+ ct.getHopperType().getId());
				TokensType tt = tokensTypeServices.getTokensTypeByHopperType(ct.getHopperType().getId());
				
				if(tt != null){
					System.out.println("token Type ID:"+tt.getId());
					model.addAttribute("ttid",tt.getId());
					return "tokensValueInfo";
				}
				else{
					
					model.addAttribute("hopperTypeId",ct.getHopperType().getId());
					return "addHopperCapacity";
				}
			}else{
				model.addAttribute("coinValidatorTypeId", ct.getCoinValidatorType().getId());
				return "addCoinValidatorCapacity";
			}
		}
	}
	
	@RequestMapping(value="/tokensValueInfo", method=RequestMethod.POST)
	public String tokensValueInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String action = null;
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		long ttid = 0;
		if(action.equals("addTokenValue")){
			String[] tokenValueType=request.getParameterValues("tokenValueType");
			String ttidStr = request.getParameter("ttid");
			
			ttid = Long.parseLong(ttidStr);
			
			TokensType tt = tokensTypeServices.getTokensTypeById(ttid);
			System.out.println("ttid:"+tt.getId());
			long tvValue = 0 ;
			for (int i = 0; i < tokenValueType.length; i++) {
				System.out.println(tokenValueType[i]);
				TokensValue tv = new TokensValue();
				tvValue = Long.parseLong(tokenValueType[i]);
				tv.setValue(tvValue);
				tv.setTokensType(tt);
				tokensValueServices.addOrUpdateTokensValue(tv);
			}
			
			 
		}
		
		Set<Country> countryList = countryServices.getCountryList();
		
		Set<TokensValue> tvSet = tokensValueServices.getTokensValueListByTokensType(ttid);
		List<TokensValue> tvList = new ArrayList<TokensValue>(tvSet);
	
		model.addAttribute("ttid", ttid);
		model.addAttribute("tokenValue", tvList.get(0));
		model.addAttribute("countryList", countryList);
		return "countryTokenValueInfo";
	}
	
	
	@RequestMapping(value="/countryTokenValueConfig", method=RequestMethod.POST)
	public String countryTokenValueConfig(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
		
		String tvidStr = request.getParameter("tokenValueID");
		long tvid = Long.parseLong(tvidStr);
		System.out.println("tvid:"+tvid);
		TokensValue tokensValue = tokensValueServices.getTokensValueById(tvid);
		String ttidStr = request.getParameter("tokenTypeID");
		long ttid = Long.parseLong(ttidStr);
		System.out.println("ttid:"+ttid);
		
		String[] countryCoinValuesID = request.getParameterValues("countryValuesID");
		long[] countryIds = new long[countryCoinValuesID.length];
		int i = 0;
		for (String string : countryCoinValuesID) {
			System.out.println("countryCoinValuesID:"+string);
			countryIds[i] = Long.parseLong(string);
			i++;
		}
		
		String[] countryCoinValues = request.getParameterValues("countryValues");
		double[] countryValuesForCoin = new double[countryCoinValues.length];
		int j = 0;
		for (String string : countryCoinValues) {
			System.out.println("countryCoinValues:"+string);
			countryValuesForCoin[j] = Long.parseLong(string);
			j++;
		}
		
		for (int j2 = 0; j2 < countryValuesForCoin.length; j2++) {
			
			CountryTokensValue ctv = new CountryTokensValue();
			ctv.setTokensValue(tokensValue);
			Country country = countryServices.getCountryById(countryIds[j2]);
			ctv.setCountry(country);
			ctv.setValue(countryValuesForCoin[j2]);
			countryTokensValueServices.addOrUpdateCountryTokensValue(ctv);
		}
		tokensValue.setDone(true);
		tokensValueServices.addOrUpdateTokensValue(tokensValue);
		
		Set<TokensValue> tvSet = tokensValueServices.getTokensValueListByTokensType(ttid);
		
		
		TokensValue tv = null;
		for (TokensValue tokensValue2 : tvSet) {
			if(tokensValue2.isDone() == false){
				tv = tokensValue2;
			}
		}
		if(tv != null){
		Set<Country> countryList = countryServices.getCountryList();
		
		model.addAttribute("ttid", ttid);
		model.addAttribute("tokenValue", tv);
		model.addAttribute("countryList", countryList);
		return "countryTokenValueInfo";
		}else{
			TokensType tt = tokensTypeServices.getTokensTypeById(ttid);
			model.addAttribute("hopperTypeId", tt.getHopperType().getId());
			return "addHopperCapacity";
		}
	}
	
	
	@RequestMapping(value="/hopperCapacity", method=RequestMethod.POST)
	public String hopperCapacity(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String csv = null;
		String bv = null;
		String hopper = null;
		String hopperTypeIdStr = request.getParameter("hopperTypeId");
		long hopperTypeId = Long.parseLong(hopperTypeIdStr);
		System.out.println("hopperTypeId:"+hopperTypeId);
		
		String hopperTypeCapacityStr = request.getParameter("hopperTypeCapacity");
		long hopperTypeCapacity = Long.parseLong(hopperTypeCapacityStr);
		System.out.println("hopperTypeCapacity:"+hopperTypeCapacity);
		
		HopperType ht = hopperTypeServices.getHopperTypeById(hopperTypeId);
		ht.setCapacity(hopperTypeCapacity);;
		hopperTypeServices.addOrUpdateHopperType(ht);
		long mvId = ht.getMachineType().getId();
		Set<HopperType> htSet = hopperTypeServices.getHopperTypeByMachineId(mvId);
		List<HopperType> htList = new ArrayList<HopperType>(htSet);
		HopperType htNew = null;
		for (HopperType hopperType : htList) {
			if(hopperType.getCapacity() == 0){
				htNew = hopperType;
			}
		}
		if(htNew != null){
			model.addAttribute("mvid",mvId);
			return  "hopperTypeInfo";
		}else{
			for (int i = 0; i < ht.getMachineType().getPaymentDevices().length; i++) {
				if(ht.getMachineType().getPaymentDevices()[i].equals("CoinSelector")){
					csv = "coinSelector";
				}
				if(ht.getMachineType().getPaymentDevices()[i].equals("BillValidator")){
					bv = "billValidator";
				}
			}
			model.addAttribute("mvid",mvId);
			model.addAttribute("hopper", hopper);
			model.addAttribute("csv", csv);
			model.addAttribute("bv", bv);
			return "paymentDevice";
			}
		}
		
	
	/*@RequestMapping(value="/coinValidatorInfo", method=RequestMethod.POST)
	public String coinValidatorInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
	}*/
	
	@RequestMapping(value="/coinValidatorTypeCapacity", method=RequestMethod.POST)
	public String coinValidatorTypeCapacity(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String csv = null;
		String bv = null;
		String hopper = null;
		String coinValidatorTypeIdStr = request.getParameter("coinValidatorTypeId");
		long coinValidatorTypeId = Long.parseLong(coinValidatorTypeIdStr);
		System.out.println("coinValidatorTypeId:"+coinValidatorTypeId);
		
		String coinValidatorTypeCapacityStr = request.getParameter("coinValidatorTypeCapacity");
		long coinValidatorTypeCapacity = Long.parseLong(coinValidatorTypeCapacityStr);
		System.out.println("coinValidatorTypeCapacity:"+coinValidatorTypeCapacity);
		
		
		CoinValidatorType cvt = coinValidatorTypeServices.getCoinValidatorTypeById(coinValidatorTypeId);
		cvt.setCapacity(coinValidatorTypeCapacity);
		
		coinValidatorTypeServices.addOrUpdateCoinValidatorType(cvt);
		long mvId = cvt.getMachineType().getId();
		
		Set<CoinValidatorType> cvtSet = coinValidatorTypeServices.getCoinValidatorTypeByMachineType(mvId);
		
		List<CoinValidatorType> cvtList = new ArrayList<CoinValidatorType>(cvtSet);
		CoinValidatorType cvtNew = null;
		for (CoinValidatorType coinValidatorType : cvtList) {
			if(coinValidatorType.getCapacity() == 0){
				cvtNew = coinValidatorType;
			}
		}
		if(cvtNew != null){
			model.addAttribute("mvid",mvId);
			CoinsType ct = new CoinsType();
			ct = coinsTypeServices.getCoinsTypeByCoinValidatorType(cvtNew.getId());
			model.addAttribute("ctid",ct.getId());
			return  "coinsValueInfo";
		}else{
			for (int i = 0; i < cvt.getMachineType().getPaymentDevices().length; i++) {
				
				if(cvt.getMachineType().getPaymentDevices()[i].equals("BillValidator")){
					bv = "billValidator";
				}
			}
			model.addAttribute("mvid",mvId);
			model.addAttribute("hopper", hopper);
			model.addAttribute("csv", csv);
			model.addAttribute("bv", bv);
			return "paymentDevice";
			}
		}
	
	@RequestMapping(value="/billsValueInfo", method=RequestMethod.POST)
	public String billsValueInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String action = null;
		if(request.getParameter("action")!=null){
			action=request.getParameter("action");
		}
		long btid = 0;
		if(action.equals("addBillValue")){
			String[] billValueType=request.getParameterValues("billValueType");
			String btidStr = request.getParameter("btid");
			
			btid = Long.parseLong(btidStr);
			
			BillsType bt = billsTypeServices.getBillsTypeById(btid);
			System.out.println("btid:"+bt.getId());
			long bvValue = 0 ;
			for (int i = 0; i < billValueType.length; i++) {
				System.out.println(billValueType[i]);
				BillsValue bv = new BillsValue();
				bvValue = Long.parseLong(billValueType[i]);
				bv.setValue(bvValue);
				bv.setBillsType(bt);
				billsValueServices.addOrUpdateBillsValue(bv);
			}
			
			 
		}
		
		Set<Country> countryList = countryServices.getCountryList();
		Set<BillsValue> bvSet = billsValueServices.getBillsValueListByBillsType(btid);
		List<BillsValue> bvList = new ArrayList<BillsValue>(bvSet);
	
		model.addAttribute("btid", btid);
		model.addAttribute("billValue", bvList.get(0));
		model.addAttribute("countryList", countryList);
		return "countryBillValueInfo";
	}
	
	
	@RequestMapping(value="/countryBillValueConfig", method=RequestMethod.POST)
	public String countryBillValueConfig(HttpServletRequest request,HttpServletResponse response,ModelMap model){
	
		String bvidStr = request.getParameter("billValueID");
		long bvid = Long.parseLong(bvidStr);
		System.out.println("bvid:"+bvid);
		BillsValue billsValue = billsValueServices.getBillsValueById(bvid);
		String btidStr = request.getParameter("billTypeID");
		long btid = Long.parseLong(btidStr);
		System.out.println("btid:"+btid);
		
		String[] countryCoinValuesID = request.getParameterValues("countryValuesID");
		long[] countryIds = new long[countryCoinValuesID.length];
		int i = 0;
		for (String string : countryCoinValuesID) {
			System.out.println("countryCoinValuesID:"+string);
			countryIds[i] = Long.parseLong(string);
			i++;
		}
		
		String[] countryCoinValues = request.getParameterValues("countryValues");
		double[] countryValuesForCoin = new double[countryCoinValues.length];
		int j = 0;
		for (String string : countryCoinValues) {
			System.out.println("countryCoinValues:"+string);
			countryValuesForCoin[j] = Long.parseLong(string);
			j++;
		}
		
		for (int j2 = 0; j2 < countryValuesForCoin.length; j2++) {
			
			CountryBillsValue cbv = new CountryBillsValue();
			
			cbv.setBillsValue(billsValue);
			Country country = countryServices.getCountryById(countryIds[j2]);
			cbv.setCountry(country);
			cbv.setValue(countryValuesForCoin[j2]);
			
			countryBillsValueServices.addOrUpdateCountryBillsValue(cbv);
		}
		billsValue.setDone(true);
		billsValueServices.addOrUpdateBillsValue(billsValue);
		Set<BillsValue> bvSet = billsValueServices.getBillsValueListByBillsType(btid);
		BillsValue bv = null;
		for (BillsValue billsValue2 : bvSet) {
			if(billsValue2.isDone() == false){
				bv = billsValue2;
			}
		}
		if(bv != null){
		Set<Country> countryList = countryServices.getCountryList();
		
		model.addAttribute("btid", btid);
		model.addAttribute("billValue", bv);
		model.addAttribute("countryList", countryList);
		return "countryBillValueInfo";
		}else{
			
				BillsType bt = billsTypeServices.getBillsTypeById(btid);
				model.addAttribute("billValidatorTypeId", bt.getBillValidatorType().getId());
				return "addBillValidatorCapacity";
			}
		}
	
	@RequestMapping(value="/billValidatorTypeCapacity", method=RequestMethod.POST)
	public String billValidatorTypeCapacity(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String csv = null;
		String bv = null;
		String hopper = null;
		String billValidatorTypeIdStr = request.getParameter("billValidatorTypeId");
		long billValidatorTypeId = Long.parseLong(billValidatorTypeIdStr);
		System.out.println("billValidatorTypeId:"+billValidatorTypeId);
		
		String billValidatorTypeCapacityStr = request.getParameter("billValidatorTypeCapacity");
		long billValidatorTypeCapacity = Long.parseLong(billValidatorTypeCapacityStr);
		System.out.println("billValidatorTypeCapacity:"+billValidatorTypeCapacity);
		
		
		
		BillValidatorType bvt = billValidatorTypeServices.getBillValidatorTypeById(billValidatorTypeId);
		bvt.setCapacity(billValidatorTypeCapacity);
		
		
		billValidatorTypeServices.addOrUpdateBillValidatorType(bvt);
		long mvId = bvt.getMachineType().getId();
		
		
		Set<BillValidatorType> bvtSet = billValidatorTypeServices.getBillValidatorTypeByMachineType(mvId);
		List<BillValidatorType> bvtList = new ArrayList<BillValidatorType>(bvtSet);
		BillValidatorType bvtNew = null;
		for (BillValidatorType billValidatorType : bvtList) {
			if(billValidatorType.getCapacity() == 0){
				bvtNew = billValidatorType;
			}
		}
		if(bvtNew != null){
			model.addAttribute("mvid",mvId);
			BillsType bt = new BillsType();
			bt = billsTypeServices.getBillsTypeByBillValidatorType(bvtNew.getId());
			model.addAttribute("btid",bt.getId());
			return  "billsValueInfo";
		}else{
			
			model.addAttribute("machineTypeId", mvId);
			return "machineTypeControl";
			}
		}
	
	
	@RequestMapping(value="/machineTypeControl", method=RequestMethod.POST)
	public String machineTypeControl(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String machineTypeIdStr = request.getParameter("machineTypeId");
		long machineTypeId = Long.parseLong(machineTypeIdStr);
		System.out.println("machineTypeId:"+machineTypeId);
		
		MachineType mt = machineTypeServices.getMachineTypeById(machineTypeId);
		String wirelessType = request.getParameter("machineTypeId");
		
		if(wirelessType.equals("true")){
			mt.setWirelessControl(true);
		}else{
			mt.setWirelessControl(false);
		}
		machineTypeServices.addOrUpdateMachineType(mt);
		
		Set<MachineType> machineTypeList= machineTypeServices.getMachineTypeList();
		model.addAttribute("machineTypeActive", "machineTypeActive");
		model.addAttribute(new MachineType());
		model.addAttribute("machineTypeList", machineTypeList);
		return "machineTypeList";
		
	}
	public HashMap<String, Long> getMachineTypeMap() {    
	    return machineTypeMap;
	}
	
	
}
