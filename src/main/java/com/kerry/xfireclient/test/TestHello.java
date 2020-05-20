package com.kerry.xfireclient.test;

import com.kerry.xfireclient.client.HelloServiceClient;
import com.kerry.xfireclient.client.HelloServicePortType;

/**
 * @author kerryhe
 * @date 2020/5/20
 */
public class TestHello {

    public static void main(String[] args) {
        HelloServiceClient client = new HelloServiceClient();
        HelloServicePortType service = client.getHelloServiceHttpPort();
        String hank = service.getInfo("hank");
        System.out.println(hank);
        service.reload(510, 520);
    }

}
