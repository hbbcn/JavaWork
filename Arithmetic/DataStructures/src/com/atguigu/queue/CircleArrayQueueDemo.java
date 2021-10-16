package com.atguigu.queue;
import java.util.Scanner;

/**
 *@ClassName CircleArrayQueueDemo
 *@Description  TODO
 *@Author hqb
 *@Date 2021/10/12 19:09
 *@Version 1.0
 */

/**
 * 取模运算
 * 对于取模（取余）运算%，比如A % M，结果永远都是在[0, M-1)之间循环，并且如果A < M，
 * 则结果和没有进行取模运算一样。这一特点有很多应用场景
 * 1、最常见的就是对2取模来判断奇偶数
 * 2、循环队列中通过对最大容量取模来控制数组下标，防止索引越界
 *
 *计算循环队列的元素个数
 * 设队列头指针为 front，队列尾指针为 rear，队列容量为 maxsize
 * 队空：front＝= rear
 * 队满： (rear+1) mod maxsize == front ( mod 表示求余运算)
 * 队中元素个数 n＝（rear-front+maxsize )mod maxsize
 * 入队：rear=(rear+1) % maxsize ;
 * 出队：front=(front+1) % maxsize ;
 */
public class CircleArrayQueueDemo{

    public static void main(String[] args) {
//创建一个队列
        CircleArray queue = new CircleArray(4);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列的数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}

class CircleArray{
    private int maxSize;//表示数组的最大容量
    //front 变量的含义做一个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
    //front 的初始值 = 0

    private int front;//队列头

    //rear变量的含义做了一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出来一个空间做为约定
    //rear的初始值=0
    private int rear; //队列尾
    private int[] arr;  //数组模拟队列

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];

    }
    //判断队列是否满
    public boolean ifFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (ifFull()) {
            System.out.println("队列满，不能添加数据~");
            return;
        }

        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
}
    //获取队列数据 出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛异常来处理
            throw new RuntimeException("队列为空");
        }

        //这里需要分析出front是指向队列的第一个元素
        //1、先把front对应的值保留到一个临时变量
        //2、将front后移，考虑取模
        //3、将临时保存的变量返回

        int value = arr[front];
        front = (front + 1 ) % maxSize;
        return  value;

    }
    //显示队列所有数据
    public void showQueue() {
        //遍历

        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素

        for (int i = front; i < front + rear; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
 /*   public int size(){
        return (rear + maxSize - front) % maxSize;
    }*/
    //显示队列的头数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }



}

