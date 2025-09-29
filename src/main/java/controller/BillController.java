package controller;

import dao.BillDao;
import model.Bill;

public class BillController extends GenericController<Bill>{
    public BillController(BillDao billDao){
        super(billDao);
    }

    // Add specific rules here
}
