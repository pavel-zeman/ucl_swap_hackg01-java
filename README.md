Simple chat application implemented using long polling.

# Usage
Start the application as usual, log in and at the bottom of the welcome page:
* Choose the technology - long polling or server-sent events (currently only long polling is implemented)
* Click _Wait for data_ to start reading of chat data from server
* Enter message text and click _Send data_ to publish message to all users using the chat
* You should see chat messages being added to the list just below the buttons almost instantly after they are published

# Implementation
## Long polling
There is no magic here. The polling is implemented as a standard command (`polling/poll`), which is
being automatically invoked in an infinite cycle. The server-side implementation is in `PollingAbl`.

A better approach would be to use asynchronous processing based on `DeferredResult`, but it does not work
with UAF filters, because they are invoked asynchronously without context and they fail.
Maybe this can be easily fixed, but I don't have time for detailed analysis now.

## Server-sent events (SSE)
TODO