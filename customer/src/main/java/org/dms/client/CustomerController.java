package org.dms.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CustomerController {

  final RestTemplate restTemplate;

  @GetMapping("/customer-hello")
  public String hello() {
    return "Hello from Client";
  }

  @GetMapping("/call-products")
  public String callProducts() {
    final var url = "http://PRODUCTS/api/v1/products-hello";
    return "Customer -> products: " + restTemplate.getForObject(url, String.class);
  }
}
