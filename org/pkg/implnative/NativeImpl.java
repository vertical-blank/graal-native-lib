package org.pkg.implnative;

import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.word.Pointer;

public final class NativeImpl {
    @CEntryPoint(name = "Java_org_pkg_apinative_Native_add")
    // public static int add(Pointer jniEnv, Pointer clazz, @CEntryPoint.IsolateThreadContext long isolateId, int a, int b) {
    static int add(IsolateThread thread, int a, int b) {
        return a + b;
    }

    // @CEntryPoint
    // static int add(IsolateThread thread, int a, int b) {
    //     return a + b;
    // }

}