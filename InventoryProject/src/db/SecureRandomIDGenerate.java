/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author user
 */
import java.math.BigInteger;
import java.security.SecureRandom;

public final class SecureRandomIDGenerate {
  private SecureRandom random = new SecureRandom();

  public String getTagNumber() {
    return new BigInteger(50, random).toString(32);
  }
}