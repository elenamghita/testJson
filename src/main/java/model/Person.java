package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;
// Data model
//@JsonPropertyOrder(value = {"salary", "id", "name"})  // specify order of properties in output Json
public class Person {

    private int id;

    // specify Json property name
    // default is field name
    //    @JsonProperty("nume")
    private String name;

    //ignore this field for Json serialization/deserialization
    //    @JsonIgnore
    private Double salary;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(salary, person.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
