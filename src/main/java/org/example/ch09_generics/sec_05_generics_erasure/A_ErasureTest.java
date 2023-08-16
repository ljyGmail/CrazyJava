package org.example.ch09_generics.sec_05_generics_erasure;

class Apple<T extends Number> {
    T size;
    public Apple() {

    }

    public Apple(T size) {
        this.size = size;
    }

    public void setSize(T size) {
        this.size = size;
    }

    public T getSize(){
        return  this.size;
    }
}

public class A_ErasureTest {
    public static void main(String[] args) {
        Apple<Integer> a = new Apple<>(6);
        // a的getSize()方法返回Integer对象
        Integer as = a.getSize();
        // 把a对象赋给Apple变量，丢失尖括号里的类型信息
        Apple b = a;
        // b只知道size的类型是Number
        Number size1 = b.getSize();
        // 下面代码引起编译错误
        // Integer size2 = b.getSize();
    }
}
