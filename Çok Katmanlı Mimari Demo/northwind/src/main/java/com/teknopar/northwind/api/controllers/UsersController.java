package com.teknopar.northwind.api.controllers;

import com.teknopar.northwind.core.model.User;
import com.teknopar.northwind.core.utilities.results.ErrorDataResult;
import com.teknopar.northwind.core.utilities.results.Result;
import com.teknopar.northwind.service.abstracts.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UsersController {

    private UserService userService;

    /*
    * ResponseEntity<?>:Normalde swaggerda işlem için 200 durum kodunu gönderir.
    * http durum kodunu işlem sonucuna göre vermemizi sağlar.
    * ? olan yer ne döneceğini belirtmedik anlamına gelir yani error da olabilir success de olabilir
    * ? işlem sonucuna göre hareket etmemizi sağlar
    * */
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }

    /*
    *  global exception handle
    */
    @ExceptionHandler(MethodArgumentNotValidException.class) //sistemde MethodArgumentNotValidException bu türden bir hata olursa yukarıdaki .ok() fonksiyonunu badRequest() fonksiyonuna döndürür
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>(); //ilk string anahtar türü,ikinci string hata mesajının türünü belirtir. Dictionary oluşturduk
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
