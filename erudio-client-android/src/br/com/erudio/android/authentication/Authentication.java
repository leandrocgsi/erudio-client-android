package br.com.erudio.android.authentication;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.HttpHeaders;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;

public class Authentication {

    public static WebResource authenticate(String url, final String username, final String password) {

        Client client = Client.create();
        client.addFilter(new ClientFilter() {
            @Override
            public ClientResponse handle(ClientRequest clientRequest)throws ClientHandlerException {            	                                                                              
                try {
					clientRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Basic " + new String(android.util.Base64.encodeToString((username + ":" + password).getBytes("UTF-8"),android.util.Base64.NO_WRAP)));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
                return getNext().handle(clientRequest);
            }
        });        
        return client.resource(url);
    }
    
}