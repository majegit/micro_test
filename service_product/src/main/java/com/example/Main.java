package com.example;

class Main {

  public static void main(String[] args) throws Exception {
    // Listener services use:
    
    Service.service(new Subscription[]{
        new Subscription("river_product", "fetch-product-page", (body, sender) -> {
          String[] body_str = body.split(",");
          String a = body_str[0]+", product, "+body_str[2]+", Coffee";
          sender.send("display", a);
        }),
        new Subscription("river_product", "fetch-product", (body, sender) -> {
          String[] body_str = body.split(",");
          String a = body_str[0]+", product, "+body_str[2]+", Coffee";
          sender.send("display", a);
        })
    });
    
  }

}
