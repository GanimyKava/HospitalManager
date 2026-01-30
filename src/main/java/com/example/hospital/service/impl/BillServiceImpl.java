package com.example.hospital.service.impl;

import com.example.hospital.entity.Bill;
import com.example.hospital.repository.BillRepository;
import com.example.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public Bill saveBill(Bill b) {
		return billRepository.save(b);
	}
	
	@Override
	public List<Bill> getAllBills(){
		return billRepository.findAll();
	}
	
	@Override
	public Bill getBill(Long id) {
		return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));
	}
	
	@Override
	public void deleteAllBills() {
		billRepository.deleteAll();
	}

	@Override
	public void deleteBill(Long id) {
		billRepository.deleteById(id);
	}
	
	@Override
	public Bill updateBill(Long id , Bill newData) {
		Bill existingBill = billRepository.findById(id) 
                .orElseThrow(()-> new RuntimeException("Bill not found"));
		existingBill.setAmount(newData.getAmount());
		existingBill.setPatientId(newData.getPatientId());
		existingBill.setStatus(newData.getStatus());
		return billRepository.save(existingBill);
	}
}
