package br.com.erudio.android.parsers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;

import br.com.erudio.android.beans.BaseBean;

public class ParseJSONToObject<T extends BaseBean> {
	
    public static <T extends BaseBean> Object parserJSONToObject(String json, Class<T> classe) throws JAXBException, JSONException, XMLStreamException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classe);
        JSONObject jsonObject = new JSONObject(json);
        Configuration configuration = new Configuration();
        MappedNamespaceConvention mappedNamespaceConvention = new MappedNamespaceConvention(configuration);
        XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(jsonObject, mappedNamespaceConvention);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        @SuppressWarnings("unchecked")
		T bean = (T) unmarshaller.unmarshal(xmlStreamReader);
        return bean;
    }    
}


/*private Class parserJSONToObject(String json, Class bean) throws JAXBException, JSONException, XMLStreamException {
    JAXBContext jaxbContext = JAXBContext.newInstance(BeanCidade.class);
    JSONObject jsonObject = new JSONObject(json);
    Configuration configuration = new Configuration();
    MappedNamespaceConvention mappedNamespaceConvention = new MappedNamespaceConvention(configuration);
    XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(jsonObject, mappedNamespaceConvention);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    return cidade = (BeanCidade) unmarshaller.unmarshal(xmlStreamReader);
}*/