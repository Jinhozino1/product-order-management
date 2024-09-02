package kr.co.ordermanagement.presentation.controller;

import kr.co.ordermanagement.application.*;
import kr.co.ordermanagement.domain.order.*;
import kr.co.ordermanagement.presentation.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OrderRestController {

    private SimpleOrderService simpleOrderService;

    @Autowired
    public OrderRestController (SimpleOrderService simpleOrderService) {
        this.simpleOrderService = simpleOrderService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<OrderResponseDto> createOrder(
            @RequestBody List<OrderProductRequestDto> orderProductRequestDtos) {
        OrderResponseDto orderResponseDto = simpleOrderService.createOrder(orderProductRequestDtos);

        return ResponseEntity.ok(orderResponseDto);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<OrderResponseDto>> getOrderBystate(
            @RequestParam State state
    ) {
        List<OrderResponseDto> orderResponseDtos = simpleOrderService.findByState(state);

        return ResponseEntity.ok(orderResponseDtos);
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<OrderResponseDto> getOrderById(
            @PathVariable Long orderId) {
        OrderResponseDto orderResponseDto = simpleOrderService.findById(orderId);

        return ResponseEntity.ok(orderResponseDto);
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.PATCH)
    public ResponseEntity<OrderResponseDto> changeOrderState(
            @PathVariable Long orderId,
            @RequestBody ChangeStateRequestDto changeStateRequestDto
    ) {
        OrderResponseDto orderResponseDto = simpleOrderService.changeState(orderId, changeStateRequestDto);

        return ResponseEntity.ok(orderResponseDto);
    }

    @RequestMapping(value = "/orders/{orderId}/cancel", method = RequestMethod.PATCH)
    public ResponseEntity<OrderResponseDto> cancelOrderById(
            @PathVariable Long orderId
    ) {
        OrderResponseDto orderResponseDto = simpleOrderService.cancelOrderById(orderId);

        return ResponseEntity.ok(orderResponseDto);
    }
}
