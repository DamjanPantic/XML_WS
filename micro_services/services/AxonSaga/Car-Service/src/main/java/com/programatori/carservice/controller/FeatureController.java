package com.programatori.carservice.controller;

import com.programatori.carservice.dto.FeatureTypeDTO;
import com.programatori.carservice.dto.FeatureValueDTO;
import com.programatori.carservice.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @PostMapping(path = "/type", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addFeatureType(@RequestBody FeatureTypeDTO featureTypeDTO) {
        Set<FeatureTypeDTO> featureTypesDTO = featureService.addFeatureType(featureTypeDTO);
        if (featureTypesDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(featureTypesDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/type/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateFeatureType(@PathVariable String name, @RequestBody FeatureTypeDTO featureTypeDTO) {
        Set<FeatureTypeDTO> featureTypesDTO = featureService.updateFeatureType(name, featureTypeDTO);
        if (featureTypesDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(featureTypesDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/type/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFeatureType(@PathVariable String name) {
        Boolean deleted = featureService.deleteFeatureType(name);
        if (deleted == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(featureService.getAllFeatureTypes(), HttpStatus.OK);
    }

    @GetMapping(path = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFeatureType() {

        return new ResponseEntity<>(featureService.getAllFeatureTypes(), HttpStatus.OK);
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addFeatureValue(@RequestBody FeatureValueDTO featureValueDTO) {
        Set<FeatureValueDTO> featureValuesDTO = featureService.addFeatureValue(featureValueDTO);
        if (featureValuesDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(featureValuesDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/{featureValue}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateFeatureValue(@PathVariable String featureValue, @RequestBody FeatureValueDTO featureValueDTO) {
        Set<FeatureValueDTO> featureValuesDTO = featureService.updateFeatureValue(featureValue, featureValueDTO);
        if (featureValuesDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(featureValuesDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{featureValue}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFeatureValue(@PathVariable String featureValue) {
        Boolean deleted = featureService.deleteFeatureValue(featureValue);
        if (deleted == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(featureService.getAllFeatureValues(), HttpStatus.OK);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFeatureValue() {

        return new ResponseEntity<>(featureService.getAllFeatureValues(), HttpStatus.OK);
    }

    @GetMapping(path = "/{featureTypeName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFeatureValueOfType(@PathVariable String featureTypeName) {

        return new ResponseEntity<>(featureService.getFeatureValuesofType(featureTypeName), HttpStatus.OK);
    }
}
