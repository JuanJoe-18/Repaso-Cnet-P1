package com.icesi.service.impl;

import com.icesi.model.Device;
import com.icesi.model.Measurement;
import com.icesi.repository.IDeviceRepository;
import com.icesi.repository.IMeasurementRepository;
import com.icesi.service.IMeasurementService;

import java.util.List;

public class MeasurementServiceImpl implements IMeasurementService {
    private final IMeasurementRepository measurements;
    private final IDeviceRepository devices;

    public MeasurementServiceImpl(IMeasurementRepository measurements, IDeviceRepository devices) {
        this.measurements = measurements;
        this.devices = devices;
    }

    public void add(Measurement measurement) {
        Device device = devices.findById(measurement.getAssetId());
        if (device == null) throw new IllegalArgumentException("Dispositivo inexistente");
        if (measurement.getValor() < device.getMinValue() || measurement.getValor() > device.getMaxValue()) {
            throw new IllegalArgumentException("Valor fuera de rango");
        }
        List<Measurement> previous = measurements.findByAssetId(device.getId());
        for (Measurement item : previous) {
            if (item.getTimestamp() == measurement.getTimestamp()) {
                throw new IllegalArgumentException("Timestamp duplicado");
            }
        }
        if (!previous.isEmpty()) {
            Measurement last = previous.get(previous.size() - 1);
            long difference = measurement.getTimestamp() - last.getTimestamp();
            long minimum = device.getSamplingPeriod() - device.getTimeTolerance();
            long maximum = device.getSamplingPeriod() + device.getTimeTolerance();
            if (difference < minimum || difference > maximum) {
                throw new IllegalArgumentException("Intervalo de muestreo inválido");
            }
        }
        measurements.add(measurement);
        device.addMeasurement(measurement);
    }

    @Override
    public List<Measurement> list() {
        return measurements.list();
    }

}
