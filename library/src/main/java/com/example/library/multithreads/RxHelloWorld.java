package com.example.library.multithreads;

import io.reactivex.rxjava3.core.Flowable;

public class RxHelloWorld {

    public static void main(String[] args) {
        Flowable.just("Ram Mittala")
                .map(name -> name.toLowerCase())
                .subscribe(System.out::println);
    }
}
