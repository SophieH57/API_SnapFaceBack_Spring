package com.openclassrooms.snapfacebackspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.snapfacebackspring.model.Snap;

@Repository
public interface SnapRepository extends CrudRepository<Snap, Long>{

}
