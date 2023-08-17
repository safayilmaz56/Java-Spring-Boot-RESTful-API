package com.teknopar.northwind.core.utilities.results;

public class SuccesResult extends Result{ //işlem sonucu başarılı olduğunda bu sınıf çağırılır
    public SuccesResult() {
        super(true);
    }

    public SuccesResult(String message) {
        super(true, message);
    }
}
