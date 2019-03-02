package ExceptionPkg;

public class Main {
    public static void main(String[] args) {
        String[][] arrayStr = {
                {"6", "5", "7", "4"},
                {"7", "8", "5", "1"},
                {"2", "3", "4", "6"},
                {"6", "7", "8", "9"}};

        try {
            int elementsSum = CalcElementSum(arrayStr);
            System.out.println("The sum of elements is " + elementsSum);
        }catch(ModArraySizeException ex) {
            System.out.println("You used array with incorrect shape");
            ex.printStackTrace();
        }catch(ModArrayDataException ex) {
            System.out.println("There are incorrect data types in array's elements");
            ex.printStackTrace();
        }
    }

    public static int CalcElementSum(String[][] arrayStrInt) {
        if(arrayStrInt.length!=4) {
            throw new ModArraySizeException("Incorrect Array Size: The number of rows is " + arrayStrInt.length +
                    ", but 4 rows is required");
        }else{
            for(int i=0; i<arrayStrInt.length; i++) {
                if(arrayStrInt[i].length!=4) {
                    throw new ModArraySizeException("Incorrect Array Size: " + arrayStrInt[i].length +
                            " elements in " + i + " row, but 4 elements is required");
                }
            }
        }
        int elementsSum = 0;
        for(int i=0; i<arrayStrInt.length; i++) {
            for(int j=0; j<arrayStrInt.length; j++) {
                if(arrayStrInt[i][j].chars().allMatch(Character::isDigit)) {
                    elementsSum = elementsSum + Integer.parseInt(arrayStrInt[i][j]);
                }else{
                    throw new ModArrayDataException("Incorrect Data Type: Couldn't convert value in row " + (i+1) +
                            " column " + (j+1) + " to int");
                }
            }
        }
        return elementsSum;
    }
}
