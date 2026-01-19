package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bill;
import com.example.demo.repo.Billrepo;

@Service
public class BillServiceimpl {

	
	@Autowired
	Billrepo billrepo;
	
	public void addBill(Bill b) {
		billrepo.save(b);
		
	}
	
	public List<Bill> getAllBill(){
		return billrepo.findAll();
		
	}
	
	public Bill getBill(int id) {
		return billrepo.findById(id).get();
	}
	
	public void deleteAll() {
		billrepo.deleteAll();
	}
	public void deleteBillByid(int id) {
		billrepo.deleteById(id);
	}
	
	public Bill UpdateBill(int id , Bill newdata) {
		Bill existingBill=billrepo.findById(id) 
        .orElseThrow(()-> new RuntimeException("patients not found "));
		existingBill.setAmount(newdata.getAmount());
		existingBill.setPatid(newdata.getPatid());
		existingBill.setStatus(newdata.getStatus());
		return billrepo.save(existingBill);
		
		
	}
}
