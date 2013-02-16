package br.com.erudio.android.beans;

import br.com.semeru.javax2android.xml.bind.annotation.XmlAccessType;
import br.com.semeru.javax2android.xml.bind.annotation.XmlAccessorType;
import br.com.semeru.javax2android.xml.bind.annotation.XmlRootElement;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XStreamAlias("beanCidade")
public class BeanCidade extends BaseBean{

    private static final long serialVersionUID = 1L;

    private Integer idCidade;
    private String nomeCidade;
    private String uf;
    private String sigla;
    private String pais;

    public BeanCidade() {
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
