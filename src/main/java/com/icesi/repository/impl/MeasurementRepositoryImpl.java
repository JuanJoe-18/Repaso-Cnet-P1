package com.icesi.repository.impl;

import com.icesi.model.Measurement;
import com.icesi.repository.IMeasurementRepository;
import java.util.ArrayList;
import java.util.List;

public class MeasurementRepositoryImpl implements IMeasurementRepository {
    private final List<Measurement> measurements = new ArrayList<>();

    public void add(Measurement measurement) {
        measurements.add(measurement);
    }

    public List<Measurement> list() {
        return new ArrayList<>(measurements);
    }

    public List<Measurement> findByAssetId(int assetId) {
        List<Measurement> result = new ArrayList<>();
        for (Measurement m : measurements) {
            if (m.getAssetId() == assetId) result.add(m);
        }
        return result;
    }

}
