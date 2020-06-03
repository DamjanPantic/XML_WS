package com.programatori.locationservice.service;

import com.programatori.locationservice.models.LocationEntry;
import com.programatori.locationservice.repository.ILocationEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationEntryService implements ILocationEntryService {

    @Autowired
    ILocationEntryRepository locationEntryRepository;
    @Override
    public boolean insertLocationEntry(LocationEntry locationEntry) {
        LocationEntry locationEntry1 = locationEntryRepository.save(locationEntry);
        if(locationEntry == null){
            return false;
        }
        return true;
    }
}
