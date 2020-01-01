package com.traveloka.calenderorg.web.transformer;

/**
 * @author badrikant.soni
 */
public interface Converter<DTO, Entity> {

    DTO toDTO(Entity entity);

    Entity toEntity(DTO dto);

}
