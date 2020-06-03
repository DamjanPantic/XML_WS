package com.programatori.locationservice.service;

import com.programatori.locationservice.client.VehicleClient;
import com.programatori.locationservice.models.LocationEntry;
import com.programatori.locationservice.repository.ILocationEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationEntryService implements ILocationEntryService {

    @Autowired
    ILocationEntryRepository locationEntryRepository;

    @Autowired
    VehicleClient vehicleClient;

    @Override
    public boolean insertLocationEntry(LocationEntry locationEntry, String token) {

        Long vehicleId = vehicleClient.getVehicleIdByToken(token);
        locationEntry.setCarId(vehicleId);
        LocationEntry locationEntry1 = locationEntryRepository.save(locationEntry);
        if(locationEntry1 == null){
            return false;
        }
        return true;
    }
}
