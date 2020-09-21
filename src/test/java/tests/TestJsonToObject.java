package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class TestJsonToObject {

    @Test
    public void testConversionFromStringToObject() throws JsonProcessingException {

        //Json
        String text = "{\"id\":1,\"name\":\"Ana\",\"salary\":500.0055}";

        // serializer/deserialization
        ObjectMapper objectMapper = new ObjectMapper();

        // read a Java object from a Json
        Person person = objectMapper.readValue(text, Person.class);

        Person expected = new Person();
        expected.setId(1);
        expected.setName("Ana");
        expected.setSalary(500.0055);

        Assertions.assertEquals(expected, person);
    }

    @Test
    public void testConversionFromStringToMap() throws JsonProcessingException {

        //Json
        String text = "{\"id\":1,\"name\":\"Ana\",\"salary\":500.0055}";

        ObjectMapper objectMapper = new ObjectMapper();

        //read a Java map object from a Json
        Map<String, Object> map
                = objectMapper.readValue(text, new TypeReference<Map<String, Object>>() {
        });

        System.out.println(map);

    }

    @Test
    public void testConversionFromStringToList() throws JsonProcessingException {

        //Json
        String text = "[{\"id\":1,\"name\":\"Ana\",\"salary\":500.0055},{\"id\":2,\"name\":\"Vlad\",\"salary\":500.3}]";

        ObjectMapper objectMapper = new ObjectMapper();

        // read a list of objects from a Json
        List<Person> list = objectMapper.readValue(text, new TypeReference<>() {
        });

        Assertions.assertEquals("[Person{id=1, name='Ana', salary=500.0055}, Person{id=2, name='Vlad', salary=500.3}]", list.toString());
    }
}
