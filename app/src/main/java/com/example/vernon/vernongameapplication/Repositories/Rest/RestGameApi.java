package com.example.vernon.vernongameapplication.Repositories.Rest;

import com.example.vernon.vernongameapplication.Repositories.RestApi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import Model.Games;

/**
 * Created by VERNON on 2016/08/31.
 */
public class RestGameApi implements RestApi<Games,Long> {

    final String BASE_URL="http://vernongameapp.herokuapp.com/api/";
    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Games get(Long id) {
        final String url = BASE_URL+"GameCategories/"+id.toString();
        HttpEntity<Games> requestEntity = new HttpEntity<Games>(requestHeaders);
        ResponseEntity<Games> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Games.class);
        Games games = responseEntity.getBody();
        return games;
    }

    @Override
    public String post(Games entity) {
        final String url = BASE_URL+"GameCategories/create/";
        HttpEntity<Games> requestEntity = new HttpEntity<Games>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Games entity) {
        final String url = BASE_URL+"GameCategories/update/"+entity.getId().toString();
        HttpEntity<Games> requestEntity = new HttpEntity<Games>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Games entity) {
        final String url = BASE_URL+"GameCategories/delete/"+entity.getId().toString();
        HttpEntity<Games> requestEntity = new HttpEntity<Games>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public List<Games> getAll() {
        List<Games> games = new ArrayList<>();
        final String url = BASE_URL+"GameCategories/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Games[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Games[].class);
        Games[] results = responseEntity.getBody();

        for (Games game : results) {
            games.add(game);
        }
        return games;
    }
}
