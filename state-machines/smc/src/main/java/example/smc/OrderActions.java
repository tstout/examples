package example.smc;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.google.common.collect.Lists.*;

public interface OrderActions {
    void appendOrderItem(LineItem item);

    int retryCount();

    void incRetryCount();

    void startTimer(long timeOut);

    void stopTimer();

    void finishOrder();

    void persistOrder();

    public static class Default implements OrderActions {
        private final OrderSM fsm;
        private int retryCount = 0;
        private List<LineItem> items = newArrayList();
        private Timer timer = new Timer();

        public Default(OrderSM fsm) {
            this.fsm = fsm;
        }

        @Override
        public void appendOrderItem(LineItem item) {
            items.add(item);
        }

        @Override
        public int retryCount() {
            return retryCount;
        }

        @Override
        public void incRetryCount() {
            retryCount++;
        }

        @Override
        public void startTimer(long timeOut) {
            timer.schedule(new TimerTask() {
                public void run() {
                    fsm.timeout();
                }
            },
                    timeOut);
        }

        @Override
        public void stopTimer() {
            timer.cancel();
        }

        @Override
        public void finishOrder() {
            // call service
        }

        @Override
        public void persistOrder() {
            // write order to DB...
        }
    }

}
