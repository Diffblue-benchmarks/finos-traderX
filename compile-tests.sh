#!/bin/bash

# Script to compile test classes after Diffblue fixes
# This compiles the custom base classes so Diffblue Cover can use them

echo "Compiling trade-processor test classes..."
./gradlew :trade-processor:compileTestJava --console=plain

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful"
    echo ""
    echo "You can now run Diffblue Cover again. The custom base classes:"
    echo "  - SocketIOJSONSubscriberDiffblueBase: prevents Spring context loading failures"
    echo "    for SocketIOJSONSubscriber methods (disconnect, internalConnect, setDefaultTopic, subscribe, unsubscribe)"
    echo "  - PubSubConfigDiffblueBase: prevents Publisher bean ambiguity issues for PubSubConfig"
    echo ""
    echo "These base classes will be automatically used by Diffblue Cover."
    echo ""
    echo "See SOCKETIO_FIX.md and PUBSUBCONFIG_FIX.md for details on the fixes."
else
    echo "✗ Compilation failed"
    exit 1
fi
