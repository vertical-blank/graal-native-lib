#!/bin/bash
rm *.h *.so org/pkg/implnative/*.class;
javac -cp ~/graal/graalvm-ce-1.0.0-rc15/jre/lib/boot/graal-sdk.jar org/pkg/implnative/NativeImpl.java;
~/graal/graalvm-ce-1.0.0-rc15/bin/native-image --shared --no-server -H:Name=libnativeimpl; # -cp nativeimpl;