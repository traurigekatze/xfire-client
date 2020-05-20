package com.kerry.xfireclient.sender;

import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.exchange.OutMessage;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;


public class HttpMessageSender extends CommonsHttpMessageSender {

    public HttpMessageSender(OutMessage message, MessageContext context) {
        super(message, context);
    }
    @Override
    protected synchronized void createClient() {
        super.createClient();
        HttpClientParams params = (HttpClientParams) getMessageContext().getContextualProperty(HTTP_CLIENT_PARAMS);
        if (params != null) {
            HttpConnectionManagerParams connParams = getClient().getHttpConnectionManager().getParams();
            connParams.setDefaults(params);
//            HttpConnectionManager httpManager = getClient().getHttpConnectionManager();
//            IdleManager.getInstance().addHttpManager(httpManager);
        }
    }
}
