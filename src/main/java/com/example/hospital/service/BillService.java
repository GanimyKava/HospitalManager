package com.example.hospital.service;

import com.example.hospital.entity.Bill;
import java.util.List;

public interface BillService {
    Bill saveBill(Bill bill);
    Bill getBill(Long id);
    List<Bill> getAllBills();
    void deleteBill(Long id);
    void deleteAllBills();
    Bill updateBill(Long id, Bill bill);
}
