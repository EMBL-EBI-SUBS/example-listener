package uk.ac.ebi.subs.example;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {

    public Listener(TrivialService trivialService) {
        this.trivialService = trivialService;
    }

    private TrivialService trivialService;

    /**
     * This method receives messages from the named queue.
     *
     * the message is cleared from the queue once the method completes
     *
     * messages that cannot be mapped to the argument type will result in the message being dropped.
     *
     * exceptions will result in the message being re-queued and retried.
     * With our normal configuration, message will be retried three times, with a delay before being placed in a dead
     * letter exchange queue.
     *
     * @param message
     */
    @RabbitListener(queues = QueueConfig.EXAMPLE_QUEUE_NAME)
    public void receiveMessage(Message message) {

        trivialService.doSomethingTrivial(message);

    }
}
