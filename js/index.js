const ref = require('ref');
const ffi = require('ffi');

const p_graal_isolatethread_t = ref.alloc(ref.refType(ref.types.void))

const libJava = ffi.Library('../libnativeimpl', {
  graal_create_isolate: [
    ref.types.int, [
      ref.refType(ref.types.void),
      ref.refType(ref.types.void),
      ref.refType(ref.refType(ref.types.void))
    ]],
  Java_org_pkg_apinative_Native_add: [
    ref.types.int,
    [ref.refType(ref.types.void), ref.types.int, ref.types.int]],
  Java_org_pkg_apinative_Native_hello: [
    ref.types.CString,
    [ref.refType(ref.types.void)]],
  Java_org_pkg_apinative_Native_rptstr: [
    ref.types.CString, [
      ref.refType(ref.types.void),
      ref.refType(ref.types.CString),
      ref.types.int
    ]],
    graal_tear_down_isolate: [
      ref.types.int,
      [ref.refType(ref.types.void)]],
})

const rc = libJava.graal_create_isolate(ref.NULL, ref.NULL, p_graal_isolatethread_t)
if (rc !== 0) {
  console.log('graal_create_isolate error')
}

const added = libJava.Java_org_pkg_apinative_Native_add(ref.deref(p_graal_isolatethread_t), 11, 22)
console.log(added)

const hello = libJava.Java_org_pkg_apinative_Native_hello(ref.deref(p_graal_isolatethread_t))
console.log(hello)

const rep = libJava.Java_org_pkg_apinative_Native_rptstr(ref.deref(p_graal_isolatethread_t), ref.allocCString("Hello"), 10)
console.log(rep)

libJava.graal_tear_down_isolate(ref.deref(p_graal_isolatethread_t))
