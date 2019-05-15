package com.hyl.core.filter;

//public class MyMessageListener implements MessageListener {
//
//    String name = "consumer-"+ RandomUtil.randomString(5);
//    public  MyMessageListener() {
//        System.out.println(name + " started");
//    }
//
//    @Override
//    public void onMessage(Message message) {
//        TextMessage textMessage=(TextMessage)message;
//        try {
//            System.out.println(name+" 接收到消息："+textMessage.getText());
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }
//}
