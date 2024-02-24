package org.hillel.spring.model.mapper;

import org.hillel.spring.config.MapperTestConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MapperTestConfig.class})
public class MapperTestParent {
    @Autowired
    protected OrderMapper orderMapper;
}
