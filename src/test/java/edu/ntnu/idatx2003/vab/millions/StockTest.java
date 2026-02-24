package edu.ntnu.idatx2003.vab.millions;

import java.math.BigDecimal;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the stock class.
 * Tests both positive and negative scenarios
 * using the AAA pattern and nested test structure.
 * @author Vetle Aune Bøhmer
 */
class StockTest {

  // ================
  // Positive tests
  // ================

  @Nested
  class PositiveTests {

    @Test
    void addNewSalesPriceAddsPriceSuccessfully() {

      // Arrange
      Stock stock = new Stock("APPL", "Apple Inc.");
      BigDecimal price = new BigDecimal("100.00");

      // Act
      stock.addNewSalesPrice(price);
      BigDecimal result = stock.getSalesPrice();

      // Assert
      assertEquals(price, result);
    }
  }

  // ================
  // Negative tests
  // ================

  @Nested
  class NegativeTests {

    @Test
    void constructorThrowsWhenSymbolIsNull() {

      // Arrange
      String invalidSymbol = null;
      String validCompany = "Apple Inc.";

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Stock(invalidSymbol, validCompany));
    }

    @Test
    void constructorThrowsWhenSymbolIsBlank() {

      // Arrange
      String invalidSymbol = "  ";
      String validCompany = "Apple Inc.";

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Stock(invalidSymbol, validCompany));
    }

    @Test
    void constructorThrowsWhenCompanyIsNull() {

      // Arrange
      String validSymbol = "APPL";
      String invalidCompany = null;

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Stock(validSymbol, invalidCompany));
    }

    @Test
    void constructorThrowsWhenCompanyIsBlank() {

      // Arrange
      String validSymbol = "APPL";
      String invalidCompany = "   ";

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Stock(validSymbol, invalidCompany));
    }

    @Test
    void addNewSalesPriceThrowsWhenPriceIsNegative() {

      // Arrange
      Stock stock = new Stock("APPL", "Apple Inc.");
      BigDecimal invalidPrice = new BigDecimal("-1");

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> stock.addNewSalesPrice(invalidPrice));
    }

    @Test
    void addNewSalesPriceThrowsWhenPriceIsZero() {

      // Arrange
      Stock stock = new Stock("APPL", "Apple Inc.");
      BigDecimal invalidPrice = new BigDecimal("0");

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> stock.addNewSalesPrice(invalidPrice));
    }

    @Test
    void addNewSalesPriceThrowsWhenPriceIsNull() {

      // Arrange
      Stock stock = new Stock("APPL", "Apple Inc.");
      BigDecimal invalidPrice = null;

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> stock.addNewSalesPrice(invalidPrice));
    }

    @Test
    void getSalesPriceThrowsWhenNoPrices() {

      // Arrange
      Stock stock = new Stock("APPL", "Apple Inc.");

      // Act & Assert
      assertThrows(IllegalStateException.class, stock::getSalesPrice);
    }
  }
}
