package edu.ntnu.idatx2003.vab.millions;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PortfolioTest {

  private Portfolio portfolio;
  private Stock appleStock;
  private Share appleShare;

  @BeforeEach
  void setUp() {
    Portfolio portfolio = new Portfolio();

    Stock appleStock = new Stock("APPL", "Apple Inc.");
    appleStock.addNewSalesPrice(new BigDecimal("100"));

    Share appleShare = new Share(
        appleStock,
        new BigDecimal("10"),
        new BigDecimal("100"));
  }

  @Nested
  class PositiveTests {

    @Test
    void addShareAddsShareSuccessfully() {

      // Act
      boolean result = portfolio.addShare(appleShare);

      // Assert
      assertTrue(result);
      assertTrue(portfolio.contains(appleShare));
      assertEquals(1, portfolio.getShares().size());
    }

    @Test
    void removeShareRemovesShareSuccessfully() {

      // Arrange
      portfolio.addShare(appleShare);

      // Act
      boolean removed = portfolio.removeShare(appleShare);

      // Arrange
      assertTrue(removed);
      assertFalse(portfolio.contains(appleShare));
      assertEquals(0, portfolio.getShares().size());
    }

  }


}
