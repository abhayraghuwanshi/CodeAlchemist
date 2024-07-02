package com.odinsolutions.vulcancode_compiler.web;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.odinsolutions.vulcancode_compiler.constants.ForCompiler.API_V1;

@RestController
public class ExecutionController {


    @PostMapping(path= API_V1 +"/runAndCompile")
    public String compileCode(@RequestBody String body ){

        return "recieved the code";
    }




}
