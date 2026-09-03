package com.icesi.config;

import com.icesi.repository.Dbini;
import com.icesi.repository.IDeviceRepository;
import com.icesi.repository.impl.DeviceRepositoryImpl;
import com.icesi.repository.IMeasurementRepository;
import com.icesi.repository.impl.MeasurementRepositoryImpl;
import com.icesi.service.IDeviceService;
import com.icesi.service.impl.DeviceServiceImpl;
import com.icesi.service.impl.MeasurementServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public IDeviceRepository deviceRepository() {
        return new DeviceRepositoryImpl();
    }

    @Bean
    public IMeasurementRepository measurementRepository() {
        return new MeasurementRepositoryImpl();
    }

    @Bean
    public IDeviceService deviceService(IDeviceRepository repository) {
        return new DeviceServiceImpl(repository);
    }

    @Bean
    public MeasurementServiceImpl measurementService(IMeasurementRepository measurements, IDeviceRepository devices) {
        return new MeasurementServiceImpl(measurements, devices);
    }

    @Bean(initMethod = "initData")
    public Dbini dbini(IDeviceRepository repository, IMeasurementRepository measurements) {
        return new Dbini(repository, measurements);
    }
}
