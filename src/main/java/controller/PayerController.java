package controller;

import dao.PayerDao;
import model.Payer;

public class PayerController extends GenericController<Payer>{
    public PayerController(PayerDao payerDao){
        super(payerDao);
    }

    // Add specific rules here
}
