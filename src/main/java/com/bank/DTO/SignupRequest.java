package com.bank.DTO;

public record SignupRequest(
        String username ,
        String password ,
        String genre ,
        String cin ,
        Integer age) {}