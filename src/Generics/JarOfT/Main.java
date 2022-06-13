package Generics.JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();

        jar.add(12);
        jar.add(52);

        System.out.println(jar.remove());
        System.out.println(jar.remove());

    }

}
