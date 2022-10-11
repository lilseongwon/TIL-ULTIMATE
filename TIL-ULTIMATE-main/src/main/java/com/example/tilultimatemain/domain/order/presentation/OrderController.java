package com.example.tilultimatemain.domain.order.presentation;

import com.example.tilultimatemain.domain.order.presentation.request.AddOrderRequest;
import com.example.tilultimatemain.domain.order.service.AddOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final AddOrderService addOrderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{food-id}")
    public void addOrder(@PathVariable("food-id")Long id, @RequestBody @Valid AddOrderRequest request) {
        addOrderService.execute(id, request);
    }


}
