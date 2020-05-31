package com.zk.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        displayBufferInfo(byteBuffer,"init");

        byteBuffer.put((byte) 'a');
        byteBuffer.put((byte) 'b');
        byteBuffer.put((byte) 'c');
        displayBufferInfo(byteBuffer, "after put");

        byteBuffer.flip();
        displayBufferInfo(byteBuffer, "after flip");
        System.out.println((char) byteBuffer.get());
        displayBufferInfo(byteBuffer, "after a get");

        byteBuffer.clear();
        displayBufferInfo(byteBuffer, "after clear");
        // 依然可以访问到数据
        System.out.println((char) byteBuffer.get(2));
    }

    public static void displayBufferInfo(Buffer buffer, String msg) {
        System.out.println("---------" + msg + "-----------");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
    }
}
