package com.xcode.javas.preparation.general;

import java.util.HashMap;

public class Factorial {
    public static HashMap cachedFactorial = new HashMap();
    private static Factorial factorial = new Factorial();

    private Factorial(){

    }
    public static Factorial getFactorialInstance(){
        return factorial;
    }

    private long getFactorial(long n){
        long f = 1;
        if(n<0)
            throw new ArithmeticException();
        else if(n==0 || n==1)
            return 1;
        else {
            for(int i=1;i<=n;i++){
                f = f*i;
            }
            return f;
        }
    }

    public long findFactorial(long n){
        if(cachedFactorial.containsKey(n))
            return (long)cachedFactorial.get(n);
        else {
            long f = getFactorial(n);
            cachedFactorial.put(n,f);
            return f;
        }
    }
}
