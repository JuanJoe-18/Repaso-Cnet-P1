package com.icesi.repository;

import com.icesi.model.Measurement;
import java.util.List;

public interface IMeasurementRepository {
    void add(Measurement measurement);
    List<Measurement> list();
    List<Measurement> findByAssetId(int assetId);
}
