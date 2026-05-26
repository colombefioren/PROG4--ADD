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
  void should_throw_exception_when_only_b_negative() {
    var a = "5";
    var b = "-3";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_return_quotient_when_values_have_leading_trailing_spaces() {
    var a = " 10 ";
    var b = " 4 ";
    assertEquals(2, divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_empty_string() {
    var a = "";
    var b = "5";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_whitespace_only() {
    var a = "   ";
    var b = "5";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_a_null() {
    String a = null;
    var b = "5";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_b_null() {
    var a = "5";
    String b = null;
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_decimal_strings() {
    var a = "3.5";
    var b = "2";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }

  @Test
  void should_throw_exception_when_divide_by_zero() {
    var a = "10";
    var b = "0";
    assertThrows(IllegalArgumentException.class, () -> divisionService.divide(a, b));
  }
}
