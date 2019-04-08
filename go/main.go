package main

/*
#include <stdlib.h>
#include <libnativeimpl.h>
#cgo CFLAGS: -I ../
#cgo LDFLAGS: -L ../ -lnativeimpl
*/
import "C"
import "fmt"

func main() {
	var thread *C.graal_isolatethread_t
	if C.graal_create_isolate(nil, nil, &thread) != 0 {
		fmt.Println("error on isolate creation or attach")
		return
	}
	result := C.Java_org_pkg_apinative_Native_add(thread, 1, 2)
	fmt.Println(result)

	hello := C.GoString(C.Java_org_pkg_apinative_Native_hello(thread))
	fmt.Println(hello)

	repeat := C.GoString(C.Java_org_pkg_apinative_Native_rptstr(thread, C.CString("ABC"), 3))
	fmt.Println(repeat)
}
