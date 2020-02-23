package com.tehArchitecht.task3;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class MainTest {

    @Test
    public void test1SortInReverseOrder() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Main.sortInReverseOrder(list);

        Assert.assertEquals(list, new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1)));
    }

    @Test
    public void test2SortInReverseOrder() {
        ArrayList<Double> list = new ArrayList<>(Arrays.asList(-2.0, 0.0, -1.0, 1.0, 2.0));
        Main.sortInReverseOrder(list);

        Assert.assertEquals(list, new ArrayList<Double>(Arrays.asList(2.0, 1.0, 0.0, -1.0, -2.0)));
    }

    @Test
    public void test3SortInReverseOrder() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("cd", "ab", "abc"));
        Main.sortInReverseOrder(list);

        Assert.assertEquals(list, new ArrayList<String>(Arrays.asList("cd", "abc", "ab")));
    }

    @Test
    public void test1SumOfList() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(15.0, Main.sumOfList(list));
    }

    @Test
    public void test2SumOfList() {
        ArrayList<Integer> list = new ArrayList<>();
        Assert.assertEquals(0.0, Main.sumOfList(list));
    }

    @Test
    public void test1In() {
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        Assert.assertTrue(Main.in(1, map));
    }

    @Test
    public void test2In() {
        Map map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        Assert.assertFalse(Main.in(null, map));
    }

    @Test
    public void test3In() {
        Map map = new HashMap();
        Assert.assertFalse(Main.in("test", map));
    }

    @Test
    public void test1Insert() {
        LinkedList<Double> list = new LinkedList<>(Arrays.asList(1.0, 2.0, 3.0));
        Main.insert(10.0, list, InsertLocation.Beginning);

        Assert.assertEquals(list, new LinkedList<Double>(Arrays.asList(10.0, 1.0, 2.0, 3.0)));
    }

    @Test
    public void test2Insert() {
        LinkedList<Double> list = new LinkedList<>(Arrays.asList(1.0, 2.0, 3.0));
        Main.insert(10.0, list, InsertLocation.End);

        Assert.assertEquals(list, new LinkedList<Double>(Arrays.asList(1.0, 2.0, 3.0, 10.0)));
    }

    @Test
    public void test1Find() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(Main.find(1, list), 0);
    }

    @Test
    public void test2Find() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(Main.find(5, list), 4);
    }

    @Test
    public void test3Find() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(Main.find(null, list), -1);
    }
}