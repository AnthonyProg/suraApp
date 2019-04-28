package com.sura.suraApp.api;

import com.sura.suraApp.service.ValidateStratumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class ValidateStratumApi {

    @Autowired
    ValidateStratumService validateStratumService;

    @RequestMapping(value="/validate")
    @ResponseBody
    public String validateStratum(@RequestBody Map<String, Integer> map) {
        return validateStratumService.validate(map.get("stratum"));
    }
}
