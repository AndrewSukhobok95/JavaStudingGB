package lesson1;

public class Main {
    public static void main(String[] args) {
        final int count = 1000000;
        String[] logins = new String[count];
        String newLogin = "Ivan";
        boolean uniq = true;
        for (int i = 0; i < count; i++) {
            if(logins[i].equals(newLogin)){
                uniq = false;
                break;
            }
        }

        if (uniq){
            ////
        }else{
            System.out.println("логин уже занят.");
        }
    }
}
