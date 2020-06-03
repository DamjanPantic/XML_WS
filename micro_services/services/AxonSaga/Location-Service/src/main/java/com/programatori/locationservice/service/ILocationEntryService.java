package com.programatori.locationservice.service;

import com.programatori.locationservice.models.LocationEntry;

public interface ILocationEntryService {
    public boolean insertLocationEntry(LocationEntry locationEntry, String token);

}
