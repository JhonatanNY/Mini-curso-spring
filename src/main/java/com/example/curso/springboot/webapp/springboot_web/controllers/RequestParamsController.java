package com.example.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.springboot.webapp.springboot_web.model.dto.ParamDto;
import com.example.curso.springboot.webapp.springboot_web.model.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "valor por defecto", name = "mensaje") String message) {
        
        ParamDto param = new ParamDto();

        param.setMessage(message);
        return param;

    }
    
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("request")
    public ParamMixDto request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
            
        } catch (NumberFormatException e) {
            System.out.println("Código inválido: " + request.getParameter("code"));
        }

        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));


        return params;
    }
    
    

}
