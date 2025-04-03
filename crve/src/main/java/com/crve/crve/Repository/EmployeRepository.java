package com.crve.crve.Repository;

import com.crve.crve.Model.EmploeyModel;

import java.util.Optional;

public interface EmployeRepository {

    Optional<EmploeyModel> findBy(int id);

    Optional<EmploeyModel> findAllBy(int id);
}
