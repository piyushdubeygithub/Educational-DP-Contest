package interview;

import java.util.HashSet;

public class BusinessServiceImpl implements BusinessService{
    private Integer hotelFine = 50;
    private Integer hotelCharge = 200;
    HashSet set = new HashSet();
    @Override
    public void addAmount(User user, Integer amount) {
        int userAmount = user.getAmount();
        userAmount += amount;
        user.setAmount(userAmount);
    }

    @Override
    public void deductAmount(User user, Integer amount) {
        int userAmount = user.getAmount();
        userAmount -= amount;
        user.setAmount(userAmount);
    }

    @Override
    public boolean checkHotelOwner(User[] user, Integer index) {
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        boolean isUserExists = false;
        for(int i=0;i<user.length;i++){
            if(i==index && user[index].getCellType() == 'H'){
                continue;
            }
            if(user[i].getCurrentPosition() == user[index].getCurrentPosition() &&
            user[i].getCellType() == user[index].getCellType()){
                businessService.deductAmount(user[index], hotelFine);
                isUserExists = true;
                break;
            }
        }
        if(!isUserExists){
            businessService.deductAmount(user[index], hotelCharge);
        }
        return isUserExists;
    }

    @Override
    public void setPosition(User user, Character cellType, Integer position) {
       user.setCellType(cellType);
       user.setCurrentPosition(position);
    }



}
