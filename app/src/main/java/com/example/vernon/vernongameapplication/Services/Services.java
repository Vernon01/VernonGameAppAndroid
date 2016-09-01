package com.example.vernon.vernongameapplication.Services;

import java.util.List;

/**
 * Created by VERNON on 2016/08/31.
 */
public interface Services <S, ID> {

    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
