
package com.kerry.xfireclient.client;

import javax.jws.WebService;

@WebService(serviceName = "HelloService", targetNamespace = "http://test/HelloServie", endpointInterface = "com.kerry.xfireclient.client.HelloServicePortType")
public class HelloServiceImpl
    implements HelloServicePortType
{


    public Integer add(String in0, String in1, Integer in2, String in3) {
        throw new UnsupportedOperationException();
    }

    public String getAll() {
        throw new UnsupportedOperationException();
    }

    public void reload(Integer in0, Integer in1) {
        throw new UnsupportedOperationException();
    }

    public String getInfo(String in0) {
        throw new UnsupportedOperationException();
    }

    public String nciicCheck(String in0, String in1) {
        throw new UnsupportedOperationException();
    }

}
