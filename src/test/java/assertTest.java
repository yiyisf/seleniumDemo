import org.testng.Assert;

import static org.testng.Assert.assertEquals;

/**
 * Created by liuzhe on 2019/2/17.
 */
public class assertTest {
    public static void main(String[] args) throws InterruptedException{
        String actual = "登录成功";
        String expect = "dengluchenggong";

        assertEquals(actual,expect,"expected" + expect + ",but found " + actual);
        //assertTrue(actual.equals(expect));
        //assertFalse(actual.equals(expect));
        Assert.assertEquals(actual,expect);
    }
}
