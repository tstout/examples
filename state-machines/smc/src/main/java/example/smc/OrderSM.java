package example.smc;

public class OrderSM implements OrderActions {
    private final OrderActions actions;
    private final TakeSMContext fsm;

    public OrderSM(OrderActions actions) {
        this.actions = actions;
        fsm = new TakeSMContext(this);
        fsm.enterStartState();
    }

    public void addItem(LineItem item) {
        fsm.addItem(item);
    }

    public void resume() {
        fsm.resume();
    }

    public void timeout() {
        fsm.timeout();
    }

    @Override
    public void appendOrderItem(LineItem item) {
        actions.appendOrderItem(item);
    }

    @Override
    public int retryCount() {
        return actions.retryCount();
    }

    @Override
    public void incRetryCount() {
        actions.incRetryCount();
    }

    @Override
    public void startTimer(long timeOut) {
        actions.startTimer(timeOut);
    }

    @Override
    public void stopTimer() {
        actions.stopTimer();
    }

    @Override
    public void finishOrder() {
        actions.finishOrder();
    }

    @Override
    public void persistOrder() {
        actions.persistOrder();
    }

    public void suspend() {
        fsm.suspend();
    }


    public void finish() {
        fsm.finish();
    }
}
