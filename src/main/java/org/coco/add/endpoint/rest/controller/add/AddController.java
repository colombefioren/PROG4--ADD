package org.coco.add.endpoint.rest.controller.add;

import lombok.AllArgsConstructor;
import org.coco.add.service.AddService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
@AllArgsConstructor
public class AddController {

  private final AddService addService;

  @GetMapping
  public ResponseEntity<?> add(
      @RequestParam(required = false) String a, @RequestParam(required = false) String b) {
    if (a == null || b == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A and B params are required!");
    }
    try {
      return ResponseEntity.ok(addService.add(a, b));
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
