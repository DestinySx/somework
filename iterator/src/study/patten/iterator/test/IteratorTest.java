package study.patten.iterator.test;

import study.patten.iterator.Myiterator.MyCollection;
import study.patten.iterator.Myiterator.MyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/6/30   Time: 10:54
 * Description:
 **/
public class IteratorTest {
    public static void main(String[] args) {
        List<Object> list =  new ArrayList<>(Arrays.asList("CNNKG","CNSHH-CNSHA-CNSGH","USLAX-USLGB"));
        MyCollection myCollection = new MyCollection(list);

        MyIterator myIterator = (MyIterator) myCollection.iterator();
        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}