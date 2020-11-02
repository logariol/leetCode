package com.recepie.recepie.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TestObj {
    public final String f;
    public final String l;
    public final String m;
    public final int age;

    public TestObj(String f, String l, String m, int age) {
        this.f = f;
        this.l = l;
        this.m = m;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "f='" + f + '\'' +
                ", l='" + l + '\'' +
                ", m='" + m + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObj testObj = (TestObj) o;

        if (age != testObj.age) return false;
        if (f != null ? !f.equals(testObj.f) : testObj.f != null) return false;
        if (l != null ? !l.equals(testObj.l) : testObj.l != null) return false;
        return m != null ? m.equals(testObj.m) : testObj.m == null;
    }

    @Override
    public int hashCode() {
        int result = f != null ? f.hashCode() : 0;
        result = 31 * result + (l != null ? l.hashCode() : 0);
        result = 31 * result + (m != null ? m.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        HashSet<TestObj> set = new HashSet<>();

        TestObj o1 = new TestObj("a", "b", "c", 1);
        TestObj o2 = new TestObj("a", "b", "c", 2);
        set.add(o1);
        set.add(o2);

        System.out.println(set.contains(new TestObj("a", "b", "c", 1)));

        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());

        System.out.println(o1.equals(o2));

        System.out.println(Arrays.toString(set.toArray()));


        Map<TestObj, Integer> m = new HashMap<>();
        m.put(o1, 1);
        m.put(o2, 2);
        System.out.println(m.get(new TestObj("a", "b", "c", 1)));

    }
}
