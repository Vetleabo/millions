package edu.ntnu.idatx2003.vab.millions;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Vetle Aune Bøhmer
 */
class ShareTest {

  private Stock stock;
  private BigDecimal quantity;
  private BigDecimal purchasePrice;

  @BeforeEach
  void setUp() {
    stock = new Stock("APPL", "Apple Inc.");
    quantity = new BigDecimal("10");
    purchasePrice = new BigDecimal("100.00");
  }

  @Nested
  class PositiveTests {

    @Test
    void constructorCreatesShareSuccessfully() {

      // Act
      Share share = new Share(stock, quantity, purchasePrice);

      // Assert
      assertEquals(stock, share.getStock());
      assertEquals(quantity, share.getQuantity());
      assertEquals(purchasePrice, share.getPurchasePrice());
    }
  }

  @Nested
  class NegativeTests {

    @Test
    void constructorThrowsWhenStockIsNull() {

      // Arrange
      Stock invalidStock = null;

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Share(invalidStock, quantity, purchasePrice));
    }

    @Test
    void constructorThrowsWhenQuantityIsNull() {

      // Arrange
      BigDecimal invalidQuantity = null;

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Share(stock, invalidQuantity, purchasePrice));
    }

    @Test
    void constructorThrowsWhenQuantityIsZero() {

      // Arrange
      BigDecimal invalidQuantity = BigDecimal.ZERO;

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Share(stock, invalidQuantity, purchasePrice));
    }

    @Test
    void constructorThrowsWhenQuantityIsNegative() {

      // Arrange
      BigDecimal invalidQuantity = new BigDecimal("-1");

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Share(stock, invalidQuantity, purchasePrice));
    }

    @Test
    void constructorThrowsWhenPurchasePriceIsNull() {

      // Arrange
      BigDecimal invalidPurchasePrice = null;

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Share(stock, quantity, invalidPurchasePrice));
    }

    @Test
    void constructorThrowsWhenPurchasePriceIsZero() {

      // Arrange
      BigDecimal invalidPurchasePrice = BigDecimal.ZERO;

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Share(stock, quantity, invalidPurchasePrice));
    }

    @Test
    void constructorThrowsWhenPurchasePriceIsNegative() {

      // Arrange
      BigDecimal invalidPurchasePrice = new BigDecimal("-1");

      // Act & Assert
      assertThrows(IllegalArgumentException.class,
          () -> new Share(stock, quantity, invalidPurchasePrice));
    }
  }
}
