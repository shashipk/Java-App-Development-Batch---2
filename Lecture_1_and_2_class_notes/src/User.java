public class User {
    private int id;
    private String name;
    private int age;
    // user1.age = -5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0)
        this.age = age;
    }


    public String convertToString() {
        return
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                '}';
    }
}
