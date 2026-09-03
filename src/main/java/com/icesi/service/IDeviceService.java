package com.icesi.service;

import com.icesi.model.Device;

import java.util.List;

public interface IDeviceService {
    void add(Device device);
    List<Device> list();
    Device findById(int id);
    void update(Device device);
    void delete(int id);
}
