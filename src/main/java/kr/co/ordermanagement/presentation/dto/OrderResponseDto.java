package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.*;
import kr.co.ordermanagement.domain.product.*;
import org.apache.juli.logging.*;

import java.util.*;

public class OrderResponseDto {
    private Long id;
    private List<OrderedProductDto> orderedProduects;
    private Integer totalPrice;
    private State state;

    public OrderResponseDto(Long id, List<OrderedProductDto> orderedProduects, Integer totalPrice, State state) {
        this.id = id;
        this.orderedProduects = orderedProduects;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public List<OrderedProductDto> getOrderedProduects() {
        return orderedProduects;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public State getState() {
        return state;
    }

    public static OrderResponseDto toDto(Order order) {
        List<OrderedProductDto> orderedProductDtos = order.getOrderedProducts()
                .stream()
                .map(orderedProduct -> OrderedProductDto.toDto(orderedProduct))
                .toList();

        OrderResponseDto orderResponseDto = new OrderResponseDto(
                order.getId(),
                orderedProductDtos,
                order.getTotalPrice(),
                order.getState()
        );

        return orderResponseDto;
    }
}
