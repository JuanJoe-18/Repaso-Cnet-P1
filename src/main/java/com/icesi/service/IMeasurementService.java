package com.icesi.service;

import com.icesi.model.Measurement;

import java.util.List;

public interface IMeasurementService {
    void add(Measurement measurement);
    List<Measurement> list();
    //List<Measurement> findByAssetId(int assetId);
}
