package br.com.erudio.android.authentication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;
import javax.ws.rs.core.HttpHeaders;
import org.springframework.security.core.codec.Base64;

public class Authentication {

    public static WebResource authenticate(String url, final String username, final String password) {

        Client client = Client.create();
        client.addFilter(new ClientFilter() {
            @Override
            public ClientResponse handle(ClientRequest clientRequest)throws ClientHandlerException {
                clientRequest.getHeaders().add(HttpHeaders.AUTHORIZATION, "Basic " + new String(Base64.encode((username + ":" + password).getBytes())));
                return getNext().handle(clientRequest);
            }
        });        
        return client.resource(url);
    }
    
}