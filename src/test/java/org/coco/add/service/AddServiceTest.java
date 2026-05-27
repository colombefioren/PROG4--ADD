package org.coco.add.service;

import static org.junit.jupiter.api.Assertions.*;

import org.coco.add.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AddServiceTest extends FacadeIT {

  @Autowired private AddService addService;

  @Test
  void should_add_money_to_wallet() {
    var a = "10";
    var b = "4";
    assertEquals(14, addService.add(a, b));
  }

  @Test
  void should_throw_when_invalid_numbers() {
    var a = "invalid";
    var b = "3";
    var e = assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
    assertEquals("Insert valid numbers", e.getMessage());
  }

  @Test
  void should_throw_when_null() {
    String a = null;
    String b = null;
    var e = assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
    assertEquals("A and B cannot be null", e.getMessage());
  }

  @Test
  void should_throw_when_values_negative() {
    var a = "-1";
    var b = "10";
    var e = assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

  @Test
  void should_throw_when_only_b_negative() {
    var a = "5";
    var b = "-3";
    var e = assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
    assertEquals("A and B should be positive", e.getMessage());
  }

  @Test
  void should_return_sum_when_values_have_leading_trailing_spaces() {
    var a = " 10 ";
    var b = " 4 ";
    assertEquals(14, addService.add(a, b));
  }

  @Test
  void should_throw_when_empty_string() {
    var a = "";
    var b = "5";
    assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
  }

  @Test
  void should_throw_when_whitespace_only() {
    var a = "   ";
    var b = "5";
    assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
  }

  @Test
  void should_throw_when_a_null() {
    String a = null;
    var b = "5";
    var e = assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
    assertEquals("A and B cannot be null", e.getMessage());
  }

  @Test
  void should_throw_when_b_null() {
    var a = "5";
    String b = null;
    var e = assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
    assertEquals("A and B cannot be null", e.getMessage());
  }

  @Test
  void should_throw_when_decimal_strings() {
    var a = "3.5";
    var b = "2";
    assertThrows(IllegalArgumentException.class, () -> addService.add(a, b));
  }
}
