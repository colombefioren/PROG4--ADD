package org.coco.add.endpoint.rest.controller.arith;

import lombok.AllArgsConstructor;
import org.coco.add.service.SubtractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subtract")
@AllArgsConstructor
public class SubtractController {

  private final SubtractService subtractService;

  @GetMapping
  public ResponseEntity<?> subtract(
      @RequestParam(required = false) String a, @RequestParam(required = false) String b) {
    if (a == null || b == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Both amounts are required!");
    }
    try {
      return ResponseEntity.ok(subtractService.subtract(Long.parseLong(a), Long.parseLong(b)));
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
