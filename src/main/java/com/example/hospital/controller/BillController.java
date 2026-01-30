package com.example.hospital.controller;

import com.example.hospital.entity.Bill;
import com.example.hospital.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@PostMapping
	public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
		return new ResponseEntity<>(billService.saveBill(bill), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Bill>> getAllBills(){
		return ResponseEntity.ok(billService.getAllBills());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bill> getBill(@PathVariable Long id) {
		return ResponseEntity.ok(billService.getBill(id));
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllBills() {
		billService.deleteAllBills();
		return ResponseEntity.ok("All bills deleted successfully");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBill(@PathVariable Long id) {
		billService.deleteBill(id);
		return ResponseEntity.ok("Bill deleted successfully");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill bill) {
		return ResponseEntity.ok(billService.updateBill(id, bill));
	}
}
