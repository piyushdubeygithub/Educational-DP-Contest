package interview;

public class User {
    private Integer amount;
    private Integer currentPosition;
    private Character cellType;

    public User(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Character getCellType() {
        return cellType;
    }

    public void setCellType(Character cellType) {
        this.cellType = cellType;
    }
}
