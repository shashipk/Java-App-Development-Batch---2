import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListExample {

    public static void main(String[] args) {
        // vector<string>
        ArrayList<String> names = new ArrayList<>();
        names.add("Shashi");
        names.add("Ramu");
        names.add("Raka");
        for(int i=0;i<names.size();i++){
            System.out.println(names.get(i));
        }
        names.remove("Ramu");
        for(String name : names){
            System.out.println(name);
        }
        int c = sum(3,4);

        ArrayList<User> users = new ArrayList<>();

        User user1  = new User();
        user1.setAge(35);
        user1.setName("Saka");

        users.add(user1);
        // id   -> bal
        //

        HashMap<Integer, Integer> balanceStore =
                new HashMap<>();

        HashMap<Integer, User> userStore =
                new HashMap<>();
        userStore.put(1,user1);

        System.out.println(balanceStore.get(1));
    }

    static int sum(int a, int b){
        return a+b;
    }


}
