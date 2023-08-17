package com.teknopar.northwind.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(T data, String message) {
        super(data,true, message);  //işlemin başarılı olduğu durumda bu sınıfı çağıracağımız için durumu true yaptık
    }
    public SuccessDataResult(T data){
        super(data,true);
    }
    public SuccessDataResult(String message) {
        super(null,true, message);
    }
    public SuccessDataResult() {
        super(null,true);
    }
}
