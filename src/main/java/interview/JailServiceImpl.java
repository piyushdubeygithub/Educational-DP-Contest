package interview;

public class JailServiceImpl implements JailService{

    @Override
    public void deductAmount(User user, Integer amount) {
        Jail jail = new Jail();
        int userAmount = user.getAmount();
        userAmount -= 150;
        user.setAmount(userAmount);
    }
}
