package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestObjectToJson {

    @Test
    public void testConversionFromJavaObjectToJson() throws JsonProcessingException {

        Person person = new Person();
        person.setId(1);
        person.setName("Ana");
        person.setSalary(500.0055);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        String expectedValue = "{\"id\":1,\"name\":\"Ana\",\"salary\":500.0055}";
        Assertions.assertEquals(expectedValue, json);
    }

    @Test
    public void testConversionFromJavaObjectToJsonPrettyPrint() throws JsonProcessingException {

        Person person = new Person();
        person.setId(1);
        person.setName("Ana");
        person.setSalary(500.0055);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);

        // no check verify pretty print
        System.out.println(json);
    }

    @Test
    public void testConversionFromJavaListToJson() throws JsonProcessingException {

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("Ana");
        person1.setSalary(500.0055);

        Person person2=new Person();
        person2.setId(2);
        person2.setName("Vlad");
        person2.setSalary(500.30);

        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);

        String expectedValue = "[{\"id\":1,\"name\":\"Ana\",\"salary\":500.0055},{\"id\":2,\"name\":\"Vlad\",\"salary\":500.3}]";
        Assertions.assertEquals(expectedValue, json);
    }


}
