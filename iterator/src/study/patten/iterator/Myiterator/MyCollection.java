package study.patten.iterator.Myiterator;

import study.patten.iterator.baseic.Collection;
import study.patten.iterator.baseic.Iterator;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/6/30   Time: 10:43
 * Description:
 **/
public class MyCollection implements Collection{

    public List<Object> myList;

    public MyCollection(List<Object> list){
        this.myList = list;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return myList.get(i);
    }

    @Override
    public int getSize() {
        return myList.size();
    }
}