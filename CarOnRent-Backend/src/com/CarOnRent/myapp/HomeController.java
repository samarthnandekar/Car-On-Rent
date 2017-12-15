package com.CarOnRent.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;

import com.CarOnRent.myapp.dao.SignUpDao;
import com.CarOnRent.myapp.helper.SendConfirmationEmail;
import com.CarOnRent.myapp.maplocation.AddressConverter;
import com.CarOnRent.myapp.pojo.AccountDetails;
import com.CarOnRent.myapp.pojo.Address;
import com.CarOnRent.myapp.pojo.AllMasterAvailability;
import com.CarOnRent.myapp.pojo.Availability;
import com.CarOnRent.myapp.pojo.CarDetails;
import com.CarOnRent.myapp.pojo.CarInsurance;
import com.CarOnRent.myapp.pojo.CarModel;
import com.CarOnRent.myapp.pojo.CarParkingaddress;
import com.CarOnRent.myapp.pojo.PaymentDetails;
import com.CarOnRent.myapp.pojo.UserAccount;
import com.CarOnRent.myapp.pojo.UserCar;
import com.CarOnRent.myapp.pojo.UsercarReservation;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.json.JSONException;

/**
 * Handles requests for the application home page.
 */
@Controller 
public class HomeController {
	
	@Autowired
	SignUpDao signUpDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	 @RequestMapping(value = "/testdata", method = RequestMethod.GET) 
	 @ResponseBody
	    public CarModel testdata() {//Welcome page, non-rest
	        CarModel carModel=new CarModel();
	        carModel.setCarModelID(1);
	        carModel.setModelName("Corolla");
	        return carModel;
	    }
	 
	 
	@RequestMapping(value="/tosignupage.htm", method = RequestMethod.GET)
	public ModelAndView redirectTosignUp(HttpServletRequest request) 
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("signUp");
		return mv;
	}
	
	
	@RequestMapping(value="/signIn.htm", method = RequestMethod.POST)
	public ModelAndView checkForsignIn(HttpServletRequest request) 
	{
		ModelAndView mv= new ModelAndView();
		
		String userName=request.getParameter("fName");
		String password=request.getParameter("userPassword");
		HttpSession session= request.getSession();
		UserAccount currUserAccount=signUpDao.getUserAccount(userName);
		
		if(currUserAccount!=null)
		{
			if(currUserAccount.getPassword().equals(password))
			{
				mv.setViewName("home");
				session.setAttribute("UsereMailId", userName);
			}
			else
			{
				mv.setViewName("signIn");
				mv.addObject("isValid", "Please provide correct input");
				
			}
		}
		else
		{
			mv.setViewName("signIn");
			mv.addObject("isValid", "Please provide correct input");
			
		}
				
		//mv.setViewName("signUp");
		return mv;
	}
	
	@RequestMapping(value="/signInIos", method = RequestMethod.GET)
	@ResponseBody
	public HashMap checkForsignInIOS(HttpServletRequest request) 
	{

		HashMap statusMap=new HashMap();
		
		
		String userName=request.getParameter("fName");
		String password=request.getParameter("userPassword");
		
		UserAccount currUserAccount=signUpDao.getUserAccount(userName);
		String isValidInput="No";
		
			if(currUserAccount.getPassword().equals(password))
			{
				isValidInput="Yes";
			}
			statusMap.put("status", isValidInput);
		return statusMap;
	}
	
	
	@RequestMapping(value="/forcheckCredential.htm", method = RequestMethod.POST)
	public void forcheckCredential(HttpServletRequest request,HttpServletResponse response) throws JSONException,IOException
	{
		String struseInput=request.getParameter("inputValue");
		
		UserAccount useraccount=signUpDao.getUserAccount(struseInput);
		JSONObject obj= new JSONObject();
		PrintWriter out = response.getWriter();
		if(useraccount==null)
		{
			
			obj.put("isValid",true);
				
		}
		else
		{
			obj.put("isValid",false);
		}
		out.println(obj);
			
	}
	
	@RequestMapping(value="/forcheckAvailableID", method = RequestMethod.GET)
	@ResponseBody
	public HashMap forcheckValidEmailID(HttpServletRequest request) throws JSONException,IOException
	{
		
		HashMap hashMap= new HashMap();
		String struseInput=request.getParameter("inputEmailID");
		UserAccount useraccount=signUpDao.getUserAccount(struseInput);
		
		if(useraccount==null)
		{
			
			hashMap.put("isValid",true);
				
		}
		else
		{
			hashMap.put("isValid",false);
		}
		return hashMap;
			
	}
	
	@RequestMapping(value="/forgetUserName.htm", method = RequestMethod.GET)
	public ModelAndView forgetUserName(HttpServletRequest request) 
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("forgetUserNamePassword");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/senduserNamepassword.htm", method = RequestMethod.POST)
	public ModelAndView senduserNamepassword(HttpServletRequest request) 
	{
		
		String useEmail=request.getParameter("emailId");
		ModelAndView mv= new ModelAndView();
		UserAccount userAccount=signUpDao.getUserAccount(useEmail);
		
		if(userAccount!=null)
		{
			String message = "Hello "
					+ userAccount.getFirstName()
					+ ", \n \n "
					+ "Please find the your login details below \n\n"
					+ "User Name :"+" "+userAccount.getEmailID() +"\n\n"
					+ "User Password:"+" "+userAccount.getPassword()+"\n\n"
					
					+ "\n\n\n"
					+"Enjoy your Time"
					+"Thanks";
					
			SendConfirmationEmail.sendMail(userAccount.getEmailID(), message);	
			mv.addObject("successMsg", "Email sent on the mail ID");
		}
		else
		{
			mv.addObject("errorMsg", "Email is not registered");
		}
		
		
		
		mv.setViewName("forgetUserNamePassword");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/availCarForBooking.htm", method = RequestMethod.GET)
	public ModelAndView availCarForBooking(HttpServletRequest request) 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate= new Date();
		
		System.out.println("current Date--->"+currentDate);
		Date after2oDays=new Date();
		after2oDays.setTime(currentDate.getTime()+20 *1000 * 60 * 60 * 24);
		
		List<AllMasterAvailability> allAvailCars=signUpDao.getAvailCarBetweenDates(currentDate,after2oDays);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("allAvailableForBooking");
		mv.addObject("allAvailCars", allAvailCars);
		return mv;
	}
	
	
	@RequestMapping(value="/availCarForBookingIOS", method = RequestMethod.GET)
	@ResponseBody
	public List<AllMasterAvailability> availCarForBookingIOS(HttpServletRequest request) 
	{
		
		String source=request.getParameter("sourcePoint");
		String destination=request.getParameter("destinationPoint");
		
		String startDate=request.getParameter("startDate");
		String startTime=request.getParameter("enstartTime");
		
		String endDate=request.getParameter("endDate");
		String endTime=request.getParameter("enendTime");
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate= new Date();
		
		System.out.println("current Date--->"+currentDate);
		Date after2oDays=new Date();
		after2oDays.setTime(currentDate.getTime()+20 *1000 * 60 * 60 * 24);
		
		List<AllMasterAvailability> allAvailCars=signUpDao.getAvailCarBetweenDates(currentDate,after2oDays);
		
		
		AllMasterAvailability secForCheck=allAvailCars.get(0);
		
		AllMasterAvailability thcheck= new AllMasterAvailability();
		
		thcheck.setAvailableDateFrom(secForCheck.getAvailableDateFrom());
		thcheck.setAvailableDateTo(secForCheck.getAvailableDateTo());

		thcheck.setAvailableTimeFrom("2:30");
		thcheck.setAvailableTimeTo("3:30");
		
		thcheck.setDayRates(4);
		thcheck.setHoursRate(10);
		thcheck.setCarParkingaddress(secForCheck.getCarParkingaddress());
		
		UserCar usercar= new UserCar();
		usercar.setAutoGear(true);
		usercar.setCarAverage(2);
		usercar.setCarimageName("Honda.jpg");
		usercar.setCarInsurance(secForCheck.getUserCar().getCarInsurance());
		
		CarDetails cardetails=new CarDetails();
		cardetails.setCarMaker("Toyota");
		cardetails.setCarModel("Carola");
		usercar.setCarDetails(cardetails);
		
		thcheck.setUserCar(usercar);
		
		List<AllMasterAvailability> finalallAvailCars= new ArrayList();
		
       AllMasterAvailability thcheck2= new AllMasterAvailability();
		
       thcheck2.setAvailableDateFrom(secForCheck.getAvailableDateFrom());
       thcheck2.setAvailableDateTo(secForCheck.getAvailableDateTo());

       thcheck2.setAvailableTimeFrom("2:30");
       thcheck2.setAvailableTimeTo("3:30");
		
       thcheck2.setDayRates(4);
       thcheck2.setHoursRate(10);
       thcheck2.setCarParkingaddress(secForCheck.getCarParkingaddress());
		
		UserCar usercar2= new UserCar();
		usercar2.setAutoGear(true);
		usercar2.setCarAverage(2);
		usercar2.setCarimageName("jeep.png");
		usercar2.setCarInsurance(secForCheck.getUserCar().getCarInsurance());
		
		CarDetails cardetails2=new CarDetails();
		cardetails2.setCarMaker("Toyota");
		cardetails2.setCarModel("Carola");
		usercar2.setCarDetails(cardetails);
		
		thcheck2.setUserCar(usercar2);
		
		finalallAvailCars.add(thcheck);
		finalallAvailCars.add(thcheck2);
		
		return allAvailCars;
	}
	
	
	@RequestMapping(value="/reservationConfirmation.htm", method = RequestMethod.POST)
	public ModelAndView reservationConfirmation(HttpServletRequest request) 
	{
		String selectedVailID=request.getParameter("selectedCArVail");	
		AllMasterAvailability availability=signUpDao.getAvailabilityByID(selectedVailID);
		
		// just placing this to simplicity to display the data in UI
		ArrayList allavailability=new ArrayList<AllMasterAvailability>();
		allavailability.add(availability);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("reservationConfirm");
		mv.addObject("availabilityfromMaster", allavailability);
		return mv;
	}
	
	@RequestMapping(value="/comfirmedPayReservation.htm", method = RequestMethod.POST)
	public ModelAndView comfirmedPayReservation(HttpServletRequest request) throws ParseException 
	{
		ModelAndView mv= new ModelAndView();
		HttpSession session=(HttpSession) request.getSession();
		
		String startDate=request.getParameter("availStartDate");
		String startTime=request.getParameter("availStartTime");
		String endDate=request.getParameter("endStartDate");
		String endTime=request.getParameter("endStartTime");
		
		// conver the above time in date
		
		String selectedVailID=request.getParameter("selectedCArVail");	
		AllMasterAvailability availability=signUpDao.getAvailabilityByID(selectedVailID);
		
		UsercarReservation usercarReservation=new UsercarReservation();
		
		Date currDate= new Date();
		usercarReservation.setBookingDate(currDate);
		UserCar usercar=availability.getUserCar();
		usercarReservation.setUserCar(usercar);
		
		String userEmailID=(String) session.getAttribute("UsereMailId");
		if(userEmailID==null)
		{
			mv.setViewName("signIn");
			return mv;
		}
		
		UserAccount userAccount=signUpDao.getUserAccount(userEmailID);		
		//usercarReservation.setUserAccount(userAccount);
		usercarReservation.setRate(availability.getDayRates());
		usercarReservation.setReservationStartDate(availability.getAvailableDateFrom());
		usercarReservation.setReservationStartTime(availability.getAvailableTimeFrom());
		
		usercarReservation.setReservationEndDate(availability.getAvailableDateTo());
		usercarReservation.setReservationEndTime(availability.getAvailableTimeTo());
		
		usercarReservation.setRate(availability.getHoursRate());
		
		CarParkingaddress carParkingaddress=availability.getCarParkingaddress();
		//carParkingaddress.setUsercarReservation(usercarReservation);
		usercarReservation.setCarParkingaddress(carParkingaddress);
		
		/* To calculate the booking time  */
	
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date avaFrom=availability.getAvailableDateFrom();	
		String availTimeFrom=availability.getAvailableTimeFrom();
		String strHtime=availTimeFrom.substring(0,2);		
		String strMtime=availTimeFrom.substring(3,5);
        Calendar c = Calendar.getInstance(); 
        c.setTime(avaFrom); 
        int hTime=Integer.parseInt(strHtime);
        int mTime=Integer.parseInt(strMtime);
        c.add(Calendar.HOUR, hTime);
        c.add(Calendar.MINUTE, mTime);
        avaFrom = c.getTime();
        System.out.println("from DAte -->"+avaFrom);
        
        Date avaTo=availability.getAvailableDateTo();
        String availTimeTo=availability.getAvailableTimeTo();
        
        String avalHtimeTo=availTimeTo.substring(0,2);
        String avalMtimeTo=availTimeTo.substring(3,5);
        
        c.setTime(avaTo);
        int tohTime=Integer.parseInt(avalHtimeTo);
        int toMTime=Integer.parseInt(avalMtimeTo);
        c.add(Calendar.HOUR, tohTime);
        c.add(Calendar.MINUTE,toMTime);
        System.out.println("To DAte -->"+avaTo);
        
        long toTimeAvailableTime=avaTo.getTime()-avaFrom.getTime();
        
        int revervationTimeInHours=(int)(toTimeAvailableTime/(60 * 60 *1000));
        
        usercarReservation.setTotalTimereverVationTime(revervationTimeInHours);
        
        int totareservationCost=revervationTimeInHours*availability.getDayRates();
      
		String date="12/02/2016";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		//System.out.println(formatter.format(date));
		//usercarReservation.setReservationStartDate(formatter.parse(date));
		//usercarReservation.setReservationEndDate(formatter.parse(date));
		//usercarReservation.setReservationEndDate(reservationEndDate);
		//usercarReservation.setBookingDate(formatter.parse(date));
		usercarReservation.setTotalReservationCost(totareservationCost);
	
		session.setAttribute("usercarReservation", usercarReservation);	
		
		mv.setViewName("reservationDetailsAndPayment");
		mv.addObject("usercarReservation", usercarReservation);
		return mv;
		
	}
	
	
	@RequestMapping(value="/payAndfinalBooking.htm", method = RequestMethod.POST)
	public ModelAndView payAndfinalBooking(HttpServletRequest request) 
	{
		ModelAndView mv= new ModelAndView();
	
		String cardNO=request.getParameter("cardNo");
		String bankName=request.getParameter("bankName");
		String carhHolderName=request.getParameter("cardHolderName");
		String expDate=request.getParameter("exp");
		String bookingEmailID=request.getParameter("bookingEmailID");
		String paidAmount=request.getParameter("Amount");
		
		String reservationMemo=request.getParameter("reservationMemo");
		
		HttpSession session=(HttpSession) request.getSession();
		UsercarReservation usercarReservation=(UsercarReservation)session.getAttribute("usercarReservation");	
		
		String currUserEmail=(String)session.getAttribute("UsereMailId");
		UserAccount userAccount=signUpDao.getUserAccount(currUserEmail);
		usercarReservation.setUserAccount(userAccount);
		
		PaymentDetails paymentDetails= new PaymentDetails();
		paymentDetails.setCardNumber(cardNO);
		paymentDetails.setBankName(bankName);
		paymentDetails.setCardHolderName(carhHolderName);
		paymentDetails.setExpDate(expDate);
		paymentDetails.setEmailID(bookingEmailID);
		
		int intPaidAmount=Integer.parseInt(paidAmount);
		paymentDetails.setAmount(intPaidAmount);
		
		usercarReservation.setPaymentDetails(paymentDetails);
		usercarReservation.setBookingStatus("Confirmed");
		paymentDetails.setUsercarReservation(usercarReservation);
		
		boolean isSaved=signUpDao.confirmReservationAndPayment(usercarReservation);
		
		if(isSaved)
		{
			
		}
		mv.addObject("usercarReservation", usercarReservation);
		mv.setViewName("displayConfirmedReservInformation");
		
	return mv;	
	}
	
	@RequestMapping(value="/registercar.htm", method = RequestMethod.GET)
	public ModelAndView registercar(HttpServletRequest request) 
	{
		ModelAndView mv= new ModelAndView();
		HttpSession session=(HttpSession) request.getSession();
		
		String currUserEmailID=(String)session.getAttribute("UsereMailId");
		UserAccount userAccount=signUpDao.getUserAccount(currUserEmailID);
		//System.out.println("size-->"+userAccount.getUserCar().size());
		
		List<UserCar> userCars=userAccount.getUserCar();
		System.out.println("userAccount.getUserCar()--->"+userCars!=null);
		System.out.println("userAccount.getUserCar()--->"+userCars==null);
		
		if(userCars!=null)
		{
			List <UserCar> userRegistercar=userAccount.getUserCar();
			
			List<UserCar> newUserRegistercar= new ArrayList<UserCar>();
			for(UserCar  uc:userRegistercar)
			{
				newUserRegistercar.add(uc);
			}
			JSONObject jsnobj=new JSONObject(newUserRegistercar);
			
			mv.setViewName("yourregisteredCar");
			mv.addObject("userRegistercar", newUserRegistercar);
		}
		else
		{
			mv.setViewName("yourregisteredCar");
			mv.addObject("isUsercarReg", false);	
		}
		mv.addObject("samtest", "sam");
		return mv;
	}
	
	
	@RequestMapping(value="/addnewCar.htm", method = RequestMethod.POST)
	public ModelAndView addNewCar(HttpServletRequest request) 
	{
		ModelAndView mv= new ModelAndView();
		
		String userID=request.getParameter("");
		
		mv.setViewName("registercar");
		mv.addObject("userID", userID);
		return mv;
	}
	
	
	@RequestMapping(value="/viewmyBooking.htm", method = RequestMethod.GET)
	public ModelAndView viewmyBooking(HttpServletRequest request) 
	{
		HttpSession session=(HttpSession) request.getSession();
	
		ModelAndView mv= new ModelAndView();
		String currUserEmailID=(String)session.getAttribute("UsereMailId");
		UserAccount userAccount=signUpDao.getUserAccount(currUserEmailID);
		
		List<UsercarReservation> usereservations=userAccount.getUsercarReservations();
		
		mv.addObject("usereservationsList", usereservations);
		mv.setViewName("showListOfUserReservations");
		return mv;
	}
	
	@RequestMapping(value="/allReservationsOFmyCar.htm", method = RequestMethod.GET)
	public ModelAndView allReservationsOFmyCar(HttpServletRequest request) 
	{
		HttpSession session=(HttpSession) request.getSession();
	
		ModelAndView mv= new ModelAndView();
		String currUserEmailID=(String)session.getAttribute("UsereMailId");
		UserAccount userAccount=signUpDao.getUserAccount(currUserEmailID);
		
		List<UserCar> usercarList=userAccount.getUserCar();
		List completeUserReservationList=new ArrayList<UsercarReservation>();
		
		for(UserCar userCar:usercarList)
		{
		List<UsercarReservation> reservationByCar= signUpDao.getReservationByUserCar(userCar);
		
		if(reservationByCar.size()>0)
		{
			completeUserReservationList.addAll(reservationByCar);
		}
		}
		
		mv.addObject("usereservationsList",completeUserReservationList);
		mv.setViewName("showListOfUserReservations");
		return mv;
	}
	
	
	@RequestMapping(value="/cancelReservation.htm", method = RequestMethod.POST)
	public ModelAndView cancelReservation(HttpServletRequest request) 
	{
		String selectedResevation=request.getParameter("selectedReservation");
		
		int selectedResevationInt=Integer.parseInt(selectedResevation);
		UsercarReservation usercarReservation=signUpDao.getReservationByID(selectedResevationInt); 
		
		usercarReservation.setBookingStatus("Cancelled");
		
		signUpDao.saveUsercarReservation(usercarReservation);
		
		HttpSession session=(HttpSession) request.getSession();
		ModelAndView mv= new ModelAndView();
		String currUserEmailID=(String)session.getAttribute("UsereMailId");
		UserAccount userAccount=signUpDao.getUserAccount(currUserEmailID);
		
		List<UsercarReservation> usereservations=userAccount.getUsercarReservations();
		
		mv.addObject("usereservationsList", usereservations);
		mv.setViewName("showListOfUserReservations");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/tosigninpage.htm", method = RequestMethod.GET)
	public ModelAndView signIn(HttpServletRequest request) 
	{
		ModelAndView mv= new ModelAndView();
		
		mv.setViewName("signIn");
		return mv;
	}
	
	@RequestMapping(value="/signup.htm", method = RequestMethod.POST)
	public ModelAndView signUp(HttpServletRequest request) 
	{
		
		HttpSession session=(HttpSession) request.getSession();
	
		String fName=request.getParameter("fName");
		String lName=request.getParameter("lName");
		String eMailId=request.getParameter("eMailId");
		String cNumber=request.getParameter("cNumber");
		String userPassword=request.getParameter("userPassword");
		
		String userLicense=request.getParameter("license");
		
		
		UserAccount isExisitUserAccount=signUpDao.getUserAccount(eMailId);
		ModelAndView mv= new ModelAndView(); 
		if(isExisitUserAccount!=null)
		{
			mv.setViewName("signUp");	
			mv.addObject("isValid", "Email is already registered");
		}
		else
		{
			UserAccount userAccount= new UserAccount();
			userAccount.setFirstName(fName);
			userAccount.setLastName(lName);
			userAccount.setEmailID(eMailId);
			userAccount.setContactNumber(cNumber);
			userAccount.setPassword(userPassword);
			userAccount.setUserLicenseNo(userLicense);
			
			//signUpDao.savePersonProfile(userAccount);
			
			
			mv.setViewName("address");
			session.setAttribute("UsereMailId", eMailId);
			session.setAttribute("userAccount", userAccount);
		}
		
		return mv;	
	}
	
	@RequestMapping(value="/address.htm", method = RequestMethod.POST)
	public ModelAndView saveAddress(HttpServletRequest request) 
	{
			
		String streetName=request.getParameter("streetName");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String zipcode=request.getParameter("zipcode");
		
		
		Address address=new Address();
		address.setStreetName(streetName);
		address.setCity(city);
		address.setState(state);
		address.setCountry(country);
		int intzipCode=Integer.parseInt(zipcode);
		address.setZipcode(intzipCode);
		
		HttpSession session=(HttpSession) request.getSession();
		String UsereMailId=(String) session.getAttribute("UsereMailId");
		
		//UserAccount userAccount=signUpDao.getUserAccount(UsereMailId);
		UserAccount userAccount=(UserAccount)session.getAttribute("userAccount");
		address.setUserAccount(userAccount);
		List <Address> userAddress=new ArrayList<Address>();
		userAddress.add(address);
		userAccount.setAddresses(userAddress);
		//signUpDao.saveAddress(address);
		ModelAndView mv= new ModelAndView();
		session.setAttribute("userAccount",userAccount);
		mv.setViewName("accountDetails");
		return mv;	
	}
	
	@RequestMapping(value="/account.htm", method = RequestMethod.POST)
	public ModelAndView saveAccountDetails(HttpServletRequest request) 
	{
		
		
		String bankName=request.getParameter("bankName");
		String accountHolderName=request.getParameter("accountHolderName");
		String accounttype=request.getParameter("accounttype");
		String accountNumber=request.getParameter("accountNumber");
		String routingNumber=request.getParameter("routingNumber");
		
		AccountDetails accountDetails= new AccountDetails();
		accountDetails.setAccountHolderName(accountHolderName);
		accountDetails.setBankName(bankName);
		accountDetails.setAccounttype(accounttype);
		
		int intaccountNumber=Integer.parseInt(accountNumber);
		accountDetails.setAccountNumber(intaccountNumber);
		
		int introutingNumber=Integer.parseInt(routingNumber);
		accountDetails.setRoutingNumber(introutingNumber);
		
		HttpSession session=(HttpSession) request.getSession();
		String UsereMailId=(String) session.getAttribute("UsereMailId");
		
		UserAccount userAccount=(UserAccount)session.getAttribute("userAccount");
		//UserAccount userAccount=signUpDao.getUserAccount(UsereMailId);
		//userAccount.setAccountDetails(accountDetails);
		
		userAccount.setAccountDetails(accountDetails);
		accountDetails.setUserAccount(userAccount);
		signUpDao.savePersonProfile(userAccount);
		
		//session.setAttribute("userAccount",userAccount);
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("home");
		return mv;	
	}
	
	@RequestMapping(value="/registercar.htm", method = RequestMethod.POST)
	public ModelAndView registerCar(HttpServletRequest request) 
	{
		String carCompanyName=request.getParameter("carCompanyName");
		String carModel=request.getParameter("carModel");
		String carNumner=request.getParameter("carNumner");
		String carimageName=request.getParameter("carimageName");
		String carDescription=request.getParameter("carDescription");
		String purchaseYear=request.getParameter("purchaseYear");
		String autoGear=request.getParameter("autoGear");
		String carAverage=request.getParameter("carAverage");
		
		UserCar usercar= new UserCar();
		usercar.setCarCompanyName(carCompanyName);
		usercar.setCarModel(carModel);
		usercar.setCarNumner(carNumner);
		usercar.setCarimageName(carimageName);
		usercar.setCarDescription(carDescription);
		usercar.setPurchaseYear(purchaseYear);
		
		CarDetails carDetails= signUpDao.getCarDetails(carCompanyName,carModel);
		
		usercar.setCarDetails(carDetails);
	
		
		boolean boolautoGear=Boolean.valueOf(autoGear);
		usercar.setAutoGear(boolautoGear);
		
		int intcarAverage=Integer.parseInt(carAverage);
		usercar.setCarAverage(intcarAverage);
		
		// dao to save  
		HttpSession session=(HttpSession) request.getSession();
		String UsereMailId=(String) session.getAttribute("UsereMailId");
		
		UserAccount userAccount=signUpDao.getUserAccount(UsereMailId);
		
		usercar.setUserAccount(userAccount);
		
		
		session.setAttribute("usercar", usercar);
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("insuranceDetails");
		return mv;	
	}
	
	
	@RequestMapping(value="/insurance.htm", method = RequestMethod.POST)
	public ModelAndView insurance(HttpServletRequest request) throws ParseException 
	{
		String carOwnerName=request.getParameter("carOwnerName");
		String insuranceCmpName=request.getParameter("insuranceCmpName");
		String carOwnerLicenseNo=request.getParameter("carOwnerLicenseNo");
		String policyNumber=request.getParameter("policyNumber");
		String insuranceStartDate=request.getParameter("insuranceStartDate");
		String insuranceEndDate=request.getParameter("insuranceEndDate");
		
		CarInsurance carInsurance= new CarInsurance();
		carInsurance.setCarOwnerName(carOwnerName);
		carInsurance.setInsuranceCmpName(insuranceCmpName);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		carInsurance.setCarOwnerLicenseNo(carOwnerLicenseNo);
		carInsurance.setPolicyNumber(policyNumber);
		
		Date finalinsuranceStartDate=formatter.parse(insuranceStartDate);
		carInsurance.setInsuranceStartDate(finalinsuranceStartDate);
		
		Date finsuranceEndDate=formatter.parse(insuranceEndDate);
		carInsurance.setInsuranceEndDate(finsuranceEndDate);
		
		HttpSession session=(HttpSession) request.getSession();
		UserCar userCar=(UserCar)session.getAttribute("usercar");
		
		userCar.setCarInsurance(carInsurance);
		carInsurance.setUserCar(userCar);
		
		UserCar saveduserCar=signUpDao.saveUsercar(userCar);
		session.setAttribute("carID", saveduserCar.getUserCarID());
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("carAvailableTime");
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/availableTime.htm", method = RequestMethod.POST)
	public ModelAndView availability(HttpServletRequest request) throws ParseException 
	{
		
		HttpSession session=(HttpSession) request.getSession();
	
		String stravailableFromDate=request.getParameter("availableFromDate");
		String availableFromTime=request.getParameter("availableFromTime");
		
		
		String stravailableToDate=request.getParameter("availableToDate");
		String availableToTime=request.getParameter("availableToTime");
		
		
		String hoursRate=request.getParameter("hoursRate");
		String dayRates=request.getParameter("dayRates");
	
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Date availableFromDate = formatter.parse(stravailableFromDate);
		Date availableToDate = formatter.parse(stravailableToDate);
		
		Availability availability=new Availability();
		availability.setAvailableFrom(availableFromDate);
		availability.setAvailableFromTime(availableFromTime);
		
		availability.setAvailableTo(availableToDate);
		availability.setAvailableToTime(availableToTime);
		
		int inthoursRate=Integer.parseInt(hoursRate);
		availability.setHoursRate(inthoursRate);
		
		int intdayRate=Integer.parseInt(dayRates);
		availability.setDayRates(intdayRate);
		String strcarID=request.getParameter("carID");
		if(strcarID==null)
		{
			strcarID=(String)session.getAttribute("carID");
		}
			int carID=Integer.parseInt(strcarID);
		
		
		UserCar userCar=signUpDao.getUserCarByID(carID);
		
		availability.setUserCar(userCar);
		
		session.setAttribute("availability", availability);
		//signUpDao.saveAvailability(availability);
		
		// dao to save
		
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("carParkingAddress");
		return mv;	
		
	}
	
	@RequestMapping(value="/carParkingaddress.htm", method = RequestMethod.POST)
	public ModelAndView carParkingaddress(HttpServletRequest request) throws ParseException 
	{
		
		HttpSession session=(HttpSession) request.getSession();
		String UsereMailId=(String) session.getAttribute("UsereMailId");
		
		String streetName=request.getParameter("streetName");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String zipcode=request.getParameter("zipcode");
		
		
		CarParkingaddress carParkingaddress=new CarParkingaddress();
		carParkingaddress.setStreetName(streetName);
		carParkingaddress.setCity(city);
		carParkingaddress.setState(state);
		carParkingaddress.setCountry(country);
		int intzipCode=Integer.parseInt(zipcode);
		carParkingaddress.setZipcode(intzipCode);
		Availability availability=(Availability)session.getAttribute("availability");
		
		
		String carAddress=carParkingaddress.getStreetName()+","+carParkingaddress.getCity()+","+carParkingaddress.getState()+","+carParkingaddress.getCountry()+","+carParkingaddress.getZipcode();
		
		AddressConverter addressConverter= new AddressConverter();
//		String latitude=addressConverter.getLatitude(carAddress);
//		String longitude=addressConverter.getLongitude(carAddress);
		Float fLatitude=Float.parseFloat("41.00");
		Float fLongitude=Float.parseFloat("71.12");
		
		
		availability.setLocationlatitude(fLatitude);
		availability.setLocationlongitude(fLongitude);
		//carParkingaddress.setAvailability(availability);
		
		CarParkingaddress carParkingaddress_WithID=signUpDao.saveCarParkingAddress(carParkingaddress);
		availability.setCarParkingaddress(carParkingaddress_WithID);
		
		signUpDao.saveAvailability(availability);
		
		AllMasterAvailability ama=new AllMasterAvailability();
		
		ama.setUserCar(availability.getUserCar());
		ama.setAvailableDateFrom(availability.getAvailableFrom());
		ama.setAvailableTimeFrom(availability.getAvailableFromTime());
		ama.setAvailableDateTo(availability.getAvailableTo());
		ama.setAvailableTimeTo(availability.getAvailableToTime());
		ama.setDayRates(availability.getDayRates());
		ama.setHoursRate(availability.getHoursRate());
		ama.setIsActive(true);
		ama.setIsBooked(false);
		ama.setIsAvailable(true);
		ama.setCarParkingaddress(carParkingaddress_WithID);
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date avaFrom=availability.getAvailableFrom();	
		String availTimeFrom=availability.getAvailableToTime();
		String strHtime=availTimeFrom.substring(0,2);		
		String strMtime=availTimeFrom.substring(3,5);
        Calendar c = Calendar.getInstance(); 
        c.setTime(avaFrom); 
        int hTime=Integer.parseInt(strHtime);
        int mTime=Integer.parseInt(strMtime);
        c.add(Calendar.HOUR, hTime);
        c.add(Calendar.MINUTE, mTime);
        avaFrom = c.getTime();
        System.out.println("from DAte -->"+avaFrom);
        
        Date avaTo=availability.getAvailableTo();
        String availTimeTo=availability.getAvailableToTime();
        
        String avalHtimeTo=availTimeTo.substring(0,2);
        String avalMtimeTo=availTimeTo.substring(3,5);
        
        c.setTime(avaTo);
        int tohTime=Integer.parseInt(avalHtimeTo);
        int toMTime=Integer.parseInt(avalMtimeTo);
        c.add(Calendar.HOUR, tohTime);
        c.add(Calendar.MINUTE,toMTime);
        System.out.println("To DAte -->"+avaTo);
        
        long toTimeAvailableTime=avaTo.getTime()-avaFrom.getTime();
        
        
        ama.setTotalAvailableTime((int)(toTimeAvailableTime/(60 * 60 * 1000)));
        
      signUpDao.saveMasterAvailability(ama);
        
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("home");
		return mv;	
	}
	
	@RequestMapping(value="/postavailableTime.htm", method = RequestMethod.GET)
	public ModelAndView postavailability(HttpServletRequest request) throws ParseException 
	{
		
		String strcarID=request.getParameter("carID");
		int carID=Integer.parseInt(strcarID);
		
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("carAvailableTime");
		mv.addObject("carID",carID);
		return mv;	
		
	}
	
	@RequestMapping(value="/carMakersList.htm", method = RequestMethod.POST)
	public void carMakersList(HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException, JSONException 
	{
		
		List<String> makersList=signUpDao.makerList();
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		obj.put("resultsortedMap", makersList);
		out.println(obj);
		//return makersList;
	}
	
	@RequestMapping(value="/carModelsList.htm", method = RequestMethod.POST)
	public void carModelsList(HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException, JSONException 
	{
		String makerName=request.getParameter("makerName");
		makerName="Toyota";
		List<String> modelsList=signUpDao.modelList(makerName);
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		obj.put("resultsortedMap", modelsList);
		out.println(obj);
		//return makersList;
	}
	
	
	
	@RequestMapping(value="/aCarviewallPost.htm", method = RequestMethod.GET)
	public ModelAndView aCarviewallPost(HttpServletRequest request) throws ParseException 
	{
		
		String strcarID=request.getParameter("carID");
		int carID=Integer.parseInt(strcarID);
		
		
		List<Availability> aCarAvailList=signUpDao.getUserCarAllAvailablePost(carID);
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("showAvailList");
		mv.addObject("aCarAvailList",aCarAvailList);
		return mv;	
		
	}
	
	
	@RequestMapping(value="/showAllMyPost.htm", method = RequestMethod.GET)
	public ModelAndView showAllmyPost(HttpServletRequest request) throws ParseException 
	{
	
		HttpSession session=(HttpSession) request.getSession();
		String UsereMailId=(String) session.getAttribute("UsereMailId");
		
		UserAccount userAccount=signUpDao.getUserAccount(UsereMailId);
		
		List<UserCar> userCars=userAccount.getUserCar();
		
		System.out.print("userCars--->"+userCars.size());
		System.out.print("avail--->"+userCars.get(0).getAvailabilities().size());
		System.out.print("userCars--->"+userCars.size());
		
		List<Availability>  availability=userCars.get(0).getAvailabilities();
		
		ModelAndView mv= new ModelAndView(); 
		mv.setViewName("showAllYourPost");
		mv.addObject("userCars",userCars);
		return mv;
		
	}
	
	@RequestMapping(value="/showAllMyPostIOS", method = RequestMethod.GET)
	@ResponseBody
	public List showAllmyPostIOS(HttpServletRequest request) throws ParseException 
	{
	
		HttpSession session=(HttpSession) request.getSession();
		String UsereMailId=(String) session.getAttribute("UsereMailId");
		
		UsereMailId=request.getParameter("UsereMailId");
		
		UserAccount userAccount=signUpDao.getUserAccount(UsereMailId);
		
		List<UserCar> userCars=userAccount.getUserCar();
		
		System.out.print("userCars--->"+userCars.size());
		System.out.print("avail--->"+userCars.get(0).getAvailabilities().size());
		System.out.print("userCars--->"+userCars.size());
		
		List<Availability>  availability=userCars.get(0).getAvailabilities();
		
		return userCars;
		
	}
	
	@RequestMapping(value="/getCarFilteredValueByType.htm",method=RequestMethod.POST)
	public void getHotelFilteredValue(HttpServletRequest hrs, HttpServletResponse hsr) throws ParseException, JSONException, IOException
		{
			///ModelAndView mv= new ModelAndView();
		    //List<Hotel> searchResultList= new ArrayList();
			String selectedvals=hrs.getParameter("selectedType");
			System.out.println("checkIndate--->"+selectedvals);
			
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date currentDate= new Date();
			
			System.out.println("current Date--->"+currentDate);
			Date after2oDays=new Date();
			after2oDays.setTime(currentDate.getTime()+20 *1000 * 60 * 60 * 24);
			
			List<AllMasterAvailability> allAvailCars=signUpDao.getAvailCarBetweenDates(currentDate,after2oDays);
			
			
			
		}
	
}
