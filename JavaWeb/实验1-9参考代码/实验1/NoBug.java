
package ex1;
public class NoBug {

    @Check
    public void print() {
        System.out.println("1234567890");
    }

   @Check
    public void add() {
        System.out.println("1 + 1 = " + (1 + 1));
    }

   @Check
    public void subtract() {
        System.out.println("1 - 1 = " + (1 - 1));
    }

    @Check
    public void multiply() {
        System.out.println("3 × 5 = " + (3 * 5));
    }

    @Check
    public void divide() {
        System.out.println("6 / 0= " + (6 / 0));
    }

    public void manifesto() {
        System.out.println("我写的程序没有 bug!");
    }

}
