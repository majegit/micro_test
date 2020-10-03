package com.example;

class Main {

  public static void main(String[] args) throws Exception {
    // Listener services use:
    /*
    Service.service(new Subscription[]{
        new Subscription("user-history", "buy-product", (body, sender) -> {
          System.out.println("user-history: buy-product");
        }),
        new Subscription("user-history", "login", (body, sender) -> {
          System.out.println("user-history: login");
          sender.send("buy-product", "Coffee");
        })
    });
    */
    Subscription.Sender globalSender1 = Service.service(new Subscription[]{
      new Subscription("display", "display", (body, sender) -> {
        System.out.println(body);
        // Push message over socket to the user
      })
    });
    globalSender1.send("fetch-product-page", "SessionID, UserID, ProductID");
    //globalSender.send("fetch-product-page", "SessionID, UserID, ProductID");
  }

}
