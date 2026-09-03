package com.icesi.model;

import java.util.ArrayList;
import java.util.List;

public class Device {

    int id;
    String name;
    String serialNumber;
    String ubicacion;
    String estate;
    String type;
    double maxValue;
    double minValue;
    long samplingPeriod;
    long timeTolerance;
    String unit;
    private List<Measurement> measurements;

    public Device(int id, String name, String serialNumber, String type, double maxValue, double minValue, long samplingPeriod, long timeTolerance, String unit) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.samplingPeriod = samplingPeriod;
        this.timeTolerance = timeTolerance;
        this.unit = unit;
        this.measurements = new ArrayList<>();
    }

    public Device(int id, String name, String serialNumber, String type, double maxValue, double minValue,
                  long samplingPeriod, long timeTolerance, String unit, String ubicacion, String estate) {
        this(id, name, serialNumber, type, maxValue, minValue, samplingPeriod, timeTolerance, unit);
        this.ubicacion = ubicacion;
        this.estate = estate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getEstate() { return estate; }
    public void setEstate(String estate) { this.estate = estate; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public long getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(long samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    public long getTimeTolerance() {
        return timeTolerance;
    }

    public void setTimeTolerance(long timeTolerance) {
        this.timeTolerance = timeTolerance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public void addMeasurement(Measurement measurement) {
        if (!measurements.contains(measurement)) {
            this.measurements.add(measurement);
        }
    }
}
