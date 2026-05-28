package org.coco.add.service;

import static org.junit.jupiter.api.Assertions.*;

import org.coco.add.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SubtractServiceTest extends FacadeIT {

  @Autowired private SubtractService subtractService;

  @Test
  void should_remove_money_from_wallet() {
    var a = 10L;
    var b = 4L;
    assertEquals(6, subtractService.subtract(a, b));
  }

  @Test
  void should_throw_when_values_negative() {
    var a = -1L;
    var b = 10L;
    var e = assertThrows(IllegalArgumentException.class, () -> subtractService.subtract(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

  @Test
  void should_throw_when_only_b_negative() {
    var a = 5L;
    var b = -3L;
    var e = assertThrows(IllegalArgumentException.class, () -> subtractService.subtract(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

}
