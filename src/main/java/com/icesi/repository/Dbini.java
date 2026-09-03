package com.icesi.repository;

import com.icesi.model.Device;
import com.icesi.model.Measurement;

import java.util.UUID;

public class Dbini {

    private final IDeviceRepository deviceRepository;
    private final IMeasurementRepository measurementRepository;

    public Dbini(IDeviceRepository deviceRepository, IMeasurementRepository measurementRepository) {
        this.deviceRepository = deviceRepository;
        this.measurementRepository = measurementRepository;
    }

    public void initData () {
        for (int i = 1; i <= 5; i++) {
            String uuid = "SERIAL-" + i;
            Device device = new Device(i,"1",uuid,"1",150000,0,1000,50,"metros");
            deviceRepository.add(device);
            long baseTime = System.currentTimeMillis();
            for (int j = 1; j <= 3; j++) {
                long timestamp = baseTime + (j * device.getSamplingPeriod());
                Measurement m = new Measurement(j,timestamp,j*device.getSamplingPeriod(),i);
                device.getMeasurements().add(m);
                measurementRepository.add(m);
            }
        }
    }




}
