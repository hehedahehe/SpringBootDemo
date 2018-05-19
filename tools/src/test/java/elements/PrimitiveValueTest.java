package elements;

import org.junit.Assert;
import org.junit.Test;

/*
 * @desc 测试Java原始类型
 * @author lirb
 * @datetime 2018/5/19,10:44
 */
public class PrimitiveValueTest {

    private Integer intergerNum;
    private int intNum;

    private double doubleNum;
    private Double aDoubleNum;

    private Long aLongNum;
    private long longNum;

    private byte byteNum;
    private Byte aByteNum;

    private String str;

    @Test
    public void testDefaultValue(){
        Assert.assertTrue(intergerNum == null);
        Assert.assertTrue(intNum == 0);
        Assert.assertTrue(aLongNum == null);
        Assert.assertTrue(longNum == 0);
        Assert.assertTrue(doubleNum == 0);
        Assert.assertTrue(aDoubleNum == null);
        Assert.assertTrue(byteNum == 0);
        Assert.assertTrue(aByteNum == null);
        Assert.assertTrue(str == null);
    }


    @Test
    public void testMaxValue(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("=====");
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println("=====");
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.SIZE);
        System.out.println("=====");
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        Assert.assertTrue(Byte.SIZE == 8);
        Assert.assertTrue(Byte.BYTES == 1);
        Assert.assertTrue(Integer.SIZE == 32);
        Assert.assertTrue(Integer.BYTES == 4);
        Assert.assertTrue(Long.SIZE == 64);
        Assert.assertTrue(Long.BYTES == 8);
        Assert.assertTrue(Double.SIZE == 64);
        Assert.assertTrue(Long.BYTES == 8);
    }




}
