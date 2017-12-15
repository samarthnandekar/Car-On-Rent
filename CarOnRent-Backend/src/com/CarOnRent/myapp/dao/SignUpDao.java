package com.CarOnRent.myapp.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.CarOnRent.myapp.pojo.Address;
import com.CarOnRent.myapp.pojo.AllMasterAvailability;
import com.CarOnRent.myapp.pojo.Availability;
import com.CarOnRent.myapp.pojo.CarDetails;
import com.CarOnRent.myapp.pojo.CarModel;
import com.CarOnRent.myapp.pojo.CarParkingaddress;
import com.CarOnRent.myapp.pojo.UserAccount;
import com.CarOnRent.myapp.pojo.UserCar;
import com.CarOnRent.myapp.pojo.UsercarReservation;

public class SignUpDao extends Dao{
	
	public SignUpDao()
	{
		
	}

	public UserAccount savePersonProfile(UserAccount userAccount)
	{
		
		try{
		begin();
		getSession().saveOrUpdate(userAccount);   
        commit();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		return userAccount;
	}
	
	public UsercarReservation getReservationByID(int selectedResevationInt)
	{
		UsercarReservation usercarReservation=null;
		
		try{
			Query q=getSession().createQuery("from UsercarReservation where usercarReservationID= :intselectedVailID");
			q.setInteger("intselectedVailID", selectedResevationInt);
			usercarReservation=(UsercarReservation)q.uniqueResult();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating UsercarReservation: " + e.getMessage());
    }	
		return usercarReservation;
	}
	

	public List<UsercarReservation> getReservationByUserCar(UserCar userCar)
	{
		List<UsercarReservation> usercarReservation=null;
		
		int carID=userCar.getUserCarID();
		try{
			Query q=getSession().createQuery("from UsercarReservation where userCar= :intCarlID");
			q.setInteger("intCarlID", carID);
			usercarReservation=q.list();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating UsercarReservation: " + e.getMessage());
    }	
		return usercarReservation;
	}
	
	
	public CarParkingaddress saveCarParkingAddress(CarParkingaddress carParkingaddress)
	{
		boolean issuccess=false;
		try{
		begin();
		getSession().save(carParkingaddress);   
        commit();
        issuccess=true;
        
    } catch (HibernateException e) {
    	issuccess=false;
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while saving CarParkingaddress: " + e.getMessage());
    }

		return carParkingaddress;
	}
	
	
	public boolean confirmReservationAndPayment(UsercarReservation sercarReservation)
	{
		boolean issuccess=false;
		try{
		begin();
		getSession().save(sercarReservation);   
        commit();
        issuccess=true;
        
    } catch (HibernateException e) {
    	issuccess=false;
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while saving carReservation: " + e.getMessage());
    }

		return issuccess;
	}
	
	public boolean saveUsercarReservation(UsercarReservation sercarReservation)
	{
		boolean issuccess=false;
		try{
		begin();
		getSession().save(sercarReservation);   
        commit();
        issuccess=true;
        
    } catch (HibernateException e) {
    	issuccess=false;
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while saving carReservation: " + e.getMessage());
    }

		return issuccess;
	}
	
	public AllMasterAvailability getAvailabilityByID(String selectedVailID)
	{
		AllMasterAvailability avilabiltyfromMaster=null;
		
		int intselectedVailID=Integer.parseInt(selectedVailID);
		try{
			Query q=getSession().createQuery("from AllMasterAvailability where masterAvailabilityID= :intselectedVailID");
			q.setInteger("intselectedVailID", intselectedVailID);
			avilabiltyfromMaster=(AllMasterAvailability)q.uniqueResult();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }	
		return avilabiltyfromMaster;
		
		
	}
	
	
	public CarDetails getCarDetails(String carCompanyName,String carModel)
	{
		CarDetails carDetails=null;
		
		try{
			//select * from allmasteravailability where availableDateFrom >='2016-11-11' AND availableDateTo <='2016-11-12';
			Query q=getSession().createQuery("from CarDetails where carMaker= :carCmpName AND carModel = :carModel");
			q.setString("carCmpName", carCompanyName);
			q.setString("carModel", carModel);
			carDetails=(CarDetails)q.uniqueResult();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }
		
		
		return carDetails;
	
	}
	
	
	
	public List<AllMasterAvailability> getAvailCarBetweenDates(Date fromDate, Date toDate)
	{
		List<AllMasterAvailability> availCarsList=null;
		try{
			//select * from allmasteravailability where availableDateFrom >='2016-11-11' AND availableDateTo <='2016-11-12';
			Query q=getSession().createQuery("from AllMasterAvailability where availableDateFrom>= :availFrom AND availableDateTo <= :availTo");
			q.setDate("availFrom", fromDate);
			q.setDate("availTo", toDate);
			availCarsList=q.list();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		return availCarsList;
	}
	
	
	public List<String> makerList()
	{
		List<String> carMakers=null;
		try{
			
			Query q=getSession().createQuery("select makerName from Carmaker");
			carMakers=q.list();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		return carMakers;
	}
	
	
	public List<String> modelList(String modelName)
	{
		List<String> carModels=null;
		try{
	        
			Query q=getSession().createQuery("select cm.modelName from CarModel as cm where cm.carmaker.makerName=:ModelVal");
			//Query q=getSession().createQuery("from CarModel");
			q.setString("ModelVal", modelName);
			carModels=q.list();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while getting car Models: " + e.getMessage());
    }

		return carModels;
	}
	
	
	public void saveMasterAvailability(AllMasterAvailability ama)
	{
		
		try{
		begin();
		getSession().save(ama);   
        commit();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		//return ama;
	}
	
	
	public UserAccount getUserAccount(String usereMailID)
	{
		UserAccount userAccount=null;
		try{
			begin();
			Query q=getSession().createQuery("from UserAccount where emailID=:uemailID");
			q.setString("uemailID", usereMailID);
			userAccount=(UserAccount)q.uniqueResult();  
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		return userAccount;
	}
	
	
	public UserCar saveUsercar(UserCar usercar)
	{
		
		try{
		begin();
		getSession().save(usercar);   
        commit();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		return usercar;
	}
	
	
	public Address saveAddress(Address address)
	{
		
		try{
		begin();
		getSession().save(address);   
        commit();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		return address;
	}
	
	
	
	public UserCar getUserCarByID(int usercarID)
	{
		UserCar userCar=null;
		try{
			begin();
			Query q=getSession().createQuery("from UserCar where userCarID=:pusercarID");
			q.setInteger("pusercarID", usercarID);
			userCar=(UserCar)q.uniqueResult();  
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while creating Hotel: " + e.getMessage());
    }

		return userCar;
	}
	
	
	public Availability saveAvailability(Availability availability)
	{
		
		try{
		begin();
		getSession().save(availability);   
        commit();
        
    } catch (HibernateException e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
        System.out.println("Exception while saveing the availability: " + e.getMessage());
    }

		return availability;
	}

	
	public List<Availability>getUserCarAllAvailablePost(int carID)
	{
		List<Availability> availList=null;
		
		try
		{
			Query q=getSession().createQuery("from Availability where userCarID=:carID");
			q.setInteger("carID", carID);
			availList=q.list();
		}
	catch (HibernateException e) {
	        rollback();
	        //throw new AdException("Could not create user " + username, e);
	        System.out.println("Exception while creating Hotel: " + e.getMessage());
	    }

		return availList;
	}
	
	
}
