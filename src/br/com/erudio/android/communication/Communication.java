package br.com.erudio.android.communication;


import java.util.List;

import br.com.erudio.android.beans.BaseBean;
import br.com.erudio.android.communication.interfaces.ICommunication;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Communication<T extends BaseBean> implements ICommunication<T> {

    private Class<T> bean;
    WebResource resource;
    
    
    public Communication(Class<T> classe, WebResource resource) {
        super();
        this.bean = classe;
        this.resource = resource;
    }

    /** Este método é responsável por salvar uma informação no servidor*
     * @param path Esse parâmetro deve receber uma String contendo o path de acesso ao serviÃ§o desejado Ex: "service/cidade/save"
     * @param mediaType Esse parâmetro deve receber o MimeType a ser usado na comunicação Ex: "Application/JSON"
     * @param bean Esse parâmetro deve receber uma instância do objeto a ser persistido Ex: Cidade cidade     */
 	public ClientResponse save(String path, String mediaType) {
         ClientResponse response = resource.path(path).accept(mediaType).post(ClientResponse.class, bean);	
         return response;
 	}

     /** Este método é responsável por atualizar uma informação no servidor*
     * @param path Esse parâmetro deve receber uma String contendo o path de acesso ao serviÃ§o desejado Ex: "service/cidade/update"
     * @param mediaType Esse parâmetro deve receber o MimeType a ser usado na comunicação Ex: "Application/JSON"
     * @param bean Esse parâmetro deve receber uma instância do objeto a ser persistido Ex: Cidade cidade     */
 	public ClientResponse update(String path, String mediaType) {
         ClientResponse response = resource.path(path).accept(mediaType).put(ClientResponse.class, bean);
         return response;
 	}

     /** Este método é responsável por deletar uma informação no servidor*
      * @param path Esse parâmetro deve receber uma String contendo o path de acesso ao serviÃ§o desejado Ex: "service/cidade/delete/{id}"
      * @param id Esse parâmetro deve receber o id do objeto a ser deletado
      * @param mediaType Esse parâmetro deve receber o MimeType a ser usado na comunicação Ex: "Application/JSON"*/
 	public ClientResponse delete(String path, Integer id, String mediaType) {		
         ClientResponse response = resource.path(path + id.toString()).accept(mediaType).post(ClientResponse.class, bean);
         return response;
 	}

     /** Este método é responsável por localizar uma informação no servidor a partir de um id*
      * @param path Esse parâmetro deve receber uma String contendo o path de acesso ao serviÃ§o desejado Ex: "service/cidade/findbyid/{id}"
      * @param id Esse parâmetro deve receber o id do objeto a ser deletado
      * @param mediaType Esse parâmetro deve receber o MimeType a ser usado na comunicação Ex: "Application/JSON"*/
 	public ClientResponse findById(String path, Integer id, String mediaType) {
 		ClientResponse response = resource.path(path + id).accept(mediaType).get(ClientResponse.class);
 		return response;
// 		if (mediaType == "Application/JSON"){
// 			String json = response.getEntity(String.class);
// 			bean = (T) ParseJSONToObject.parserJSONToObject(json, classe);
// 			return bean;
// 		} else {
// 			InputStream inputStream = response.getEntityInputStream();
// 			bean = ParseXMLToObject.parserXMLToObject(inputStream, classe);
// 			return bean;
// 		}				
 	}

 	public List<T> findAll() {
 		// TODO Auto-generated method stub
 		return null;
 	}

 	public List<T> findByQuery() {
 		// TODO Auto-generated method stub
 		return null;
 	}
}
