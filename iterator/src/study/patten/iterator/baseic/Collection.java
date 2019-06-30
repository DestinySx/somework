package study.patten.iterator.baseic;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/6/30   Time: 10:36
 * Description:
 **/
public interface Collection {

    Iterator iterator();

    /*取得集合元素*/
    Object get(int i);

    int getSize();
}
