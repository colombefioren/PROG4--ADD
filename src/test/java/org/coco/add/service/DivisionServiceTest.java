package org.coco.add.service;

import static org.junit.jupiter.api.Assertions.*;

import org.coco.add.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DivisionServiceTest extends FacadeIT {

  @Autowired private DivisionService divisionService;

  @Test
  void should_divide_wallet_amount() {
    var a = 10L;
    var b = 4L;
    assertEquals(2, divisionService.divide(a, b));
  }

  @Test
  void should_throw_when_values_negative() {
    var a = -1L;
    var b = 10L;
    var e = assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

  @Test
  void should_throw_when_only_b_negative() {
    var a = 5L;
    var b = -3L;
    var e = assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

  @Test
  void should_throw_when_divide_by_zero() {
    var a = 10L;
    var b = 0L;
    var e = assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
    assertEquals("B should be non-zero", e.getMessage());
  }
}
