package study.patten.iterator.baseic;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/6/30   Time: 10:36
 * Description:
 **/
public interface  Iterator {
    //前移
    Object previous();

    //后移
    Object next();

    boolean hasNext();
    //取得第一个元素
    Object first();
}