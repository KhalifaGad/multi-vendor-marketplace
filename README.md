# Overview

Implementing multi vendor marketplace using Spring boot and following ports and adapters architecture, DDD and modular
monolith.

## Development

1. Create properties files and fill them with your own values (an example for each properties file exist under
   resources).
2. For cli users you can run `./gradlew runServer` or `/gradlew runWorker` to start the server and worker respectively.
3. For IDE users you can run the main class `Server:MultiVendorMarketplace` and `Worker:MultiVendorMarketplace`
   respectively.
4. The application relies on java version 22, so make sure you have it installed (pro tip: SDKMAN would be useful).
