import java.util.Scanner;

public class Triangle {
    public enum TriangleType {
        NOTriangle,GTriangle,RTriangle,D2Triangle,D3Triangle,UNKNOWN
    }
    //判断是否能构成三角形
    public static TriangleType JudgeTriangle(int a,int b,int c)
    {
        if(a+b>c&&a+c>b&&b+c>a)
        {
            return TriangleType.GTriangle;
        }
        else
        {
            return TriangleType.NOTriangle;
        }
    }

    //判断是否能构成等腰三角形
    public static TriangleType JudgeDTriangle(int a,int b,int c)
    {
        if(a==b||a==c||b==c)
        {
            if(a==b&&a==c)
            {
                return TriangleType.D3Triangle;
            }
            else
            {
                return TriangleType.D2Triangle;
            }
        }
        else
        {
            return TriangleType.UNKNOWN;
        }

    }
    //判断是否是直角三角形
    public static TriangleType JudgeRTriangle(int a,int b,int c)
    {
        int r1,r2,r3;
        r1=a*a+b*b-c*c;
        r2=a*a+c*c-b*b;
        r3=b*b+c*c-a*a;
        /*System.out.println(r1+r2+r3);*/
        if(r1==0||r2==0||r3==0)
        {
            return TriangleType.RTriangle;
        }
        else
        {
            return TriangleType.UNKNOWN;
        }

    }

    public static void main(String [] args)
    {
        int a;
        int b;
        int c;
        if(args.length != 3)
            return;
        try{
            a = Integer.valueOf(args[0]);
            b = Integer.valueOf(args[1]);
            c = Integer.valueOf(args[2]);
        }catch (Exception e){
            System.out.println("你输入的三边不合法！");
            return;
        }

//        else{
//            System.out.println("请输入三角形的三条整数边: ");
//            Scanner scanner=new Scanner(System.in);
//            a=scanner.nextInt();
//            b=scanner.nextInt();
//            c=scanner.nextInt();
//        }
        //判断输入三边是否合法
        if(a<=0||a>200||b<=0||b>200||c<=0||c>200)
        {
            System.out.println("你输入的三边不合法！");
        }
        else
        {
            //判断是否能构成三角形
            if(JudgeTriangle(a,b,c) == TriangleType.NOTriangle)
                System.out.println("这不是三角形");
            else{
                //判断是否是等腰或等边三角形
                if(JudgeDTriangle(a,b,c) == TriangleType.D2Triangle)
                    System.out.println("该三角形是等腰三角形");
                if(JudgeDTriangle(a,b,c) == TriangleType.D3Triangle)
                    System.out.println("该三角形是等边三角形");
                //判断是否是直角三角形
                if(JudgeRTriangle(a,b,c) == TriangleType.RTriangle)
                    System.out.println("该三角形是直角三角形");
                //判断是一般三角形
                if(JudgeDTriangle(a,b,c) == TriangleType.UNKNOWN
                        &&JudgeRTriangle(a,b,c) == TriangleType.UNKNOWN)
                    System.out.println("该三角形是一般三角形!");
            }
        }
    }
}

