import java.util.ArrayList;
import java.util.HashMap;

public class SampleRunner {

    /*
    Encapsulation
    -- Data Binding (fields + methods)--> class
    -- Data Hiding (Access Control)
     */
    public static void main(String[] args) {

        Adder adder = new Adder();

        String c = adder.add("Ramu","Raka");
        int sum = adder.add(2,4);

        User user1 = new User();
        // age < 0
        user1.setAge(-5);
        user1.setId(2);
        user1.setName("Ramu");

        System.out.println(user1.convertToString());

        User user2 = new User();
        user2.setName("Raka");
        user2.setId(3);
        user2.setAge(26);

        System.out.println(user2.convertToString());

        // Array -> Dynamic Array (vector , ArrayList )
        ArrayList<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);

        User user3 = users.get(0);
        for(int i=0;i<users.size();i++){
            System.out.println(users.get(i).convertToString());
        }

        /*
        Hashing: Ds -
        HashMap
        1 - 10
        2 - 20
        17 - 40
        insert(),delete(), search - O(1) - Ds
         */
        HashMap<Integer,Integer> wallet = new HashMap<Integer, Integer>();
        wallet.put(1,10); // insert
        wallet.put(2,20);
        wallet.put(3,30);

        System.out.println(wallet.get(2)); // O(1)

        wallet.put(2,wallet.get(2)+50); // update +50
        System.out.println(wallet.get(2));

        // Java 8 - java 14 ( 99%) - 1% - 1-2 days

        // TreeSet, Stack, Queue :

        // Inheritcnce : Code Reuse




    }

    class Animal{
        int age;
        int ht;
        int wt;
        String color;
        void speak(){

        }
        // getters & setters
    }

    class Dog extends Animal{
        void speak() {
            System.out.println("Dog barks");
        }
    }

    class Cat extends Animal{


    }

    class Horse{

    }

    /*
    Polymorphism
    method overloading ->
    method overriding
     */


}
class Adder{

   public int add(int a, int b)
   {
        return a+b;
    }

    public String add(String a, String b){
        return a+b;
    }
}

/*
Abstraction : Implementation hiding
abstract class
interface - 100%
 */

interface BalanceService{

    abstract void setBalance(int id, int bal);
    abstract int getBalance(int id);

        }

        class BalanceServiceImplUsingMySql implements BalanceService{


            @Override
            public void setBalance(int id, int bal) {

            }

            @Override
            public int getBalance(int id) {
                return 0;
            }
        }

        class BalanceServiceImplUsingMongo implements BalanceService{

            @Override
            public void setBalance(int id, int bal) {

            }

            @Override
            public int getBalance(int id) {
                return 0;
            }
        }

        // Web Service
        // OOPS + Collection