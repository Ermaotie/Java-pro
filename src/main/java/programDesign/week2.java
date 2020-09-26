package programDesign;


public class week2 {

    public static void main(String[] args) {

        int MaxNums=100;
        int MaxNum=300;

        for(int j=2;j<MaxNums;j++) {
            search(j, MaxNum);
        }
    }

    public static void search(int a, int b)
    {
        int[] left = init(a);
        int sumNum;

        for(int i = a; i<=b;i++)
        {
            left[(Math.floorMod(i,a))]=pow3(i);
            sumNum = sum(left);
            double temp = Math.pow(sumNum, 1.0/3);
            if (Math.abs(temp-Math.round(temp))<=0.0000001) {
                System.out.printf("%d 到 %d 的三次方的和为 %d 的三次方\n",(i-a+1),i,Math.round(temp));
            }
        }
    }

    public static int[] init(int a)
    {
        int[] left =new int[a];
        int i=0;
        for(int b:left)
        {
            left[Math.floorMod(i,a)]=pow3(i);
            i++;
        }
        return left;
    }

    public static int pow3(int x)
    {
        return x*x*x;
    }

    public static int sum(int[] a){
        int res=0;
        for(int x:a)
        {
            res+=x;
        }
        return res;
    }
}
