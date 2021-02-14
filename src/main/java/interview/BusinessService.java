package interview;

public interface BusinessService {
   void addAmount(User user, Integer amount);
   void deductAmount(User user, Integer amount);
   boolean checkHotelOwner(User[] user, Integer n);
   void setPosition(User user, Character cellType, Integer position);
}
