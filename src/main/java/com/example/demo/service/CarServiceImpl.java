package com.example.demo.service;

import com.example.demo.domain.Car;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private static final Integer MIN_DOORS = 3;
    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Car save(Car car) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(List<Car> cars) {

    }

    @Override
    public void deleteAllById(List<Long> ids) {

    }

    @Override
    public List<Car> findByDoors(Integer doors) {
        return null;
    }

    @Override
    public List<Car> findByManufacturerAndModel(String manufacturer, String model) {
        return null;
    }

    @Override
    public List<Car> findByDoorsGreaterThanEqual(Integer doors) {
        return null;
    }

    @Override
    public List<Car> findByModelContaining(String model) {
        return null;
    }

    @Override
    public List<Car> findByYearIn(List<Integer> years) {
        return null;
    }

    @Override
    public List<Car> findByYearBetween(Integer startYear, Integer endYear) {
        return null;
    }

    @Override
    public List<Car> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public List<Car> findByAvailableTrue() {
        return null;
    }

    @Override
    public Long deleteAllByAvailableFalse() {
        return null;
    }
}
