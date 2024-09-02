package kr.co.ordermanagement.domain.order;

import kr.co.ordermanagement.domain.exception.*;

public enum State {
    CREATED {
        @Override
        void checkCancelcellable() {}
    },
    SHIPPING,
    COMPLETED,
    CANCELED


    void checkCancelcellabel() {
        throw new CanNotCancellableStateException("이미 취소되었거나 취소할 수 없는 주문상태입니다.");
    }
}
