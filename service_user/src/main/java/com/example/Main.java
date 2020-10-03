package com.example;

class Main {

  public static void main(String[] args) throws Exception {
    // Listener services use:
    Service.service(new Subscription[]{
        new Subscription("river_user", "fetch-product-page", (body, sender) -> {
          String[] body_str = body.split(",");
          System.out.println("Received \"fetch-product-page\" event.");
          sender.send("fetch-stock", body_str[0]+",Odense,"+body_str[2]);
        })
    });
  }

    // Gateway service uses:
    /*
    Subscription.Sender globalSender = Service.service(new Subscription[]{
        new Subscription("display", "display", (body, sender) -> {
          System.out.println("display: display");
          System.out.println(body);
          // Push message over socket to the user
        })
    });
    globalSender.send("display", "Everything works!");
  }
  */

}
