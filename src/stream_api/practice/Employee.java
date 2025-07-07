package stream_api.practice;

public class Employee {
    int id;
    String name;
    String department;
    double salary;
    int age;
    String city;
    public Employee() {
        this.id = 0;
        this.name = "Default Name";
        this.department = "Default Department";
        this.salary = 0.0;
        this.age = 0;
        this.city = "Default City";
    }
    public Employee(int id, String name, String department, double salary, int age, String city) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.city = city;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.department = employee.department;
        this.salary = employee.salary;
        this.age = employee.age;
        this.city = employee.city;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
