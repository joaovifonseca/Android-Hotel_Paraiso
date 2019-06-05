package com.example.hotelparaiso.model;

import java.io.Serializable;

public class Usuario {
    private String ID_USU;
    private String CPF_USU;

    public String getID_USU() {
        return ID_USU;
    }

    public void setID_USU(String ID_USU) {
        this.ID_USU = ID_USU;
    }

    public String getCPF_USU() {
        return CPF_USU;
    }

    public void setCPF_USU(String CPF_USU) {
        this.CPF_USU = CPF_USU;
    }

    public String getNOME_USU() {
        return NOME_USU;
    }

    public void setNOME_USU(String NOME_USU) {
        this.NOME_USU = NOME_USU;
    }

    public String getSENHA_USU() {
        return SENHA_USU;
    }

    public void setSENHA_USU(String SENHA_USU) {
        this.SENHA_USU = SENHA_USU;
    }

    public String getSEXO_USU() {
        return SEXO_USU;
    }

    public void setSEXO_USU(String SEXO_USU) {
        this.SEXO_USU = SEXO_USU;
    }

    public String getTIPO_USU() {
        return TIPO_USU;
    }

    public void setTIPO_USU(String TIPO_USU) {
        this.TIPO_USU = TIPO_USU;
    }

    public String getTELEFONE_USU() {
        return TELEFONE_USU;
    }

    public void setTELEFONE_USU(String TELEFONE_USU) {
        this.TELEFONE_USU = TELEFONE_USU;
    }

    public String getCELULAR_USU() {
        return CELULAR_USU;
    }

    public void setCELULAR_USU(String CELULAR_USU) {
        this.CELULAR_USU = CELULAR_USU;
    }

    public String getENDERECO_USU() {
        return ENDERECO_USU;
    }

    public void setENDERECO_USU(String ENDERECO_USU) {
        this.ENDERECO_USU = ENDERECO_USU;
    }

    public String getCIDADE_USU() {
        return CIDADE_USU;
    }

    public void setCIDADE_USU(String CIDADE_USU) {
        this.CIDADE_USU = CIDADE_USU;
    }

    public String getEMAIL_USU() {
        return EMAIL_USU;
    }

    public void setEMAIL_USU(String EMAIL_USU) {
        this.EMAIL_USU = EMAIL_USU;
    }

    private String NOME_USU;
    private String SENHA_USU;
    private String SEXO_USU;
    private String TIPO_USU;
    private String TELEFONE_USU;
    private String CELULAR_USU;
    private String ENDERECO_USU;
    private String CIDADE_USU;
    private String EMAIL_USU;

    public Usuario(String ID_USU,
                   String CPF_USU,
                   String NOME_USU,
                   String SENHA_USU,
                   String SEXO_USU,
                   String TIPO_USU,
                   String TELEFONE_USU,
                   String CELULAR_USU,
                   String ENDERECO_USU,
                   String CIDADE_USU,
                   String EMAIL_USU) {
        this.CPF_USU = CPF_USU;
        this.ID_USU = ID_USU;
        this.CPF_USU = CPF_USU;
        this.NOME_USU = NOME_USU;
        this.SENHA_USU = SENHA_USU;
        this.SEXO_USU = SEXO_USU;
        this.TIPO_USU = TIPO_USU;
        this.TELEFONE_USU = TELEFONE_USU;
        this.CELULAR_USU = CELULAR_USU;
        this.ENDERECO_USU = ENDERECO_USU;
        this.CIDADE_USU = CIDADE_USU;
        this.EMAIL_USU = EMAIL_USU;
    }

    public Usuario(){}

}
