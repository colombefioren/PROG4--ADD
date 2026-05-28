package org.coco.add.service;

import org.springframework.stereotype.Service;

@Service
public class DivisionService {

  public long divide(long a, long b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("A and B should be positive");
    }
    if (b == 0) {
      throw new IllegalArgumentException("B should be non-zero");
    }
    return a / b;
  }
}
