package com.icesi.service.impl;

import com.icesi.model.Device;
import com.icesi.repository.IDeviceRepository;
import com.icesi.service.IDeviceService;

import java.util.List;

public class DeviceServiceImpl implements IDeviceService {

    private final IDeviceRepository deviceRepository;

    public DeviceServiceImpl(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void add(Device device) {
        if (device.getSerialNumber() != null && device.getSerialNumber().length() > 20) {
            throw new IllegalArgumentException("El serial no puede tener más de 20 caracteres");
        }
        deviceRepository.add(device);
    }

    @Override
    public List<Device> list() {
        return deviceRepository.list();
    }

    @Override
    public Device findById(int id) {
        return deviceRepository.findById(id);
    }

    @Override
    public void update(Device device) {
        if (device.getSerialNumber() != null && device.getSerialNumber().length() > 20) {
            throw new IllegalArgumentException("El serial no puede tener más de 20 caracteres");
        }
        Device existing = deviceRepository.findById(device.getId());
        if (existing == null) {
            throw new IllegalArgumentException("El dispositivo a actualizar no existe");
        }
        deviceRepository.update(device);
    }

    @Override
    public void delete(int id) {
        Device existing = deviceRepository.findById(id);
        if (existing == null) {
            throw new IllegalArgumentException("El dispositivo a borrar no existe");
        }
        deviceRepository.delete(id);
    }
}
