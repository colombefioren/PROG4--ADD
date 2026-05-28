package org.coco.add.service;

import static org.junit.jupiter.api.Assertions.*;

import org.coco.add.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MultiplyServiceTest extends FacadeIT {

  @Autowired private MultiplyService multiplyService;

  @Test
  void should_multiply_wallet_amount() {
    var a = 10L;
    var b = 4L;
    assertEquals(40, multiplyService.multiply(a, b));
  }

  @Test
  void should_throw_when_values_negative() {
    var a = -1L;
    var b = 10L;
    var e = assertThrows(IllegalArgumentException.class, () -> multiplyService.multiply(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

  @Test
  void should_throw_when_only_b_negative() {
    var a = 5L;
    var b = -3L;
    var e = assertThrows(IllegalArgumentException.class, () -> multiplyService.multiply(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

  @Test
  void should_handle_overflow_silently() {
    var a = Long.MAX_VALUE;
    var b = 2L;
    assertEquals(-2, multiplyService.multiply(a, b));
  }
}
