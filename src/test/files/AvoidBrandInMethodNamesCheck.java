/**
 *This file is the sample code against we run our unit test.
 *It is placed src/test/files in order to not be part of the maven compilation.
 **/
class AvoidBrandInNamesCheck {

  int aField;



  public String methodWithMYCOMPANY(int sht) {
    // Noncompliant {{Avoid using Brand in method name}}
    return  "123";
/
  }



  public void samsung() { // Compliant

  }
}
