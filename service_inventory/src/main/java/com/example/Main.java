package com.example;

class Main {

  public static void main(String[] args) throws Exception {

    // Listener services use:
    Service.service(new Subscription[]{
        new Subscription("river_fetch-stock", "fetch-stock", (body, sender) -> {
          String[] body_str = body.split(",");
          System.out.println("Received \"fetch-stock\" event.");
          sender.send("display",body_str[0] + ",stock," + body_str[2] + ",2"); //The stock in the location that the user specified
        })
    });
  }
    

}
