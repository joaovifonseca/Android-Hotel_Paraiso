package com.example.hotelparaiso.model;

public class Reserva {
    private String ID_ALUGA;
    private String ID_USU_ALUGA;
    private String ID_QRT_ALUGA;
    private String DT_ENTRADA;
    private String DT_SAIDA;

    public String getID_ALUGA() {
        return ID_ALUGA;
    }

    public void setID_ALUGA(String ID_ALUGA) {
        this.ID_ALUGA = ID_ALUGA;
    }

    public String getID_USU_ALUGA() {
        return ID_USU_ALUGA;
    }

    public void setID_USU_ALUGA(String ID_USU_ALUGA) {
        this.ID_USU_ALUGA = ID_USU_ALUGA;
    }

    public String getID_QRT_ALUGA() {
        return ID_QRT_ALUGA;
    }

    public void setID_QRT_ALUGA(String ID_QRT_ALUGA) {
        this.ID_QRT_ALUGA = ID_QRT_ALUGA;
    }

    public String getDT_ENTRADA() {
        return DT_ENTRADA;
    }

    public void setDT_ENTRADA(String DT_ENTRADA) {
        this.DT_ENTRADA = DT_ENTRADA;
    }

    public String getDT_SAIDA() {
        return DT_SAIDA;
    }

    public void setDT_SAIDA(String DT_SAIDA) {
        this.DT_SAIDA = DT_SAIDA;
    }

    @Override
    public String toString() {
        return "Número da reserva : " + this.ID_ALUGA +
                " \nData Entrada " + this.DT_ENTRADA.substring(0, 10)
                + "\nData Saída " + this.DT_SAIDA.substring(0, 10);
    }
}
