package com.icesi.model;

public class Measurement {
    int id;
    long Timestamp;
    double valor;
    int assetId;

    public Measurement(int id, long timestamp, double valor, int id_del_dispositivo) {
        this.id = id;
        Timestamp = timestamp;
        this.valor = valor;
        assetId = id_del_dispositivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(long timestamp) {
        Timestamp = timestamp;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }
}
