package com.example.retryretrofit.retrofit

import java.lang.annotation.ElementType.METHOD
import java.lang.annotation.RetentionPolicy.RUNTIME

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.Target


@Documented
@Target(METHOD)
@Retention(RUNTIME)
annotation class Retry(val max: Int = 3)