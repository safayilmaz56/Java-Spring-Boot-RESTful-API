package com.teknopar.northwind.service.abstracts;

import com.teknopar.northwind.core.model.User;
import com.teknopar.northwind.core.utilities.results.DataResult;
import com.teknopar.northwind.core.utilities.results.Result;

public interface UserService {

    Result add(User user);
    DataResult<User> findByEmail(String email);
}
