# nubank-challenge

  The basic idea of my solution is to maintain a state machine to keep of track of how the application state changes during its lifecycle.
  In order to have this abstraction, the Facade pattern is also being use to avoid exposing to much information to the Activity - which will interact with the Facade instead of knowing the intricacies of the State machine.
  The Facade will also be responsible to intermediate the communication with the network module.

### Helpful Resources
 + [Unit Testing Support](http://tools.android.com/tech-docs/unit-testing-support)
 + [Testing Android](http://developer.android.com/tools/testing/testing_android.html)
 + [Unit Testing with MVP](https://www.youtube.com/watch?v=Asc4hU1iSTU)
 + [State Pattern](https://en.wikipedia.org/wiki/State_pattern)
 + [Facade Pattern](https://en.wikipedia.org/wiki/Facade_pattern)

### Libraries
 + [Retrofit](http://square.github.io/retrofit/)
 + [JUnit](http://junit.org/)
 + [Mockito](http://mockito.org/)

#### Domain Specific Hypermedia Formats
  A good hypermedia format conveys both domain-specific(values of information elements belonging to a business resource) and protocol information (how to make progress in a business process).
  Augmenting the hypermedia format
  Content-Type headers - not schema namespaces - declare how a representation is to be processed.

## References
  [Rest in Practice - Jim Webber](http://www.amazon.com/REST-Practice-Hypermedia-Systems-Architecture/dp/0596805829)
