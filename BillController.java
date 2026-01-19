package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bill;
import com.example.demo.service.BillServiceimpl;

@RestController
@RequestMapping ("Hospital/")
public class BillController {
	
	@Autowired
	BillServiceimpl billServiceimpl;
	
	
	@PostMapping ("Bill")
	public String save(@RequestBody Bill b) {
		billServiceimpl.addBill(b);
		return " saved bill";	
	}
	@GetMapping ("Bill/{id}")
	public Bill  getBillbyid(@PathVariable int id) {
		 return billServiceimpl .getBill(id);
		
	}
	
	@GetMapping ("Bill")
	public List<Bill> getAllBill(){
		return billServiceimpl.getAllBill();
	}

	@DeleteMapping ("Bill/{id}")
	public String  deleteBillByid(@PathVariable int id) {
		billServiceimpl.deleteBillByid(id);
		return "Bill is deleted";
	}
	@DeleteMapping ("Bill")
	public String deleteAllBill() {
		billServiceimpl.deleteAll();
		return "All bill is deleted";
	}
	
	@PutMapping ("Bill/{id}")
	public Bill updateBill(@PathVariable int id , @RequestBody Bill b) {
	return 	billServiceimpl.UpdateBill(id, b);
	
	}
}
