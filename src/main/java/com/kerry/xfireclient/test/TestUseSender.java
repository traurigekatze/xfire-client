package com.kerry.xfireclient.test;

import com.kerry.xfireclient.client.HelloServicePortType;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.AbstractMessageSender;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.transport.http.EasySSLProtocolSocketFactory;

import java.net.MalformedURLException;

/**
 * @author kerryhe
 * @date 2020/5/20
 */
public class TestUseSender {

    private XFireProxyFactory proxyFactory;

    private org.codehaus.xfire.service.Service serviceModel;

    private HelloServicePortType service;

    public void init(){
        ProtocolSocketFactory easy = new EasySSLProtocolSocketFactory();
        Protocol protocol = new Protocol("https", easy, 443);
        Protocol.registerProtocol("https", protocol);

        ObjectServiceFactory serviceFactory = new ObjectServiceFactory();

        serviceModel = serviceFactory
                .create(HelloServicePortType.class);
        proxyFactory = new XFireProxyFactory();
    }

    private void initService() throws MalformedURLException {
        if (service == null) {

            service = (HelloServicePortType) proxyFactory.create(serviceModel, "http://kslist.cn:6443/xfire-web/servlet/xfire-servlet/HelloService");

            Client client = Client.getInstance(service);
            HttpClientParams params = new HttpClientParams();
            //连接超时时间（单位：毫秒）
            params.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 1000);
            params.setSoTimeout(1000);

            client.setProperty(CommonsHttpMessageSender.HTTP_CLIENT_PARAMS, params);
            //http单个host连接池最大连接数（host只有一个，值同MAX_TOTAL_CONNECTIONS）
            client.setProperty(CommonsHttpMessageSender.MAX_CONN_PER_HOST, "30");
            //http连接池最大连接数
            client.setProperty(CommonsHttpMessageSender.MAX_TOTAL_CONNECTIONS, "60");
            client.setProperty(AbstractMessageSender.MESSAGE_SENDER_CLASS_NAME, "com.kerry.xfireclient.sender.HttpMessageSender");
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        TestUseSender sender = new TestUseSender();
        sender.init();
        sender.initService();

        String hank = sender.service.getInfo("hank");
        System.out.println(hank);

    }

}
