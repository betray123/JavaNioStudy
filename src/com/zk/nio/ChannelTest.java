package com.zk.nio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ChannelTest {
    private static CharsetDecoder decoder = Charset.forName("utf-8").newDecoder();

    public static void main (String[] args) throws IOException {
        try (
                FileChannel inChannel = new FileInputStream("D:\\zk\\IdeaProjects\\JavaNioStudy\\src\\com\\zk\\nio\\save.txt").getChannel();
                FileChannel outChannel = new FileOutputStream("D:\\zk\\IdeaProjects\\JavaNioStudy\\src\\com\\zk\\nio\\attach.txt").getChannel()) {
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0,
                    new File("D:\\zk\\IdeaProjects\\JavaNioStudy\\src\\com\\zk\\nio\\save.txt").length());
            BufferTest.displayBufferInfo(buffer, "init buffer");

            // 将Buffer内容一次写入另一文件的Channel
            outChannel.write(buffer);
            buffer.flip();
            // 解码CharBuffer之后输出
            System.out.println(decoder.decode(buffer));
        }
    }
}
