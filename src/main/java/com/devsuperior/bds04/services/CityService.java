package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> findAll() {
        List<City> cities = cityRepository.findAll(Sort.by("name"));
        return cities.stream().map(CityDTO::new).collect(Collectors.toList());
    }

    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        BeanUtils.copyProperties(dto, entity);
        var entitySaved = cityRepository.save(entity);
        return new CityDTO(entitySaved);
    }
}
