package com.teknopar.northwind.core.utilities.results;

public class DataResult<T> extends Result {// <T> : generic olarak çalışacağımızı belirttik. Dönen değerler birden fazla türde olduğu için kullandık
    private T data;
    public DataResult(T data,boolean success, String message) {
        super(success, message);
        this.data = data;
    }
    public DataResult(T data,boolean success) {
        super(success);
        this.data = data;
    }
    public T getData() {
        return data;
    }
}
