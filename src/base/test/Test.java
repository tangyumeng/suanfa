package base.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }

    private void test() {
        List<Integer> base = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        // 生产者 —— 读取数据
        List<? extends Number> numbers = base;
        Number n = numbers.get(0);  // ✅ 可以读
        // numbers.add(4);          // ❌ 不能写入（类型不确定）
        System.out.println(n);

// 消费者 —— 写入数据
        List<? super Integer> sink = base;
        sink.add(10); // ✅ 可以写入 Integer 或其子类
        System.out.println(base);
    }
}
