package org.dms.products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductsController {

  final RestTemplate restTemplate;

  @GetMapping("/products-hello")
  public String hello() {
    return "Hello from Products-controller";
  }

  @GetMapping("/call-customer")
  public String callCustomer() {
    final var url = "http://CUSTOMER/api/v1/customer-hello";
    return "Products -> Customer: " + restTemplate.getForObject(url, String.class);
  }

}
