
package com.kerry.xfireclient.client;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;
import org.codehaus.xfire.xmlbeans.XmlBeansTypeRegistry;

public class HelloServiceClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public HelloServiceClient() {
        create0();
        Endpoint HelloServiceHttpPortEP = service0 .addEndpoint(new QName("http://test/HelloServie", "HelloServiceHttpPort"), new QName("http://test/HelloServie", "HelloServiceHttpBinding"), "http://kslist.cn:6443/xfire-web/servlet/xfire-servlet/HelloService");
        endpoints.put(new QName("http://test/HelloServie", "HelloServiceHttpPort"), HelloServiceHttpPortEP);
        Endpoint HelloServicePortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://test/HelloServie", "HelloServicePortTypeLocalEndpoint"), new QName("http://test/HelloServie", "HelloServicePortTypeLocalBinding"), "xfire.local://HelloService");
        endpoints.put(new QName("http://test/HelloServie", "HelloServicePortTypeLocalEndpoint"), HelloServicePortTypeLocalEndpointEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new XmlBeansTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((com.kerry.xfireclient.client.HelloServicePortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://test/HelloServie", "HelloServiceHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://test/HelloServie", "HelloServicePortTypeLocalBinding"), "urn:xfire:transport:local");
        }
    }

    public HelloServicePortType getHelloServiceHttpPort() {
        return ((HelloServicePortType)(this).getEndpoint(new QName("http://test/HelloServie", "HelloServiceHttpPort")));
    }

    public HelloServicePortType getHelloServiceHttpPort(String url) {
        HelloServicePortType var = getHelloServiceHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public HelloServicePortType getHelloServicePortTypeLocalEndpoint() {
        return ((HelloServicePortType)(this).getEndpoint(new QName("http://test/HelloServie", "HelloServicePortTypeLocalEndpoint")));
    }

    public HelloServicePortType getHelloServicePortTypeLocalEndpoint(String url) {
        HelloServicePortType var = getHelloServicePortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

}
