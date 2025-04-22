package basic.ch08.sec09;

public class ExtendsExample {
    public static void main(String[] args) {
        InterfaceClmpl impl = new InterfaceClmpl();

        //A
        InterfaceA ia = impl;
        ia.methodA();
//        ia.methodB();
        System.out.println();

        //B
        InterfaceB ib = impl;
        ib.methodB();
        System.out.println();

        // C
        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();

    }
}
