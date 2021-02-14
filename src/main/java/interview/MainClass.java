package interview;

import java.util.Scanner;

public class MainClass {
    private static int[] diceOutput = {4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String cells = sc.nextLine();
        User[] user = new User[n];
        for(int i=0;i<n;i++){
             user[i] = new User(1000);
        }

        BusinessService businessService = new BusinessServiceImpl();
        for(int i=0;i<diceOutput.length;i++){
            int index = i%n;
            Cell cell = new Cell(cells.charAt(diceOutput[i]));
            Cells userCell = CellFactory.getCellInstance(cells.charAt(diceOutput[i]));
            if(cell.getType() == 'J'){
                JailService jailService = new JailServiceImpl();
                jailService.deductAmount(user[index], 0);
            }else if(cell.getType() == 'T'){
                Treasure treasure = new Treasure();
               businessService.addAmount(user[index], treasure.getAmount());
            }else if(cell.getType() == 'H'){
                  businessService.checkHotelOwner(user, index);
            }
            businessService.setPosition(user[index], cell.getType(), diceOutput[i]);

        }
    }
}
