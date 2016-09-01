package com.example.vernon.vernongameapplication.Repositories;

import java.util.List;

/**
 * Created by VERNON on 2016/08/31.
 */
public interface RestApi<S, ID> {

    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();

}
