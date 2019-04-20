package org.pkg.implnative;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.nativeimage.c.type.CTypeConversion.CCharPointerHolder;
import org.graalvm.nativeimage.c.type.CCharPointer;

public final class NativeImpl {
    @CEntryPoint(name = "Java_org_pkg_apinative_Native_add")
    static int add(IsolateThread thread, int a, int b) {
        return a + b;
    }

    @CEntryPoint(name = "Java_org_pkg_apinative_Native_rptstr")
    static CCharPointer repeatString(IsolateThread thread, CCharPointer cStr, int i) {
        String jStr = CTypeConversion.toJavaString(cStr);
        return CTypeConversion.toCString(IntStream.range(0, i).mapToObj(x -> jStr).collect(Collectors.joining())).get();
    }

    @CEntryPoint(name = "Java_org_pkg_apinative_Native_hello")
    static CCharPointer hello(IsolateThread thread) {
        return CTypeConversion.toCString("hello from native lib").get();
    }

}