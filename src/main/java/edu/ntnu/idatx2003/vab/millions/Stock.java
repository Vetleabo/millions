package edu.ntnu.idatx2003.vab.millions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock listed on an exchange.
 * A stock is uniquely identified by its symbol.
 * The class maintains a history of sales prices in chronological order.
 * @author Vetle Aune Bøhmer
 */
public class Stock {

  // ================
  // Fields
  // ================

  private final String symbol;
  private final String company;
  private List<BigDecimal> prices;

  // ================
  // Constructor
  // ================

  /**
   * Creates a new stock.
   * @param symbol the unique stock symbol
   * @param company the company name
   * @throws IllegalArgumentException if symbol or company is null/blank
   */
  public Stock(String symbol, String company) {
    if (symbol == null || symbol.isBlank()) {
      throw new IllegalArgumentException("Symbol cannot be null or blank");
    }
    if (company == null || company.isBlank()) {
      throw new IllegalArgumentException("Company cannot be null or blank");
    }

    this.symbol = symbol;
    this.company = company;
    this.prices = new ArrayList<>();
  }

  // ================
  // Getters
  // ================

  /**
   * Returns the stock symbol.
   * @return the stock symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * Returns the company name.
   * @return the company name
   */
  public String getCompany() {
    return company;
  }

  // ================
  // Business Methods
  // ================

  /**
   * Registers a new sales price for the stock.
   * @param price the sales price to register
   * @throws IllegalArgumentException if price is null or not positive
   */
  public void addNewSalesPrice(BigDecimal price) {
    if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price must be positive");
    }
    prices.add(price);
  }

  /**
   * Returns the most recently registered sales price.
   * @return the latest sales price
   * @throws IllegalStateException if no prices are registered
   */
  public BigDecimal getSalesPrice() {
    if (prices.isEmpty()) {
      throw new IllegalStateException("No prices registered");
    }
    return prices.get(prices.size() - 1);
  }
}
