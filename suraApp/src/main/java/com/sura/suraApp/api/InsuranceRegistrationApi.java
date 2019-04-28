package com.sura.suraApp.api;

import com.sura.suraApp.entities.Property;
import com.sura.suraApp.entities.Register;
import com.sura.suraApp.service.InsuranceRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InsuranceRegistrationApi {

    @Autowired
    InsuranceRegistrationService insuranceRegistrationService;

    @RequestMapping(value="/register", method= RequestMethod.POST)
    @ResponseBody
    public Register register(@RequestBody Property property) throws Exception {
        return insuranceRegistrationService.register(property);
    }
}
