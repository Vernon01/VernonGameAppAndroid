package com.example.vernon.vernongameapplication.Services.Impl;

import com.example.vernon.vernongameapplication.Repositories.Rest.RestGameApi;
import com.example.vernon.vernongameapplication.Repositories.RestApi;
import com.example.vernon.vernongameapplication.Services.GameService;

import java.util.List;

import Model.Games;

/**
 * Created by VERNON on 2016/08/31.
 */
public class GameServiceImpl implements GameService{

    final RestApi<Games,Long> rest = new RestGameApi();
    @Override
    public Games findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Games entity) {

        return rest.post(entity);
    }

    @Override
    public String update(Games entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Games entity) {
        return rest.delete(entity);

    }

    @Override
    public List<Games> findAll() {
        return rest.getAll();
    }
}
