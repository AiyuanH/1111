package demo053;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        // 定义字符集
        char[] characters = {'a', 'b', 'c', 'd', 'e', '.', 'f', 'g', 'h', 'l', 'j', 'k'};

        // 创建 Random 对象
        Random random = new Random();

        // 生成四位验证码
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            // 随机选择字符集中的一个字符
            char randomChar = characters[random.nextInt(characters.length)];
            code.append(randomChar);
        }

        // 输出验证码
        System.out.println("验证码：" + code.toString());
    }
}
