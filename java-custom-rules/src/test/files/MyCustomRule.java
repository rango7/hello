class A {

  private int a;

  //123123123123
  int foo() {}

  /**
   * sthashtnoe
   * @param a
   * @return
   */
  int foo(int a) {} // Noncompliant {{message}}
  int foo(int a, int b) {}

  Object foo(Object a){} // Noncompliant {{message}}
  String foo(String a){} // Noncompliant {{message}}
  String foo(Object a){}
}