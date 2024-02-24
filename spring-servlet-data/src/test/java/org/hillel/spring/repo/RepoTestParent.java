package org.hillel.spring.repo;

import org.hibernate.SessionFactory;
import org.hillel.spring.config.HibernateTestConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HibernateTestConfig.class})
public class RepoTestParent {
    @Autowired
    protected SessionFactory testSessionFactory;
}
