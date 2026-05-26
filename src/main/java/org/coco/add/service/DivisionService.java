package org.coco.add.service;

import org.springframework.stereotype.Service;

@Service
public class DivisionService {

  public int divide(String a, String b) {
    if (a == null || b == null) {
      throw new IllegalArgumentException("A and B cannot be null");
    }
    try {
      var aValue = Integer.parseInt(a.trim());
      var bValue = Integer.parseInt(b.trim());
      if (aValue < 0 || bValue < 0) {
        throw new IllegalArgumentException("A and B should be positive");
      }
      if (bValue == 0) {
        throw new IllegalArgumentException("B should be non-zero");
      }
      return aValue / bValue;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Insert valid numbers");
    }
  }
}
