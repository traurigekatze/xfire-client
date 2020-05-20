
package com.kerry.xfireclient.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "HelloServicePortType", targetNamespace = "http://test/HelloServie")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface HelloServicePortType {


    @WebMethod(operationName = "add", action = "")
    @WebResult(name = "out", targetNamespace = "http://test/HelloServie")
    public Integer add(
        @WebParam(name = "in0", targetNamespace = "http://test/HelloServie")
        String in0,
        @WebParam(name = "in1", targetNamespace = "http://test/HelloServie")
        String in1,
        @WebParam(name = "in2", targetNamespace = "http://test/HelloServie")
        Integer in2,
        @WebParam(name = "in3", targetNamespace = "http://test/HelloServie")
        String in3);

    @WebMethod(operationName = "getAll", action = "")
    @WebResult(name = "out", targetNamespace = "http://test/HelloServie")
    public String getAll();

    @WebMethod(operationName = "reload", action = "")
    public void reload(
        @WebParam(name = "in0", targetNamespace = "http://test/HelloServie")
        Integer in0,
        @WebParam(name = "in1", targetNamespace = "http://test/HelloServie")
        Integer in1);

    @WebMethod(operationName = "getInfo", action = "")
    @WebResult(name = "out", targetNamespace = "http://test/HelloServie")
    public String getInfo(
        @WebParam(name = "in0", targetNamespace = "http://test/HelloServie")
        String in0);

    @WebMethod(operationName = "nciicCheck", action = "")
    @WebResult(name = "out", targetNamespace = "http://test/HelloServie")
    public String nciicCheck(
        @WebParam(name = "in0", targetNamespace = "http://test/HelloServie")
        String in0,
        @WebParam(name = "in1", targetNamespace = "http://test/HelloServie")
        String in1);

}
