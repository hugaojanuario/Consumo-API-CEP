package com.viacep.challenge.domain;

import com.viacep.challenge.api.CepViaCep;

public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;

    public Endereco(String cep, String logradouro, String bairro) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
    }

    public Endereco(CepViaCep meuCepViaCep){

        this.cep = meuCepViaCep.cep();
        this.bairro = meuCepViaCep.bairro();
        this.logradouro = meuCepViaCep.logradouro();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
