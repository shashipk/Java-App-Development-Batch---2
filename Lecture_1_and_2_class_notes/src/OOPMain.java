import java.io.*;

public class OOPMain {

    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        //cat.ht = 7;
        cat.setColor("red");
        cat.setHt(10);
        cat.setHt(7);
        cat.setHt(-10); //
        cat.setWt(5);

        System.out.println(cat.getColor());
        System.out.println(cat.getHt());
        cat.speak();


        File file = new File("C:\\Users\\Shashi\\Documents\\JADS-1\\Lecture_1_class_notes\\src\\b.txt");

        file.createNewFile();
        System.out.println(file.exists());
        file.getName();
        FileWriter fileWriter = new FileWriter("C:\\Users\\Shashi\\Documents\\JADS-1\\Lecture_1_class_notes\\src\\c.txt");

        fileWriter.write(5);

// FTP Server
        FileReader fileReader = new FileReader("C:\\Users\\Shashi\\Desktop\\test2.txt");
        int i;
        while(true){
            i = fileReader.read();
            char ch = (char)i;
            if(i==-1) break;
            System.out.println(ch);
            // .csv , xlx 
        }
        /*

        FoodService foodService = new FoodServiceImple1();
        foodService.serveComplexFood();
        foodService.serveSimpleFood();

        FoodService foodService2 = new FoodServiceImpl2();
        foodService2.serveComplexFood();
        foodService2.serveSimpleFood();

         */
        FoodServiceManager manager = new FoodServiceManager();
        FoodService foodService = new FoodServiceImple1();
        manager.getSimpleFoodService(foodService);

    }

    /*
Encapsulation:
1. Data hiding
2. Data binding

Polymorphism:

1. Static / compile time, method overloading
2. dynamic / run time , method overriding

Abstraction: ( Interfaces, Abstract classes )
1. Hiding the implementation
Hiding the complexity
Showing only the required details
 */
}
