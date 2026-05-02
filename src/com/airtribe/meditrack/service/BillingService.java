package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.interfaces.Payable;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;


public class BillingService implements Payable {

    private final DataStore<Bill> billStore;

    public BillingService(DataStore<Bill> billStore) {
        this.billStore = billStore;
    }

    @Override
    public Bill generateBill(String appointmentId, double fee) {
        Bill bill = new Bill(appointmentId, fee);
        billStore.add(bill);
        return bill;
    }

    public List<Bill> getAllBills() {
        return billStore.getAll();
    }

    //CSV
    public void loadBills(List<Bill> bills) {
        bills.forEach(billStore::add);
    }
}
