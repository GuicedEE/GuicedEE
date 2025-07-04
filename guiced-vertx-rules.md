# GuicedVertx Package Structure Guidelines

This document outlines the recommended package structure for the GuicedVertx module, designed to align with modern JDK 24 practices and provide a logical organization of components.

## Package Structure

The GuicedVertx module should be organized into the following package structure:

```
com.guicedee.vertx
├── core                  # Core Vert.x integration components
│   ├── VertX.java        # Main Vert.x configuration annotation
│   └── VertXModule.java  # Guice module for Vert.x integration
├── lifecycle             # Lifecycle management components
│   ├── VertXPreStartup.java  # Initialization of Vert.x
│   └── VertXPostStartup.java # Cleanup of Vert.x
├── eventbus              # Event bus related components
│   ├── publisher         # Event publishers
│   │   └── VertxEventPublisher.java  # Class for publishing events
│   ├── registry          # Event registration and management
│   │   └── VertxEventRegistry.java  # Registry for events
│   └── model             # Event models and definitions
│       ├── VertxEventDefinition.java  # Event definition
│       └── VertxEventOptions.java     # Event options
├── annotations           # Annotations for Vert.x components
├── config                # Configuration components
│   ├── VertxConfigurator.java        # Interface for configuring Vert.x
│   ├── ClusterVertxConfigurator.java # Cluster configuration
│   └── options           # Configuration options
│       ├── AddressResolverOptions.java  # DNS options
│       ├── EventBusOptions.java         # Event bus options
│       ├── FileSystemOptions.java       # File system options
│       └── MetricsOptions.java          # Metrics options
└── verticle              # Verticle related components
    ├── Verticle.java          # Base verticle class
    ├── VerticleBuilder.java   # Builder for verticles
    └── VerticleStartup.java   # Verticle startup interface
```

## Migration Guidelines

When migrating existing code to this new structure:

1. Move classes to their appropriate packages based on functionality
2. Update import statements in all affected files
3. Ensure module-info.java exports the new packages
4. Update any service provider configurations in META-INF/services
5. For event consumers, only the @VertxEventDefinition annotation is required:
   - Methods or classes with @VertxEventDefinition will be automatically registered as event consumers
   - The method should accept a Message<?> parameter or a parameter matching the event type
   - No additional annotations or interfaces are required

## Rationale

This package structure provides several benefits:

1. **Logical Grouping**: Classes are grouped by their functional area, making the codebase easier to navigate
2. **Separation of Concerns**: Clear separation between different aspects of the Vert.x integration
3. **Scalability**: Structure allows for future expansion with minimal disruption
4. **Discoverability**: Developers can quickly find related components
5. **Alignment with JDK 24**: Follows modern Java module system practices

## Examples

### Event Consumer Example

```java
package com.guicedee.vertx.eventbus.consumer;

import com.guicedee.vertx.VertxEventDefinition;
import io.vertx.core.eventbus.Message;

@VertxEventDefinition("user.event.address")
public class UserEventConsumer {
    //or per method @VertxEventDefinition("user.event.address")
    public void consume(Message<UserEvent> message) {
        // Handle user event
    }
}
```

### Verticle Example

```java
package com.guicedee.vertx.verticle;

import io.vertx.core.AbstractVerticle;

public class ApiVerticle extends AbstractVerticle {
    @Override
    public void start() {
        // Start verticle
    }
}
```

## Best Practices

1. Place interfaces and their primary implementations in the same package
2. Use subpackages for specialized implementations
3. Keep the public API surface minimal and well-documented
4. Follow Java naming conventions consistently
5. Prefer composition over inheritance where possible
