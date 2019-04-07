# play with graal native shared

## build java

```sh
javac -cp $GRAAL_HOME/jre/lib/boot/graal-sdk.jar org/pkg/implnative/NativeImpl.java
```

## compile native shared object

`.h` file will be generated.

```sh
$GRAAL_HOME/bin/native-image --shared -H:Name=libnativeimpl
```

## compile C code and link

`-l` option must be after `.c` source file name.

```sh
gcc -Wall -I ./ -L ./ main.c -l nativeimpl
```

## run

```sh
LD_LIBRARY_PATH=$LD_LIBRARY_PATH:. ./a.out
```
