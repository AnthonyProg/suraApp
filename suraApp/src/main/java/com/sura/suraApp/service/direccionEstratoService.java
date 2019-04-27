package com.sura.suraApp.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "getValidacionEstrato", targetNamespace = "http://localhost:8080//services/getValidacionEstrato")
public class direccionEstratoService {

    private String cadenaFinal = "";
    @WebMethod
    public String getValidacionEstrato(@WebParam(name = "estrato") String estrato, @WebParam(name = "direccion") String direccion){
        String cadValidacion = splitDireccion(direccion);
        cadValidacion = cadValidacion.trim();
        String[] partsDireccion = cadValidacion.split("-");
        String num1 = partsDireccion[0];
        String num2 = partsDireccion[1];
        cadenaFinal = validarEstratoDireccion(num1, num2, estrato);
        return cadenaFinal;
    }

    private String splitDireccion(String direccion){
        String cadena = "";
        cadena = direccion.substring(4, 6) + "-" + direccion.substring(7,8);
        return cadena;
    }

    private String validarEstratoDireccion(String num1, String num2, String estrato){
        String msj = "";
        if (num1.equals("1") && num2.equals("39") && estrato.equals("1")){
            cadenaFinal = "El estrato  registrado es correcto";
        }
        else if (num1.equals("40") && num2.equals("79") && estrato.equals("2")){
            cadenaFinal = "El estrato registrado es correcto";
        }
        else if (num1.equals("80") && num2.equals("119") && estrato.equals("3")){
            cadenaFinal = "El estrato registrado es correcto";
        }
        else if (num1.equals("120") && num2.equals("149") && estrato.equals("4")){
            cadenaFinal = "El estrato registrado es correcto";
        }
        else if (num1.equals("150") && num2.equals("170") && estrato.equals("5")){
            cadenaFinal = "El estrato registrado es correcto";
        }
        else{
            cadenaFinal = "El estrato registrado no es el correcto";
        }
        return msj;
    }
}

