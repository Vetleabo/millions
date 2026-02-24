package edu.ntnu.idatx2003.vab.millions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a portfolio containing a collection of shares.
 * A portfolio allows adding, removing, retrieving and checkin ownership of shares
 * @author Vetle Aune Bøhmer
 */
public class Portfolio {

  // ================
  // Fields
  // ================

  private List<Share> shares;

  // ================
  // Constructor
  // ================

  /**
   * Creates an empty portfolio
   */
  public Portfolio() {
    this.shares = new ArrayList<>();
  }

  // ================
  // Portfolio operations
  // ================

  /**
   * Adds a share to the portfolio.
   * @param share the share to be added
   * @return true if the share was added
   * @throws IllegalArgumentException if share is null
   */
  public boolean addShare(Share share) {
    if (share == null) {
      throw new IllegalArgumentException("share cant be null");
    }
    return shares.add(share);
  }

  /**
   * Removes a share from the portfolio.
   * @param share the share to remove
   * @return true if the share was removed
   * @throws IllegalArgumentException if share is null
   */
  public boolean removeShare(Share share) {
    if (share == null) {
      throw new IllegalArgumentException("share cant be null");
    }
    return shares.remove(share);
  }

  /**
   * Returns an unmodifiable copy of all shares in the portfolio.
   * @return a list containing all shares
   */
  public List<Share> getShares() {
    return List.copyOf(shares);
  }

  /**
   * Returns all shares in the portfolio that match the given stock symbol.
   * @param symbol the stock symbol to filter by
   * @return a list of shares with the given symbol
   * @throws IllegalArgumentException if symbol is null or blank
   */
  public List<Share> getShares(String symbol) {
    if (symbol == null || symbol.isBlank()) {
      throw new IllegalArgumentException("symbol cant be null or blank");
    }

    return shares.stream().filter(share -> share.getStock().getSymbol().equals(symbol))
        .collect(Collectors.toList());
  }

  /**
   * Checks whether the portfolio contains the given share.
   * @param share the share to check
   * @return true if the share exists in the portfolio
   * @throws IllegalArgumentException if share is null
   */
  public boolean contains(Share share) {
    if (share == null) {
      throw new IllegalArgumentException("share cant be null");
    }
    return shares.contains(share);
  }
}
