import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    //Домашнее задание.

    @Test
    public void divTest3() {

        Calculator calc = new Calculator();
        Assert.assertEquals(calc.div(4.4, 2.2), 2); //Деление дробных чисел.

    }

    @Test
    public void sqrtTest1() {

        Calculator calc = new Calculator();
        Assert.assertEquals(calc.sqrt(256), 16); //Вычисление квадратного корня.

    }


    //Работа на уроке.

//    @Test
//    public void sumTest1() {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals(calc.sum(2, 3), 5);
//
//    }
//
//    @Test
//    public void sumTest2() {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals(calc.sum(-2, -3), -5);
//
//    }
//
//    @Test
//    public void sumTest3() {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals(calc.sum(2, -3), -1);
//
//    }
//
//    @Test
//    public void divTest1() {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals(calc.div(4, 2), 2);
//
//    }

//    @Test
//    public void divTest2() {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals(calc.div(4, 0), 0);
//
//        Assert.assertThrows(java.lang.ArithmeticException.class, () -> calc.div(4, 0));
//
//    }

}
