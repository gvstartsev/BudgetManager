package ru.startsev.budget.manager.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.startsev.budget.manager.model.Purchase;
import ru.startsev.budget.manager.model.PurchaseType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseServiceTest {
    private PurchaseService purchaseService;
    @Mock
    private PurchaseDAO purchaseDAO;

    @Before
    public void setUp() throws Exception {
        purchaseService = new PurchaseService(purchaseDAO);
    }

    @Test
    public void findAll_shouldReturnAllPurchases() {
        when(purchaseDAO.findAll()).thenReturn(Arrays.asList(new Purchase()));
        Collection<Purchase> allPurchases = purchaseService.findAll();

        // AAA - arrange, act, assert
        // 1. allPurchases is not null
        // 2. in some conditions, allPurchases contains records

        assertNotNull(allPurchases);
        assertFalse("expected to have more then zero element", allPurchases.isEmpty());
    }

    @Test
    public void save_inCaseNewRecordShouldBeCreated() {
        when(purchaseDAO.findAll()).thenReturn(Arrays.asList(new Purchase()));
        Purchase purchaseToSave = new Purchase();
        purchaseToSave.setName("name");
        purchaseToSave.setPrice(BigDecimal.valueOf(0.0));
        purchaseToSave.setType(PurchaseType.OTHER);
        Purchase savedPurchase = purchaseService.save(purchaseToSave);
        assertEquals(savedPurchase.getName(), purchaseToSave.getName());
        assertEquals(savedPurchase.getPrice(), purchaseToSave.getPrice());
        assertEquals(savedPurchase.getType(), purchaseToSave.getType());
        assertNotNull(savedPurchase.getId());
        assertEquals("expected id + 1", Integer.valueOf(2), savedPurchase.getId());
        verify(purchaseDAO, times(1)).save(any(Purchase.class));
    }
}