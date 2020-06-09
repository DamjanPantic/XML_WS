package com.programatori.searchservice.repository;

import com.programatori.searchservice.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SearchRepository extends JpaRepository<Vehicle,Long> {



    @Query(value = "select v from Vehicle v" +
            " inner join v.availabilities a "+
            "where ((a.place) = (:place))" +
            "and ((:toDate) <=  (a.toDate) and (:fromDate) >=  (a.fromDate))" +
            "and (((:brand) is null ) or ((v.model.manufacturer.name) = (:brand)))" +
            "and (coalesce(:models, null) is null or (v.model.name) in (:models))")
    List<Vehicle> getBySearchParams(@Param("place") String place,
                                    @Param("fromDate") Date fromDate,
                                    @Param("toDate") Date toDate,
                                    @Param("brand") String brand,
                                    @Param("models") List<String> models);
}
