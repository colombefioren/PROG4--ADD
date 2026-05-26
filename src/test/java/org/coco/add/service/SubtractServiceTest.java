package org.coco.add.service;

import static org.junit.jupiter.api.Assertions.*;

import org.coco.add.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SubtractServiceTest extends FacadeIT {

  @Autowired private SubtractService subtractService;

  @Test
  void should_return_difference() {
    var a = "10";
    var b = "4";
    assertEquals(6, subtractService.subtract(a, b));
  }

  @Test
  void should_throw_exception_when_invalid_numbers() {
    var a = "invalid";
    var b = "3";
    assertThrows(IllegalArgumentException.class, () -> subtractService.subtract(a, b));
  }

  @Test
  void should_throw_exception_when_null() {
    String a = null;
    String b = null;
    assertThrows(IllegalArgumentException.class, () -> subtractService.subtract(a, b));
  }

  @Test
  void should_throw_exception_when_values_negative() {
    var a = "-1";
    var b = "10";
    assertThrows(IllegalArgumentException.class, () -> subtractService.subtract(a, b));
  }
}
