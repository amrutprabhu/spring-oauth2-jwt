package com.amrut.prabhu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/v1")
public class Controller {


  @RequestMapping("/products")
  public ResponseEntity<String> getProducts() {
    return ResponseEntity.ok("Done");
  }
}
