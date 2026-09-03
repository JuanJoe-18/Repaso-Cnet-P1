package com.icesi.repository.impl;

import com.icesi.model.Device;
import com.icesi.repository.IDeviceRepository;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepositoryImpl implements IDeviceRepository {

    private final List<Device> devices = new ArrayList<>();

    @Override
    public void add(Device device) {
        devices.add(device);
    }

    @Override
    public List<Device> list() {
        return new ArrayList<>(devices);
    }

    @Override
    public Device findById(int id) {
        return devices.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Device device) {
        Device existing = findById(device.getId());
        if (existing != null) {
            existing.setName(device.getName());
            existing.setSerialNumber(device.getSerialNumber());
            existing.setType(device.getType());
            existing.setMaxValue(device.getMaxValue());
            existing.setMinValue(device.getMinValue());
            existing.setSamplingPeriod(device.getSamplingPeriod());
            existing.setTimeTolerance(device.getTimeTolerance());
            existing.setUnit(device.getUnit());
            existing.setUbicacion(device.getUbicacion());
            existing.setEstate(device.getEstate());
        }
    }

    @Override
    public void delete(int id) {
        devices.removeIf(d -> d.getId() == id);
    }
}
