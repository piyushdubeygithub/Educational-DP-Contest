package interview;

public class CellFactory {
    Cells cells;

    public static Cells getCellInstance(Character ch){
        if(ch == 'J'){
            return new Jail();
        }
        return null;
    }
}
