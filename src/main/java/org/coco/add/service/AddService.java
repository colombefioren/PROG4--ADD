package org.coco.add.service;

import org.springframework.stereotype.Service;

@Service
public class AddService {

  public long add(long a, long b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("A and B should be positive");
    }
    return a + b;
  }
}
