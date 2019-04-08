# play with graal native shared

## requirements

- GraalVM is installed
- set $GRAAL_HOME environment variable

## compile java

`.class` file will be generated to `.java` existing directory.

```sh
javac -cp $GRAAL_HOME/jre/lib/boot/graal-sdk.jar java/org/pkg/implnative/NativeImpl.java
```

## compile native shared object

`.h`, `.so` (linux) or `.dylib` (mac) files will be generated.

```sh
$GRAAL_HOME/bin/native-image --shared -H:Name=libnativeimpl -cp java
```

## compile C code and link

`-l` option must be after `.c` source file name.

```sh
gcc -Wall -I ./ c/main.c -L ./ -l nativeimpl
```

## run

set `LD_LIBRARY_PATH` is not necessary on mac.

```sh
LD_LIBRARY_PATH=$LD_LIBRARY_PATH:. ./a.out
```

## call from golang

set `LD_LIBRARY_PATH` is not necessary on mac.

```sh
LD_LIBRARY_PATH=$LD_LIBRARY_PATH:. go run go/main.go
```
