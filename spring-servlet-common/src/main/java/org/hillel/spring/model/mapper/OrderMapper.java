package org.hillel.spring.model.mapper;


import org.hillel.spring.model.dto.OrderDTO;
import org.hillel.spring.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    OrderDTO orderToOrderDTO(Order order);
    Order orderDtoToOrder(OrderDTO orderDTO);
}
