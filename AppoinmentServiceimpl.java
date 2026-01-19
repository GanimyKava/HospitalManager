package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appoinment;
import com.example.demo.repo.Appoinmentrepo;

@Service
public class AppoinmentServiceimpl {
	
	@Autowired
	Appoinmentrepo appoinmentrepo;
	
	public void addAppoinment(Appoinment a) {
		appoinmentrepo.save(a);
	}
	
	public Appoinment getAppoinment(int id) {
	return 	appoinmentrepo.findById(id).get();
	}
	
	public List<Appoinment> getAllAppoinment (){
		return appoinmentrepo.findAll();
	}
	
    public void deleteAppoinment (int id) {
    	appoinmentrepo.deleteById(id);
    }
    public void deleteAllAppoinment() {
    	appoinmentrepo.findAll();
    }
    public Appoinment updateAppoinment(int id , Appoinment newdata ) {
    	Appoinment existingdata= appoinmentrepo.findById(id)
    			.orElseThrow(()-> new RuntimeException("Appoinment Not found"));
    	
    	existingdata.setDate(newdata.getDate());
    	existingdata.setDoctid(newdata.getDoctid());
    	existingdata.setPatid(newdata.getPatid());
    	
    	return appoinmentrepo.save(existingdata);
    	
    }
}
