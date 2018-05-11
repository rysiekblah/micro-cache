# micro-cache
Main use-case for this cache is when we have to calulate delta of data feed. Say we get a User's data from one side, and another side needs to get only delta of every update. So this cache does that trick.

Usage:

```java
Cache<Integer, Account> cache = new Cache<>(Account.class, "id");

void handleMessage(Payload<Account> payload) {
  queue.publish(cache.addAll(payload.data());
}

class Account {
  private Integer id;
  private String clientName;
  private Long number;
  private Boolean active;

  public Account(Integer id, String clientName, Long number, Boolean active) {
    this.id = id;
    this.clientName = clientName;
    this.number = number;
    this.active = active;
  }
}
```

## Ignore fields in delta calculation
If you don't need particular fields to be considered in delta, you can exclude them using ```@DeltaIgnore``` annotation.

```java
class User {
  private Integer id;
  private String name;
  @DeltaIgnore
  private int loans;
  private int accounts;
````
If there is a change ONLY in ```loans``` field, delta won't be calculated.

# Tuples
This library provides neat implementation for tuples, which you might need in case when you have to create simple bean object. This might be very useful in unit testing too I quess.
There are twe versions, immutable and mutable. Related to immutability, if you have a tuple ```Tuple<Account> ``` you have to take care of ```Account``` immutability.
  
  Usage:
  
  ```java
  import static com.kozlowst.microcache.tuple.Tuples.tuple;
  import com.kozlowst.microcache.tuple.Tuples.*;
  
  Tuple4 account = tuple(1, "John", 12345, true);
  
  // check name
  if (account._2.equals("John")) {
    acceptTransaction(accout);
  }
  ```
  
  You an also use generics and parametrize Tuple to make it typesafe.
  
  ```java
  Tuple4<Long, String, Intger, Boolean> account = tuple(1L, "John", 12345, true);
  ```
  
  # Contribution
  Everyone is welcome!
  If you have any suggestions please email me or just create an issuse here.
  
  -- Tomasz
