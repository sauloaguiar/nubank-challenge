# nubank-challenge

  The basic idea of my solution rely in the [MVP pattern](http://antonioleiva.com/mvp-android/) to separate concerns and responsibilities in the application.
  Every view - i.e. activity - has one corresponding presenter that handles the logic intricacies. For example, calling the network to get data to populate the screen.

### Helpful Resources
 + [Unit Testing Support](http://tools.android.com/tech-docs/unit-testing-support)
 + [Testing Android](http://developer.android.com/tools/testing/testing_android.html)
 + [Unit Testing with MVP](https://www.youtube.com/watch?v=Asc4hU1iSTU)

### Libraries
 + [Retrofit](http://square.github.io/retrofit/)
 + [JUnit](http://junit.org/)
 + [Mockito](http://mockito.org/)
 + [Gson](https://github.com/google/gson)

#### Domain Specific Hypermedia Formats
  A good hypermedia format conveys both domain-specific(values of information elements belonging to a business resource) and protocol information (how to make progress in a business process).
  Augmenting the hypermedia format
  Content-Type headers - not schema namespaces - declare how a representation is to be processed.

## References
  [Rest in Practice - Jim Webber](http://www.amazon.com/REST-Practice-Hypermedia-Systems-Architecture/dp/0596805829)
