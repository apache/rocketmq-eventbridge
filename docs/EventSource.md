## Use HttpSource to put events

EventBridge HttpSource allows you to put events to eventbus in the form of webhook.

Here is an example explaining how to put events using EventBridge HttpSource.

1. Create an EventBridge HttpSource

    - eventSourceName: Name of EventSource
    - eventBusName: Name of EventBus
    - description: Description
    - className: HttpEvent. This parameter is a fixed value and cannot be modified.
    - config: HttpSource Config
    - Type: Request type. Available values are 'HTTP', 'HTTPS' and 'HTTP&HTTPS'.
    - Method: Allowed HTTP request methods. The request will be filtered if the http request method type for accessing
      the webhook does not meet the configuration.
    - SecurityConfig: Security configuration type. Available values are 'none', 'ip' and 'referer'.
    - Ip: IP security configuration. Http requests whose source ip is not in the configured network segment will be
      filtered if the security configuration is selected as 'ip'.
    - Referer: Referer security configuration. HTTP requests whose referer is not in this configuration will be filtered
      if the security configuration is selected as 'referer'.

A webhook will be generated after the creation of HttpSource.

```text
POST /source/createEventSource HTTP/1.1
Host: demo.eventbridge.com
Content-Type: application/json; charset=utf-8
{
  "eventSourceName": "httpEventSourceDemo",
  "eventBusName": "demo",
  "description": "http source demo",
  "className": "HttpEvent",
  "config": {
    "Type": "HTTP&HTTPS",
    "Method": ["GET", "POST"],
    "SecurityConfig": "ip",
    "Ip": ["10.0.0.0/8"],
    "Referer":[]
  }
}
```
