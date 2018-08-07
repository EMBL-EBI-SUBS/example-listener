package uk.ac.ebi.subs.example;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uk.ac.ebi.subs.messaging.ExchangeConfig;
import uk.ac.ebi.subs.messaging.Queues;


/**
 * This class creates a queue following our standard pattern (durable, with a dead letter exchange) and binds it to the
 * exchange using a topic.
 *
 * It is not necessary to use the beans directly, as we will see in our listener
 */
@Configuration
@ComponentScan(basePackageClasses = ExchangeConfig.class)
public class QueueConfig {

    public static final String EXAMPLE_QUEUE_NAME = "name-of-the-queue";
    private static final String EXAMPLE_TOPIC = "matches.some.routing.keys";

    /**
     * Instantiate a {@link Queue}
     *
     * @return an instance of a {@link Queue}
     */
    @Bean
    Queue exampleQueue() {
        return Queues.buildQueueWithDlx(EXAMPLE_QUEUE_NAME);
    }

    /**
     * Create a {@link Binding} between the exchange and queue using a topic.
     *
     * @param exampleQueue {@link Queue} note that its name matches the name of the queue bean method above
     * @param submissionExchange {@link TopicExchange}
     * @return a {@link Binding} between the exchange and the queue using a topic
     */
    @Bean
    Binding exampleQueueBinding(Queue exampleQueue, TopicExchange submissionExchange) {
        return BindingBuilder.bind(exampleQueue).to(submissionExchange)
                .with(EXAMPLE_TOPIC);
    }



}
