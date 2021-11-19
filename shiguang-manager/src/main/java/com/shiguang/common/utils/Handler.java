package com.shiguang.common.utils;

public class Handler {
    //关联线程的Looper
    final Looper mLooper;
    //Looper的消息队列
    final MessageQueue mQueue;

    public Handler() {
        mLooper = Looper.myLooper();
        mQueue = mLooper.mQueue;
    }

    public Handler(Looper looper) {
        mLooper = looper;
        mQueue = mLooper.mQueue;
    }

    /**
     * 处理其他线程发送的消息
     * @param msg
     */
    public void handleMessage(Message msg) {
    }

    public final void removeMessages(int what) {
        mQueue.removeMessages(this, what, null);
    }

    /**
     * 分发消息，两种处理方式
     * @param msg
     */
    public void dispatchMessage(Message msg) {
        if (msg.callBack != null) {
            msg.callBack.run();
        }else {
            handleMessage(msg);
        }
    }

    /**
     * 发送任务到当前线程
     * @param r
     */
    public final void post(Runnable r) {
        postDelayed(r,0);
    }

    /**
     * 延迟发送任务
     * @param r
     * @param delayMillis
     */
    public final void postDelayed(Runnable r, long delayMillis) {
        Message msg = Message.obtain(this, r);
        sendMessageDelayed(msg,delayMillis);
    }

    /**
     * 发送消息
     * @param msg
     */
    public final void sendMessage(Message msg) {
        sendMessageDelayed(msg,0);
    }

    /**
     * 延迟发送消息
     * @param msg
     * @param delayMillis
     */
    public final void sendMessageDelayed(Message msg, long delayMillis) {
        if (delayMillis < 0) {
            delayMillis = 0;
        }
        sendMessageAtTime(msg,System.currentTimeMillis() + delayMillis);
    }

    /**
     * 在预定时刻发送消息
     * @param msg
     * @param uptimeMillis
     */
    public final void sendMessageAtTime(Message msg, long uptimeMillis) {
        if (mQueue == null) {
            throw new IllegalStateException("The thread has not a Looper,please Looper.prepare() first.");
        }
        msg.target = this;
        mQueue.enqueueMessage(msg,uptimeMillis);
    }
}
