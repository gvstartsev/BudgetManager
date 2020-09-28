package ru.startsev.budget.manager.service;

import ru.startsev.budget.manager.model.Purchase;

import java.util.Collection;

public class PurchaseService {
    private PurchaseDAO purchaseDAO;

    public PurchaseService(PurchaseDAO purchaseDAO) {
        this.purchaseDAO = purchaseDAO;
    }

    public Collection<Purchase> findAll() {
        return purchaseDAO.findAll();
    }

    public Purchase save(Purchase purchase) {
        Collection<Purchase> allPurchases = findAll();
        purchase.setId(allPurchases.size() + 1);
        return purchase;
    }
}
