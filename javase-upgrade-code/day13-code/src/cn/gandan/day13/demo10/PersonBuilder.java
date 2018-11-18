package cn.gandan.day13.demo10;

@FunctionalInterface
public interface PersonBuilder {
    abstract Person builderPerson(String name);
}
