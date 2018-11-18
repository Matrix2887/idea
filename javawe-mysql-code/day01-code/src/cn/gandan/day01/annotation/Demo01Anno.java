package cn.gandan.day01.annotation;

@SuppressWarnings("all")
public class Demo01Anno {

    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){

    }

    @MyAnno(value = 16,per = Person.p1,anon2 = @MyAnno2,
    strs = {1,2,3})
    public void show2(){

    }

    public void demo(){
        show1();
    }

}
