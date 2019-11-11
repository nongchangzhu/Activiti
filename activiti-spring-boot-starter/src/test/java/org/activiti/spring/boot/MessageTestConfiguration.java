package org.activiti.spring.boot;

import java.util.ArrayList;
import java.util.List;

import org.activiti.api.process.model.events.BPMNMessageCancelledEvent;
import org.activiti.api.process.model.events.BPMNMessageEvent;
import org.activiti.api.process.model.events.BPMNMessageReceivedEvent;
import org.activiti.api.process.model.events.BPMNMessageSentEvent;
import org.activiti.api.process.model.events.BPMNMessageWaitingEvent;
import org.activiti.api.process.runtime.events.listener.BPMNElementEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageTestConfiguration {

    public static List<BPMNMessageEvent> messageEvents = new ArrayList<BPMNMessageEvent>();

    @Bean
    public BPMNElementEventListener<BPMNMessageSentEvent> messageSentEventListener() {
        return bpmnMessageSentEvent -> messageEvents.add(bpmnMessageSentEvent);
    }
    
    @Bean
    public BPMNElementEventListener<BPMNMessageReceivedEvent> messageReceivedEventListener() {
        return bpmnMessageReceivedEvent -> messageEvents.add(bpmnMessageReceivedEvent);
    }
    
    @Bean
    public BPMNElementEventListener<BPMNMessageWaitingEvent> messageWaitingEventListener() {
        return bpmnMessageWaitingEvent -> messageEvents.add(bpmnMessageWaitingEvent);
    }  
    
    @Bean
    public BPMNElementEventListener<BPMNMessageCancelledEvent> messageCancelledEventListener() {
        return bpmnMessageCancelledEvent -> messageEvents.add(bpmnMessageCancelledEvent);
    }  
}
