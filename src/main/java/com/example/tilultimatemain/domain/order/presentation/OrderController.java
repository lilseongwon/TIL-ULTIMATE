package com.example.tilultimatemain.domain.order.presentation;

import com.example.tilultimatemain.domain.order.presentation.request.AddOrderRequest;
import com.example.tilultimatemain.domain.order.presentation.response.QueryOrderListResponse;
import com.example.tilultimatemain.domain.order.service.AddOrderService;
import com.example.tilultimatemain.domain.order.service.QueryMyOrderService;
import com.example.tilultimatemain.domain.order.service.QueryOrderListService;
import com.example.tilultimatemain.domain.order.service.UpdateOrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {
    private final AddOrderService addOrderService;
    private final QueryOrderListService queryOrderListService;
    private final QueryMyOrderService queryMyOrderService;
    private final UpdateOrderStatusService updateOrderStatusService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{food-id}")
    public void addOrder(@PathVariable("food-id")Long id, @RequestBody @Valid AddOrderRequest request) {
        addOrderService.execute(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/status/{order-id}")
    public void updateStatus(@PathVariable("order-id")Long id) {
        updateOrderStatusService.execute(id);
    }

    @GetMapping
    public QueryOrderListResponse queryOrderList() {
        return queryOrderListService.execute();
    }

    @GetMapping("/my")
    public QueryOrderListResponse queryMyOrder() {
        return queryMyOrderService.execute();
    }
}
