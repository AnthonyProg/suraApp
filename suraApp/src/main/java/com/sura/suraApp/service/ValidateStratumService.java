package com.sura.suraApp.service;

import org.springframework.stereotype.Service;

@Service
public class ValidateStratumService {

    public String validate(Integer stratum){
        switch (stratum){
            case 5:
                return "true";
            case 10:
                return "false";
            default:
                return "false";
        }
    }
}
