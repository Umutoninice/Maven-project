package org.example.FunctionalInterface;

public class Main {
    public static void main(String[] args) {

   /* Predicate<Integer> p1= (num) -> {
        if(num%2==0){
            return true;
        }else{
            return false;
        }
    };
    System.out.println(p1.test(10));
    System.out.println(p1.test(3));

    Predicate<String>  p2 = (str)-> {
      if(str.isEmpty()){
          return true;
      }else{
          return false;
      }
    };
        System.out.println(p2.test(""));
        System.out.println(p2.test("Nice"));

    */
       /* Function<String, Integer> f1= (str) -> str.length();

        System.out.println(f1.apply("Hello"));

Function<Integer, Integer> f2 =(num)-> num*num;

        System.out.println(f2.apply(5));


        */
      //  Consumer<String> c1= (name)-> System.out.println("My name is: " + name);
      //  c1.accept("Nice");
        Supplier<Integer> s1= ()->{
            return (int) Math.random();
        };
        System.out.println(s1.get());

        Supplier<String> s2 = ()-> {
          String a=" Nice ";
          String b="Umutoni";
          return a.concat(b);

        };
        System.out.println(s2.get());
}
}
