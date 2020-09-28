package ru.startsev.budget.manager.service;

import ru.startsev.budget.manager.model.Purchase;

import java.util.Collection;

public interface PurchaseDAO {
    Collection<Purchase> findAll();

    void save(Purchase any);
}
