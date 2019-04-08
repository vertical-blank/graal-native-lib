#include <stdio.h>
#include <stdlib.h>
#include <libnativeimpl.h>

int main(void) {
  graal_isolatethread_t *thread = NULL;
  if (graal_create_isolate(NULL, NULL, &thread) != 0) {
    fprintf(stderr, "error on isolate creation or attach\n");
    return 1;
  }
  int result = Java_org_pkg_apinative_Native_add(thread, 1, 2);
  printf("%d\n", result);

	char* hello = Java_org_pkg_apinative_Native_hello(thread);
	printf("%s\n", hello);

	char* repeat = Java_org_pkg_apinative_Native_rptstr(thread, "ABC", 3);
	printf("%s\n", repeat);
}
