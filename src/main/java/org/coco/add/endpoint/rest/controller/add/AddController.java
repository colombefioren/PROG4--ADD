package org.coco.add.endpoint.rest.controller.add;

import org.coco.add.service.AddService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddController {

  private AddService addService;

  @GetMapping
  public ResponseEntity<?> add(@RequestParam String a, @RequestParam String b) {
    try{
      return ResponseEntity.ok(addService.add(a, b));
    }catch (IllegalArgumentException e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
