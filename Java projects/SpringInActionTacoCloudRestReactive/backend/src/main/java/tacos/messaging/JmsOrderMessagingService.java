package tacos.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import tacos.entities.Order;


@Service
public class JmsOrderMessagingService implements OrderMessagingService {
  private JmsTemplate jms;

  @Autowired
  public JmsOrderMessagingService(JmsTemplate jms) {
    this.jms = jms;
  }

  @Override
  public void sendOrder(Order order) {
    jms.convertAndSend("tacocloud.order.queue", order,
            message -> {
              message.setStringProperty("X_ORDER_SOURCE", "WEB");
              return message;
            });
  }
}
