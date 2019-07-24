import java.util.ArrayList;
import java.util.List;


class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int basePoint = 500000;
        List<Integer> fibocacciList = generateFibonacciList();
        int primeFibonacciBeforeBasePoint = getPrimeFibonacciBeforeBasePoint(fibocacciList);
        if (primeFibonacciBeforeBasePoint == 0) {
            System.out.format("No prime number found that is also a fibonacci bellow %d\n", basePoint);//immpossible.
        } else {
            System.out.format("Largest fibonacci bellow %d that is also a prime number, is %d\n", basePoint, primeFibonacciBeforeBasePoint);
        }
        int primeFibonacciAfterBasepoint = getPrimeFibonacciAfterBasePoint(fibocacciList);

        System.out.format("Smallest fibonacci after %d that is also a prime number, is %d\n", basePoint, primeFibonacciAfterBasepoint);
        System.out.format("Difference: %d\n", primeFibonacciAfterBasepoint - primeFibonacciBeforeBasePoint);
    }

    private static int getPrimeFibonacciBeforeBasePoint(List<Integer> list){
        for (int i = list.size() - 1; i >= 0; i--) {
            int fibonacci = list.get(i);
            if(isPrimeNumber(fibonacci)) {return fibonacci;}
        }
        return 0;
    }

    private static int getPrimeFibonacciAfterBasePoint(List<Integer> list){
        int lastFibonacci =  list.get(list.size() - 1);
        int secondLastFibonacci = list.get(list.size() - 2);
        while (true){
            int sum = secondLastFibonacci + lastFibonacci;
            if(isPrimeNumber(sum)){return sum;}
            secondLastFibonacci = lastFibonacci;
            lastFibonacci = sum;
        }
    }

    private static List generateFibonacciList(){
        List list = new ArrayList<Integer>();
        int previousNumber = 0, nextNumber = 1;
        System.out.print(previousNumber+" ");list.add(previousNumber);
        while (nextNumber <= 500000){
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            System.out.print(nextNumber+" ");list.add(nextNumber);
            nextNumber = sum;
        }
        return list;
    }

    private static boolean isPrimeNumber(int number){
        //check if n is a multiple of 2
        if (number%2==0) {return (number == 2);}
        //if not, then just check the odds
        for (int i=3;i*i<=number;i+=2) {
            if(number%i==0)
                return false;
        }
        return true;
    }
}


// --------- style #2 --------


//class Main {
//    public static void main(String[] args) {
//        //int target = Integer.parseInt(args[0]);
//        int target = 500000;
//        int a = 0, b = 1;
//        int lo = -1, hi = -1;
//        while(b <= target){
//            if(isPrime(b))
//                lo = b;
//            int s = a + b;
//            a = b;
//            b = s;
//        }
//        while (true){
//            if(isPrime(a)){
//                hi = a;
//                break;
//            }
//            int s = a + b;
//            a = b;
//            b = s;
//        }
//
//        if (lo == -1 || hi == -1){
//            System.out.println("No prime > 0 && < " + target);//immpossible.
//        }else{
//            System.out.println("Closest prime fib below " + target + ": " + lo);
//            System.out.println("Closest prime fib above " + target + ": " + hi);
//        }
//    }
//
//
//    private static boolean isPrime(int n){
//        if(n == 2)
//            return true;
//        if (n%2==0)
//            return false;
//        for(int i=3;i*i<=n;i+=2)
//            if(n%i==0)
//                return false;
//        return true;
//    }
//}
