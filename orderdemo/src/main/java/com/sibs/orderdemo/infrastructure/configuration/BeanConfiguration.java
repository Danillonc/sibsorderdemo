package com.sibs.orderdemo.infrastructure.configuration;

import com.sibs.orderdemo.OrderdemoApplication;
import com.sibs.orderdemo.domain.repository.ItemRepository;
import com.sibs.orderdemo.domain.repository.OrderRepository;
import com.sibs.orderdemo.domain.repository.StockMovementRepository;
import com.sibs.orderdemo.domain.repository.UserRepository;
import com.sibs.orderdemo.domain.service.ItemService;
import com.sibs.orderdemo.domain.service.OrderService;
import com.sibs.orderdemo.domain.service.StockMovementService;
import com.sibs.orderdemo.domain.service.UserService;
import com.sibs.orderdemo.domain.service.impl.ItemServiceImpl;
import com.sibs.orderdemo.domain.service.impl.OrderServiceImpl;
import com.sibs.orderdemo.domain.service.impl.StockMovementServiceImpl;
import com.sibs.orderdemo.domain.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class responsible for configuring beans.
 */
@Configuration
@ComponentScan(basePackageClasses = OrderdemoApplication.class)
public class BeanConfiguration {

    @Bean
    UserService userService(final UserRepository userRepository){
        return new UserServiceImpl(userRepository);
    }

    @Bean
    StockMovementService stockService(final StockMovementRepository stockMovementRepository){
        return new StockMovementServiceImpl(stockMovementRepository);
    }

    @Bean
    OrderService orderService(final OrderRepository orderRepository, final StockMovementService stockService){
        return new OrderServiceImpl(orderRepository, stockService);
    }

    @Bean
    ItemService itemService(final ItemRepository itemRepository){
        return new ItemServiceImpl(itemRepository);
    }

}
