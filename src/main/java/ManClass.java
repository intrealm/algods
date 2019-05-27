public class ManClass {


    public static void main(String args[])
    {

        //ditionInterface bi = (x,y)->x+y;

       //oSomethig(bi);

        doSomethig(System.out::println);

        doSomethig(Math::max);

        //doSomethig((x)->System.out.println(x),"this x");



    }

    static void doSomethig(additionInterface functionI)
    {
        System.out.println(functionI.addThem(5,8));
    }

    static void doSomethig(subtractionInterfacing functionI)
    {
        functionI.showValue("Rahul");
    }
}

interface additionInterface
{
    int addThem(int a,int b);
}


interface subtractionInterfacing
{
    void showValue(String str);
}


