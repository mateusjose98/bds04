package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;

    public Page<EventDTO> findAllPaged(Pageable pageable) {
        Page<Event> page = eventRepository.findAll(pageable);
        return page.map(EventDTO::new);

    }

    public EventDTO insert(EventDTO dto) {

        Event entity = toEntity(dto);
        var entitySaved = eventRepository.save(entity);
        return new EventDTO(entitySaved);

    }

    private Event toEntity(EventDTO dto){
        Event entity = new Event();
        City city = cityRepository.getOne(dto.getCityId());
        BeanUtils.copyProperties(dto, entity);
        entity.setCity(city);
        return entity;
    }
}
