package hillel.hw.entity;

public class Employee{


    private Long id;
    private String name;
    private String age;
    private String position;
    private String salary;

    public Employee(){
    }

    public Employee(Long id, String name, String age,
                    String position, String salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "id " + id +
                ", " + name + " " + age + " y.o." +
                ", position: " + position + ", salary: " + salary + "\n";
    }
}
