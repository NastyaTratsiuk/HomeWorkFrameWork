package models;

import java.util.Objects;

public class User {

    private String userNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;

    public User(String userNumber, String firstName, String lastName, String email, String age, String salary, String department) {
        this.userNumber = userNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userNumber=").append(userNumber);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", LastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", age=").append(age);
        sb.append(", salary=").append(salary);
        sb.append(", department='").append(department).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                salary == user.salary &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(department, user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNumber, firstName, lastName, email, age, salary, department);
    }
}
