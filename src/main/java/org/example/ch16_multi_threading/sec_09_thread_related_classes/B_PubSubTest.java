package org.example.ch16_multi_threading.sec_09_thread_related_classes;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class B_PubSubTest {
    public static void main(String[] args) {
        // 创建一个SubmissionPublisher作为发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        // 创建订阅者
        MySubscriber<String> subscriber = new MySubscriber<>();
        // 注册订阅者
        publisher.subscribe(subscriber);
        // 发布几个数据项
        System.out.println("开始发布数据...");
        List.of("Java", "Kotlin", "Go", "Erlang", "Swift", "Lua").forEach(im -> {
            // 提交数据
            publisher.submit(im);
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        // 发布结束
        publisher.close();
        // 发布结束后，为了让发布者线程不会死亡，暂停线程
        synchronized ("fkjava") {
            try {
                "fkjava".wait();
            } catch (Exception ex) {
                ex.printStackTrace( );
            }
        }
    }
}

// 创建订阅者
class MySubscriber<T> implements Flow.Subscriber {
    // 发布者与订阅者之间的纽带
    private Flow.Subscription subscription;

    // 订阅时触发该方法
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        // 开始请求数据
        subscription.request(1);
    }

    // 接收到数据时触发该方法
    @Override
    public void onNext(Object item) {
        System.out.println("获取到数据: " + item);
        // 请求下一条数据
        subscription.request(1);
    }

    // 订阅出错时触发该方法
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        synchronized ("fkjava") {
            "fkjava".notifyAll();
        }
    }

    // 订阅结束时触发该方法
    @Override
    public void onComplete() {
        System.out.println("订阅结束");
        synchronized ("fkjava") {
            "fkjava".notifyAll();
        }
    }
}