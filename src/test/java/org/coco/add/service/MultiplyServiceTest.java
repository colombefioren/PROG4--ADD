package org.coco.add.service;

import static org.junit.jupiter.api.Assertions.*;

import org.coco.add.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MultiplyServiceTest extends FacadeIT {

  @Autowired private MultiplyService multiplyService;

  @Test
  void should_return_product() {
    var a = "10";
    var b = "4";
    assertEquals(40, multiplyService.multiply(a, b));
  }

  @Test
  void should_throw_exception_when_invalid_numbers() {
    var a = "invalid";
    var b = "3";
    assertThrows(IllegalArgumentException.class, () -> multiplyService.multiply(a, b));
  }

  @Test
  void should_throw_exception_when_null() {
    String a = null;
    String b = null;
    assertThrows(IllegalArgumentException.class, () -> multiplyService.multiply(a, b));
  }

  @Test
  void should_throw_exception_when_values_negative() {
    var a = "-1";
    var b = "10";
    assertThrows(IllegalArgumentException.class, () -> multiplyService.multiply(a, b));
  }
}
