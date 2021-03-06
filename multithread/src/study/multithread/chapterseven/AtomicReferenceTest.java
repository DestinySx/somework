package study.multithread.chapterseven;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2018/9/11   Time: 11:45
 * Description:·AtomicReference：原子更新引用类型。
               ·AtomicReferenceFieldUpdater：原子更新引用类型里的字段。
               ·AtomicMarkableReference：原子更新带有标记位的引用类型。
 **/
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("conan",15);
        atomicUserRef.set(user);
        User updateUser = new User("Shinichi",17);
        atomicUserRef.compareAndSet(user,updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }

    static class User {
        private String name;
        private int old;
        public User(String name,int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }
}