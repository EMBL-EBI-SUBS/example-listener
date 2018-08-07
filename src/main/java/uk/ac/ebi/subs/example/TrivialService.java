package uk.ac.ebi.subs.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TrivialService {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public void doSomethingTrivial(Message message){
        logger.info("Service method called with argument {}", message);
    }
}
