package repository.service;

import model.service.RentType;

import java.util.List;

public interface RentTypeRepository {
    List<RentType> selectAllRentType();

    RentType getRentTypeById(int id);

}
