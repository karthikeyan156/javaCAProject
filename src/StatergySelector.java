package src;


public class StatergySelector {
    private StatergySelector strategy;

    public StatergySelector(StatergySelector strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(StatergySelector strategy) {
        this.strategy = strategy;
    }

}
