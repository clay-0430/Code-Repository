package com.wg.demo.calculate.code;

import com.alibaba.fastjson.JSON;
import com.wg.demo.calculate.tree.TreeNode;
import com.wg.demo.calculate.tree.preorder.Node;

import java.io.BufferedReader;
import java.io.File;
import java.util.*;
import java.util.concurrent.*;

/**
 * @Author : dongpo
 */
public class 多线程统计单词个数 {

    List<String> fileList;

    String wordcount(List<String> fileList) {
        return null;
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode curNode = stack1.pop();
            stack2.push(curNode);
            if (curNode.left != null) {
                stack1.push(curNode.left);
            }
            if (curNode.right != null) {
                stack1.push(curNode.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(0);
        System.out.println(queue.poll());
        System.out.println(queue);


//        String[] strs = content.trim().split(" ");
//
//        int threadNum = 5;
//
//        ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);
//
//
////        for (int i = 0; i < threadNum; i++) {
////
////        }
//
////        for (int i = 0; i < 100; i++) {
////            Future<String> future = threadPool.submit(new MyCallable("名字", i));
//////            String s = future.get();
//////            System.out.println(s);
////        }
//        for (int i = 0; i < 100; i++) {
//            int finalI = i;
//            threadPool.submit(() -> {
//                try {
//                    System.out.println(finalI);
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }

//        Future<?> future = threadPool.submit(() -> {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Object o = future.get();
//        System.out.println("res:" + JSON.toJSONString(o));


//        Map<String, Integer> curMap = new ConcurrentHashMap<>();
//
////
//        for (String str : strs) {
//            threadPool.execute(() -> {
//                Integer count = curMap.getOrDefault(str, 0) + 1;
//                curMap.put(str, count);
//            });
//        }
//
//        Callable<List<Integer>> callable = () -> {
//            return new ArrayList<>();
//        };
//
//        Future<List<Integer>> future = threadPool.submit(callable);
//
//
//        Integer[] arr = new Integer[5];
//        Arrays.stream(arr).sorted((o1, o2) -> o1 - o2);
//
//
//        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(curMap.entrySet());
//        mapList.sort((o1, o2) -> o2.getValue() - o1.getValue());
//
//        Collections.sort(mapList, (a, b) -> (b.getValue() - a.getValue()));
//
//
//        Map<String, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < 10; i++) {
//            map.put(mapList.get(i).getKey(), mapList.get(i).getValue());
//        }
//
//        System.out.println(map);
    }


    static class MyCallable implements Callable<java.lang.String> {

        private String name;
        private Integer id;

        public MyCallable(String name, Integer id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(new Random().nextInt(2000 - 500) + 500);
            System.out.println("执行第" + id + "次操作");
            return id + name + "????";
        }
    }


    static String content = "Facing a rising tide of outrage from Democrats and some Republicans over the forced separation of migrant children and parents at the U.S.-Mexico border, U.S. President Donald Trump dug in Monday, while his top law enforcement officials also forcefully defended the practice.\n" +
            "\n" +
            "\"The United States will not be a migrant camp and it will not be a refugee-holding facility — not on my watch,\" said Trump from the White House.\n" +
            "\n" +
            "\"A country without borders is not a country at all,\" he said.\n" +
            "\n" +
            "Trump's defence followed Homeland Security Secretary Kirstjen Nielsen and Attorney General Jeff Sessions refusing to apologize for separating children from their parents at the National Sheriffs' Association on Monday in New Orleans.\n" +
            "\n" +
            "Speaking at a White House briefing Monday evening after her appearance in New Orleans, Nielsen told reporters the current immigration issue has been growing for years and is the product of loopholes that she said has created an open border.\n" +
            "\n" +
            "At the briefing, she again urged Congress to change laws, saying that her department was tasked with enforcing the laws. \n" +
            "\n" +
            "There is no law mandating the separation of children and parents at the border, but Nielsen said Monday that past administrations asked immigration agents to look the other way when families crossed the border illegally.\n" +
            "\n" +
            "Children can't go to jail with their parents, so they are separated.\n" +
            "\n" +
            "\"The children are not being used as a pawn,\" Nielsen said in response to a question about accusations from Democrats. \"We are trying to protect the children, which is why I'm asking Congress to act.\"\n" +
            "\n" +
            "Both the House and the Senate are controlled by Republicans.\n" +
            "\n" +
            "Nancy Pelosi, House minority leader, said on Twitter that what's happening now isn't an immigration issue but a humanitarian one, saying \"we must do more to end the suffering of these young children who've been torn away from their parents.\"\n" +
            "\n" +
            "Sessions and other officials said the goal was to deter people from crossing illegally. The U.S. has been confronting an increase in illegal crossing attempts so far this year, but the levels are still far off those from the late 1980s until the early 2000s.\n" +
            "\n" +
            "Zero-tolerance announcement\n" +
            "The zero-tolerance announcement, in fact, came just days after Trump himself touted statistics released by Customs and Border Enforcement showing that illegal crossings in 2017 had fallen to historic lows.\n" +
            "\n" +
            "Trump has continued to blame the Democrats for the separations in public comments and on social media.\n" +
            "\n" +
            "In a flurry of tweets on Monday morning before he spoke at the White House, he again cited concerns about gangs and crime rates in Central America, although those concerns have existed for several years, if not decades, and are what have prompted thousands to flee.\n" +
            "\n" +
            "In unrelated tweets about Europe's migrant crisis, Trump said he wouldn't allow the U.S. to be overwhelmed by the number of new arrivals that Germany has received. European nations, he said, had allowed \"millions of people in who have so strongly and violently changed their culture.\"\n" +
            "\n" +
            "Germany's overall crime rate has fallen to record lows, according to a report in May, while its trend on violent crime is more unclear. The U.S. is significantly more violent than Germany with respect to homicide rates.\n" +
            "\n" +
            "Nielsen in her speech said that releasing parents with their children amounts to a \"get out of jail free card\" policy for illegal immigrants and accused some of posing as families to gain entry.\n" +
            "\n" +
            "Republican Sen. Susan Collins, of Maine, said she favours tighter border security, but expressed deep concerns about the child separation policy, as have some other Republicans, including House Speaker Paul Ryan of Wisconsin.\n" +
            "\n" +
            "\"What the administration has decided to do is to separate children from their parents to try to send a message that if you cross the border with children, your children are going to be ripped away from you,\" said Collins. \"That's traumatizing to the children who are innocent victims, and it is contrary to our values in this country.\"\n" +
            "\n" +
            "The president is also feeling the heat from numerous religious groups, including some conservative ones, a bloc that voted overwhelmingly for him in the 2016 presidential election. Influential Rev. Franklin Graham has called the policy \"disgraceful,\" while a host of religious organizations including the Southern Baptist Convention, U.S. Conference of Catholic Bishops and the United Church of Christ have released statements in recent days condemning the separation of children from adult guardians.\n" +
            "\n" +
            "Despite Sessions's April announcement, and his frequent interviews and speeches since defending the approach — including an attempt to justify it by citing Bible passages — Nielsen a day earlier left many scratching their heads on Sunday evening by tweeting that the policy did not exist.\n" +
            "\n" +
            "Nielsen in subsequent tweets stressed that only in remarkable circumstances — endangerment of a child — are kids separated from their parents when people make an asylum claim at a legal port of entry.\n" +
            "\n" +
            "While Nielsen attempted to parse the issue, the administration is being challenged by its own policy, which entails additional facilities. According to one report last week, the government was even looking into the possibility of outdoor tent camps at military bases.\n" +
            "\n" +
            "Trump plans to meet with House Republicans on Tuesday to discuss pending immigration legislation amid an election-season debate over one of his favourite issues. The House is expected to vote this week on a bill pushed by conservatives that may not have enough support to pass, and a compromise measure with key proposals supported by the president. The White House has said Trump would sign either of those.\n" +
            "\n" +
            "Democratic congressman Adam Schiff of California said the administration is \"using the grief, the tears, the pain of these kids as mortar to build our wall. And it's an effort to extort a bill to their liking in the Congress.\"\n" +
            "\n" +
            "Democratic Sen. Joe Donnelly of Indiana said on Sunday he is ready to co-sponsor legislation to end the practice.\n" +
            "\n" +
            "The House proposals face broad opposition from Democrats, and even if a bill does pass, the closely divided Senate seems unlikely to go along.\n" +
            "\n" +
            "The UN on Monday reiterated its condemnation of the U.S. separation policy, calling it\n";

}
