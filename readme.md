# play with graal native shared

## build java

`.class` will be generated.

```sh
javac -cp $GRAAL_HOME/jre/lib/boot/graal-sdk.jar org/pkg/implnative/NativeImpl.java
```

## compile native shared object

`.h`, `.so` (linux) or `.dylib` (mac) files will be generated.

```sh
$GRAAL_HOME/bin/native-image --shared -H:Name=libnativeimpl
```

## compile C code and link

`-l` option must be after `.c` source file name.

```sh
gcc -Wall -I ./ main.c -L ./ -l nativeimpl
```

## run

set `LD_LIBRARY_PATH` is not necessary on mac.

```sh
LD_LIBRARY_PATH=$LD_LIBRARY_PATH:. ./a.out
```

## call from golang

set `LD_LIBRARY_PATH` is not necessary on mac.

```sh
LD_LIBRARY_PATH=$LD_LIBRARY_PATH:. go run main.go
```
