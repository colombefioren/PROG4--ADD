package org.coco.add.endpoint.rest.controller.add;

import org.coco.add.service.AddService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add")
public class AddController {

  private AddService addService;

  @GetMapping
  public int add(@RequestParam String a, @RequestParam String b) {
    return addService.add(a, b);
  }
}
