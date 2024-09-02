package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.*;

public class ChangeStateRequestDto {
    private State state;

    public State getState() {
        return state;
    }
}
