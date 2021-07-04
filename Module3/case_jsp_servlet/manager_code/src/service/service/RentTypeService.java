package service.service;

import model.service.RentType;

import java.util.List;

public interface RentTypeService {

    List<RentType> selectAllRentType();

    RentType getRentTypeById(int id);
}
