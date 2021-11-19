package com.shiguang.common.utils;

public final class MessageQueue {
    //根消息
    private Message queue;

    /**
     * 消息队列添加消息
     * @param msg   消息
     * @param when  取出消息时刻
     */
    void enqueueMessage(Message msg, long when) {
        synchronized (this) {
            msg.markInUse();
            msg.when = when;
            Message temp = queue;
            if (temp == null || when == 0 || when < temp.when) {
                msg.next = temp;
                queue = msg;
            }else {
                Message pre;
                for (;;) {
                    pre = temp;
                    temp = temp.next;
                    if (temp == null || when < temp.when) {
                        break;
                    }
                }
                msg.next = temp;
                pre.next = msg;
            }
        }
    }

    void removeMessages(Handler h, int what, Object object) {
        if (h == null) {
            return;
        }

        synchronized (this) {
            Message p = queue;

            // Remove all messages at front.
            while (p != null && p.target == h && p.what == what
                    && (object == null || p.obj == object)) {
                Message n = p.next;
                queue = n;
                p.recycle();
                p = n;
            }

            // Remove all messages after front.
            while (p != null) {
                Message n = p.next;
                if (n != null) {
                    if (n.target == h && n.what == what
                            && (object == null || n.obj == object)) {
                        Message nn = n.next;
                        n.recycle();
                        p.next = nn;
                        continue;
                    }
                }
                p = n;
            }
        }
    }

    /**
     * 消息队列取出消息，堵塞线程
     * @return
     */
    Message next() {
        for (;;) {
            synchronized (this) {
                long now = System.currentTimeMillis();
                Message msg = queue;
                if (msg != null) {
                    if (now >= msg.when) {
                        queue = msg.next;
                        msg.next = null;
                        msg.markInUse();
                        return msg;
                    }
                }
            }
        }
    }
}
