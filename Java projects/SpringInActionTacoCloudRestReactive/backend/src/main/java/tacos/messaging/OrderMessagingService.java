package tacos.messaging;

import tacos.entities.Order;

public interface OrderMessagingService {

  void sendOrder(Order order);

}