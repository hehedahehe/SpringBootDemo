package elements;

import org.junit.Test;

/*
 * @desc
 * @author lirb
 * @datetime 2018/5/20,15:10
 */
public class PrimitiveTypeTest {
    private Integer intergerNum;
    private String numStr = "1";



    @Test
    public void testParseInt(){
        System.out.println(Integer.parseInt(numStr));
//        System.out.println(Integer.parseInt("")); // format error
//        System.out.println(Integer.parseInt("fdsafs")); // format error
//        System.out.println(Integer.parseInt(null)); // format error
    }

    /**
     * Returns the integer value of the system property with the
     * specified name.  The first argument is treated as the name of a
     * system property.
     */
    @Test
    public void testGetInt(){
        System.out.println(Integer.getInteger(numStr));
        System.out.println(Integer.getInteger(null));
        System.out.println(Integer.getInteger("fafds"));
        System.out.println(Integer.getInteger(""));
    }

    /**
     * 底层调用是parseInt
     */
    @Test
    public void testValueOf(){
        System.out.println(Integer.valueOf(numStr));
//        System.out.println(Integer.valueOf(null));
//        System.out.println(Integer.valueOf("fafds"));
//        System.out.println(Integer.valueOf(""));
    }


}
