package study.patten.iterator.Myiterator;

import study.patten.iterator.baseic.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/6/30   Time: 10:43
 * Description:
 **/
public class MyIterator implements Iterator {

    private MyCollection myCollection;
    private int pops = -1;

    public MyIterator(MyCollection myCollection){
        this.myCollection = myCollection;
    }

    @Override
    public Object previous() {
        pops = pops-1;
        return myCollection.get(pops);
    }

    @Override
    public Object next() {
        pops = pops+1;
        return myCollection.get(pops);
    }

    @Override
    public boolean hasNext() {
       if(pops < myCollection.getSize()-1){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public Object first() {
        pops = 0;
        return myCollection.get(pops);
    }
}