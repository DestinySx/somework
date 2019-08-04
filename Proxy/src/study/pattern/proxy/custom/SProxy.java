package study.pattern.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: suxin
 * Date: 2019/8/4   Time: 12:27
 * Description:
 **/
public class SProxy {

    public static Object newProxyInstance(SClassLoader classLoader,Class<?>[] interfaces,SInvocationHandler h){

        try{
        //1 动态生成java文件
        String src = generateSrc(interfaces);
        //2 讲java文件输出到磁盘
        String filePath = SProxy.class.getResource("").getPath();
        System.out.println(filePath);
        File f = new File(filePath+"$Proxy0.java");
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //3 编译刚刚的Java文件生成 .class文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null,null,null);
        Iterable iterable = manager.getJavaFileObjects(f);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null,manager,null,null,null,iterable);
        task.call();
        manager.close();


        //4 加载刚刚编译的.class到jvm中
        Class proxyClass = classLoader.findClass("$Proxy0");
        Constructor constructor= proxyClass.getConstructor(SInvocationHandler.class);

        //5 返回字节码重组以后新的代理对象
        return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces){

        StringBuilder sb = new StringBuilder();

        String enter = "\r\n";
        sb.append("package study.pattern.proxy.custom;"+enter);
        sb.append("import study.pattern.proxy.jdk.Person;"+enter);
        sb.append("import java.lang.reflect.Method;"+enter);
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+enter);

            sb.append("SInvocationHandler h;"+enter);
            sb.append("public $Proxy0(SInvocationHandler h){"+enter);
                sb.append("this.h = h;"+enter);
            sb.append("}"+enter);

            for(Method m:interfaces[0].getMethods()){
                sb.append("public "+m.getReturnType().getName()+" "+m.getName()+"(){"+enter);
                    sb.append("try{"+enter);
                        sb.append("Method m ="+ interfaces[0].getName()+".class.getMethod(\""+m.getName()+"\",new Class[]{});"+enter);
                        sb.append("this.h.invoke(this,m,null);"+enter);
                    sb.append("}catch(Throwable e){"+enter);
                        sb.append("e.printStackTrace();"+enter);
                    sb.append("}"+enter);
                sb.append("}"+enter);
            }
        sb.append("}");

        return sb.toString();
    }
}