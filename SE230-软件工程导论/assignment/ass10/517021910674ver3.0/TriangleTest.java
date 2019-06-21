import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TriangleTest {

    private static Triangle triangle = new Triangle();

    private int a;
    private int b;
    private int c;
    private Triangle.TriangleType judgeTriangle;
    private Triangle.TriangleType judgeDTriangle;
    private Triangle.TriangleType judgeRTriangle;

    @Parameterized.Parameters(name = "{index}:({0},{1},{2})is[{3}&{4}&{5}]")
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {1,2,3,Triangle.TriangleType.NOTriangle,Triangle.TriangleType.UNKNOWN,Triangle.TriangleType.UNKNOWN},
                {2,3,4,Triangle.TriangleType.GTriangle,Triangle.TriangleType.UNKNOWN,Triangle.TriangleType.UNKNOWN},
                {3,4,5,Triangle.TriangleType.GTriangle,Triangle.TriangleType.UNKNOWN,Triangle.TriangleType.RTriangle},
                {13,12,5,Triangle.TriangleType.GTriangle,Triangle.TriangleType.UNKNOWN,Triangle.TriangleType.RTriangle},
                {24,25,7,Triangle.TriangleType.GTriangle,Triangle.TriangleType.UNKNOWN,Triangle.TriangleType.RTriangle},
                {2,2,2,Triangle.TriangleType.GTriangle,Triangle.TriangleType.D3Triangle,Triangle.TriangleType.UNKNOWN},
                {20,20,100,Triangle.TriangleType.NOTriangle,Triangle.TriangleType.D2Triangle,Triangle.TriangleType.UNKNOWN},
                {5,4,4,Triangle.TriangleType.GTriangle,Triangle.TriangleType.D2Triangle,Triangle.TriangleType.UNKNOWN},
                {1,7,1,Triangle.TriangleType.NOTriangle,Triangle.TriangleType.D2Triangle,Triangle.TriangleType.UNKNOWN},
                {200,1,1,Triangle.TriangleType.NOTriangle,Triangle.TriangleType.D2Triangle,Triangle.TriangleType.UNKNOWN}
        });
    }

    public TriangleTest(int a, int b, int c, Triangle.TriangleType judgeTriangle, Triangle.TriangleType judgeDTriangle, Triangle.TriangleType judgeRTriangle) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.judgeTriangle = judgeTriangle;
        this.judgeDTriangle = judgeDTriangle;
        this.judgeRTriangle = judgeRTriangle;
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void judgeTriangle() {
        Assert.assertEquals("是否三角形判断错误！",judgeTriangle,triangle.JudgeTriangle(a,b,c));
    }

    @Test
    public void judgeDTriangle() {
        Assert.assertEquals("是否等腰/等边三角形判断错误！",judgeDTriangle,triangle.JudgeDTriangle(a,b,c));
    }

    @Test
    public void judgeRTriangle() {
        Assert.assertEquals("是否直角三角形判断错误！",judgeRTriangle,triangle.JudgeRTriangle(a,b,c));
    }

    @Test
    public void main() {
        ArrayList<String[]> args = new ArrayList<>();
        String[] arg = {String.valueOf(a),String.valueOf(b),String.valueOf(c)};
        args.add(arg);
        String[] arg1 = {String.valueOf(a),String.valueOf(b),String.valueOf(c),String.valueOf(20)};
        args.add(arg1);
        String[] arg2 = {"aa","12s",String.valueOf(c)};
        args.add(arg2);
        String[] arg3 = {"0","201",String.valueOf(c)};
        args.add(arg3);
        String[] arg4 = {"201","0",String.valueOf(c)};
        args.add(arg4);
        String[] arg5 = {"1",String.valueOf(b),"0"};
        args.add(arg5);
        String[] arg6 = {"1",String.valueOf(b),"201"};
        args.add(arg6);
        String[] arg7 = {String.valueOf(a),"0",String.valueOf(c)};
        args.add(arg7);
        String[] arg8 = {String.valueOf(a),"201",String.valueOf(c)};
        args.add(arg8);

        for (var temp:args)
            triangle.main(temp);
    }
}