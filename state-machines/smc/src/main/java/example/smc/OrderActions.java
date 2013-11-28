package example.smc;

import java.util.List;

import static com.google.common.collect.Lists.*;

public interface OrderActions {
    void appendOrderItem(LineItem item);

    FinishStatus finishOrder();

    void persistOrder();

    enum FinishStatus {
        OK,
        FAILED
    }

    public static class Default implements OrderActions {
        private final OrderSM fsm;
        private List<LineItem> items = newArrayList();

        public Default(OrderSM fsm) {
            this.fsm = fsm;
        }

        @Override
        public void appendOrderItem(LineItem item) {
            items.add(item);
        }

        @Override
        public FinishStatus finishOrder() {
            try {
                //
                // call service...
                //
                return FinishStatus.OK;
            } catch (Exception e) {
                //
                // log error...
                //
                return FinishStatus.FAILED;
            }
        }

        @Override
        public void persistOrder() {
            //
            // write order to DB...
            //
        }
    }

}
