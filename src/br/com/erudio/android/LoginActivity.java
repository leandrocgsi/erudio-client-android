package br.com.erudio.android;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.zip.GZIPOutputStream;

import javax2android.xml.bind.JAXBException;
import javax2android.xml.stream.XMLStreamException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jettison.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.erudio.android.util.ConverterSHA1;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.xml.bind.v2.runtime.reflect.Accessor.GetterSetterReflection;

public class LoginActivity extends Activity {
    	

	private ProgressDialog pDialog;
	
	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";
	
	
	private String username;
	private String password;
	
	EditText inputUserName;
	EditText inputPasword;

	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        inputUserName = (EditText) findViewById(R.id.inputUserName);
        inputPasword = (EditText) findViewById(R.id.inputPasword);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
                
        btnLogin.setOnClickListener(new View.OnClickListener() {
			
        	String encoding;

			public void onClick(View v) {				
		        setUsername((inputUserName.getText().toString()).toString());
		        setPassword((ConverterSHA1.cipher(inputPasword.getText().toString())).toString());
		        
		        String authentication = username + ":" + password;
		        
				try {
					encoding = "Basic " + Base64.encodeToString(authentication.getBytes("UTF-8"), Base64.NO_WRAP).replace("\n", "");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        DefaultHttpClient httpClient = new DefaultHttpClient();
		        ResponseHandler<String> responseHandler = new BasicResponseHandler();
		        HttpPost postMethod = new HttpPost("http://10.0.2.2:8080/erudio-client-ws-exporter");    
		       
		        postMethod.setHeader("Authorization", encoding);
		        String response = null;
				try {
					response = httpClient.execute(postMethod,responseHandler);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("response :" + response);
				
		        Log.d("PASSO","Inicia o HttpComponentsClientHttpRequestFactory.");

				
			}
		});
        
    }
	
	private static void testConnection(WebResource resource) throws JSONException, XMLStreamException, JAXBException {
        ClientResponse response = resource.get(ClientResponse.class);
        if (response.getStatus() == 200) {
            String json = response.getEntity(String.class);
            System.out.println("O JSON gerado é: " + json);
        } else if (response.getStatus() == 403) {
            System.err.println("Você não tem permissão para acessar este recurso.");
        } else {
            System.err.println("Ocorreu um erro " + response.getStatus() + " ao tentar a conexão com o servidor.");
        }
                System.out.println("Estou chingando por isso: " + response.getEntity(String.class));
    }
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}