package leetcode.questions.test.string;

import leetcode.questions.string.Largest_Number_179;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/10/2016.
 */
public class Largest_Number_179_Test {

    @Test
    public void testEdge() {
        assertEquals("0", Largest_Number_179.largestNumber(new int[] {0, 0}));
    }

    @Test
    public void testSimple() {
        assertEquals("9534330", Largest_Number_179.largestNumber(new int[] {3, 30, 34, 5, 9}));
    }

    @Test
    public void testComplex() {
        assertEquals("989839820974997189712970968965994699354927391898983882885548323815280807840773577327720769876927645751875017475745272917231718971717130712670957048703870256921686867786764676467116665662866256394634162546209610759975825579857545746569555455222499249204907476345814312429441534114411439923932370336503576356334483443321308830623020291928842857283926592448241923392323232120992066200416291380", Largest_Number_179.largestNumber(new int[] {
                4312,7645,98,8323,7452,9659,569,4153,5222,2323,7189,9469,4907,7692,9354,7048,8080,3020,6921,6868,6764,3576,
                6107,7475,2066,9189,3992,983,3703,8152,7171,6628,9718,2004,4763,4294,2448,4920,2099,3932,7025,6764,3650,
                4581,2884,7130,3088,7126,7720,3062,970,7698,5825,8828,5746,9273,6341,9749,968,1629,6254,7840,4114,7518,
                7291,8554,545,6209,321,5754,4114,7038,6711,7231,8983,5997,7095,3448,9712,7735,2339,7501,1380,6625,6394,
                3563,2857,6665,7732,6778,2419,9820,2839,5798,4992,2321,3443,2919,2659,55
        }));
    }

}
