0.2.0 / 2013-04-23
=================
* Updating flush mechanism to a single thread that flushes in the background, and in batches when it can
* Removing `flushAt`, `flushAfter` options
* Adding alias command
* Removing async-http-client as dependency and replacing with Apache's HTTPComponents. Netty no longer needs to start to flush

0.1.7 / 2013-03-22
=================
* Adding context.providers and nested properties support

0.1.6 / 2013-03-22
=================
* Fixed utf-8 encoding issue

0.1.4 / 2013-01-18
=================
* Setting `flushAt` default to 20

0.1.3 / 2013-01-17
=================
* Removing sessionId
* Fixing POM

0.1.0 / 2013-01-14
=================
* Repo going public