package com.teknopar.northwind.service.concretes;

import com.teknopar.northwind.core.model.User;
import com.teknopar.northwind.core.repository.UserDao;
import com.teknopar.northwind.core.utilities.results.DataResult;
import com.teknopar.northwind.core.utilities.results.Result;
import com.teknopar.northwind.core.utilities.results.SuccesResult;
import com.teknopar.northwind.core.utilities.results.SuccessDataResult;
import com.teknopar.northwind.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccesResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu");
    }
}
