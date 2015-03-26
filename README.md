Resteasy and Guice 
==================

Simple example of Resteasy and GuiceFilter coexisting in a Servlet 3.0 webapp.

    $ mvn jetty:run

    $ curl 'http://localhost:9999/api/hello/Stranger' 
    Hello Stranger

    $ curl 'http://localhost:9999/hello?name=Stranger'
    Hello Stranger
