package cn.gandan.day12.Test.test01;

/*
    1.	定义一个函数式接口CurrentTimePrinter,其中抽象方法void printCurrentTime()，使用注解@FunctionalInterface
	2.	在测试类中定义static void showLongTime(CurrentTimePrinter timePrinter)，该方法的预期行为是使用timePrinter打印系统当前毫秒值
	3.	测试showLongTime(),通过lambda表达式完成需求
 */
@FunctionalInterface
public interface CurrentTimePrinter {
    abstract void printCurrentTime();
}
