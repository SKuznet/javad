package controller;

import io.khasang.demo.entity.Cat;
import io.khasang.demo.entity.CatWoman;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CatControllerIntegrationTest {

    private final String ROOT = "http://localhost:8080/cat";
    private final String ADD = "/add";
    private final String DELETE = "/delete";
    private final String ALL = "/all";
    private final String GET_BY_ID = "/get";

    @Test
    public void addCat() {
        Cat cat = createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<Cat> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat);

    }

    @Test
    public void getAllCats() {
        createCat();
        createCat();

        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Cat>> responseEntity = template.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cat>>() {
                }
        );

        List<Cat> catList = responseEntity.getBody();
        assertNotNull(catList.get(0));
        assertNotNull(catList.get(1));

    }

    @Test
    public void catDelete() {
        Cat cat = createCat();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Cat deletedCat = responseEntity.getBody();
        assertNotNull(deletedCat.getName());

        ResponseEntity<Cat> responseForDeletedCat = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                deletedCat.getId()
        );

        assertEquals("OK", responseForDeletedCat.getStatusCode().getReasonPhrase());
        assertNull(responseForDeletedCat.getBody());
    }

    private Cat createCat() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat("Murzik");

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, headers);

        RestTemplate template = new RestTemplate();

        Cat createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Cat.class
        ).getBody();

        assertNotNull(createdCat.getName());
        assertEquals(cat.getName(), createdCat.getName());
        return createdCat;
    }

    private Cat prefillCat(String murzik) {
        Cat cat = new Cat();
        cat.setName(murzik);
        cat.setDescription("new cat");

        CatWoman catWoman1 = new CatWoman();
        CatWoman catWoman2 = new CatWoman();

        catWoman1.setName("Riska");
        catWoman2.setName("Murka");

        List<CatWoman> catWomenList = new ArrayList<>();
        catWomenList.add(catWoman1);
        catWomenList.add(catWoman2);

        cat.setCatWomanList(catWomenList);

        return cat;
    }

}
