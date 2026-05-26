package org.coco.add.service;

import static org.junit.jupiter.api.Assertions.*;

import org.coco.add.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DivisionServiceTest extends FacadeIT {

  @Autowired private DivisionService divisionService;

  @Test
  void should_return_quotient() {
    var a = "10";
    var b = "4";
    assertEquals(2, divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_invalid_numbers() {
    var a = "invalid";
    var b = "3";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_null() {
    String a = null;
    String b = null;
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_values_negative() {
    var a = "-1";
    var b = "10";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_divide_by_zero() {
    var a = "10";
    var b = "0";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }
}
