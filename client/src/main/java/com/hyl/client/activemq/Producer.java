package com.hyl.client.activemq;

//@Component
//public class Producer {
//
//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    @Autowired
//    private Destination textDestination;
//
//    public void sendTextMessage(final String text){
//        jmsTemplate.send(textDestination, new MessageCreator() {
//
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage(text);
//            }
//        });
//    }
//
//}