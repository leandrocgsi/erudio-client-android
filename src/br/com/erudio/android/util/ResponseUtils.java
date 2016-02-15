package br.com.erudio.android.util;

import com.sun.jersey.api.client.ClientResponse;

public class ResponseUtils {
	
	public String responseStatus(ClientResponse response) {
		String mensagem = null;
		if (response.getStatus() == 200) {
			System.err.println("OK estamos conectados.");
        } else if (response.getStatus() == 403) {
            System.err.println("Você não tem permissão para acessar este recurso.");
        } else {
            System.err.println("Ocorreu um erro " + response.getStatus() + " ao tentar a conexão com o servidor.");
        }
		return mensagem;		
	}
}
