package interview;

public class Jail extends Cells{
    private Integer amount = 150;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    @Override
    void performAction(User user) {

    }
}
