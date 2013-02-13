package br.com.erudio.android.parsers;

import java.io.InputStream;

import br.com.erudio.android.beans.BaseBean;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ParseXMLToObject<T extends BaseBean> {

	public static <T extends BaseBean> Object parserXMLToObject(InputStream inputStream, Class<T> classe) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(classe);
        @SuppressWarnings("unchecked")
		T bean = (T) xStream.fromXML(inputStream); 
        return bean;
    }
}

/*private static BeanCidade parserXMLToObject(InputStream inputStream) {
    XStream xStream = new XStream(new DomDriver());
    xStream.processAnnotations(BeanCidade.class);
    cidade = (BeanCidade) xStream.fromXML(inputStream);
    System.out.println("As informações da cidade recuperada são, ID : " + cidade.getIdCidade() + ", Nome " + cidade.getNomeCidade() + "\n"
            + "e o Estado de: " + cidade.getUf() + ":->");
    return cidade;
}*/