package uk.ac.ebi.subs.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ebi.subs.ExampleListenerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleListenerApplication.class)
public class SmokeTest {

    @Autowired Listener listener;

    Message message;

    @Before
    public void buildUp(){
        Message message = new Message();
        message.setAnIdentifier(12345L);
        message.setAnotherProperty(true);
        message.setSomeWords("this is a test");
        this.message = message;
    }

    @Test
    public void invokeListenerMethod(){
        this.listener.receiveMessage(message);
    }
}
