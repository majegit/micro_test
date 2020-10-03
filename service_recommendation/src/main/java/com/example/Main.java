package com.example;

class Main {

  public static void main(String[] args) throws Exception {
    // Listener services use:
    
    Service.service(new Subscription[]{
        new Subscription("river_recommendation", "fetch-product-page", (body, sender) -> {
          String[] body_str = body.split(",");
          sender.send("display",body_str[0] + ",recommendation"+",0,1,2");
          sender.send("fetch-product",body_str[0]+","+body_str[1]+",0");
          sender.send("fetch-product",body_str[0]+","+body_str[1]+",1");
          sender.send("fetch-product",body_str[0]+","+body_str[1]+",2");
          System.out.println("INSIDE recommendation");
        })
    });
  }
}
