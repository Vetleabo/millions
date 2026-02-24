package edu.ntnu.idatx2003.vab.millions;

import java.math.BigDecimal;

/**
 * Represents ownership of a quantity of a specific stock.
 * The share stores the purchase price and quantity
 * @author Vetle Aune Bøhmer
 */
public class Share {

  // ================
  // Fields
  // ================

  private final Stock stock;
  private BigDecimal quantity;
  private BigDecimal purchasePrice;

  // ================
  // Constructor
  // ================

  /**
   * Creates a new share holding.
   * @param stock the stock this share refers to
   * @param quantity quantity number of shares owned
   * @param purchasePrice the purchase price
   * @throws IllegalArgumentException if any argument is invalid
   */
  public Share(Stock stock, BigDecimal quantity, BigDecimal purchasePrice) {
    if (stock == null) {
      throw new IllegalArgumentException("stock cant be null");
    }
    if(quantity == null || quantity.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("quantity must be positive");
    }
    if(purchasePrice == null || purchasePrice.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("purchase price must be positive");
    }

    this.stock = stock;
    this.quantity = quantity;
    this.purchasePrice = purchasePrice;
  }

  // ================
  // Getters
  // ================

  /**
   *
   * @return
   */
  public Stock getStock() {
    return this.stock;
  }

  /**
   *
   * @return
   */
  public BigDecimal getQuantity() {
    return this.quantity;
  }

  /**
   *
   * @return
   */
  public BigDecimal getPurchasePrice() {
    return this.purchasePrice;
  }
}
