# play with graal native shared

## requirements

- GraalVM is installed
- set $GRAAL_HOME environment variable

## compile java

`.class` file will be generated to `.java` existing directory.

```sh
$GRAAL_HOME/bin/javac java/org/pkg/implnative/NativeImpl.java
```

## compile native shared object

`.h`, `.so` (linux) or `.dylib` (mac) files will be generated.

```sh
$GRAAL_HOME/bin/native-image --shared -H:Name=libnativeimpl -cp java
```

## compile C code and link

`-l` option must be after `.c` source file name.

```sh
gcc -Wall -I ./ c/main.c -L ./ -l nativeimpl -Wl,-rpath='$ORIGIN/'
```

## run C binary

```sh
./a.out
```

## build golang

golang 1.11 or later is required for `-Wl,-rpath` option.

```sh
go build go/main.go
```

## run golang binary

```sh
./main
```
