package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelTransfer {
    public static void main(String[] args) throws IOException {
        RandomAccessFile from = new RandomAccessFile("E:\\技术资料\\1.java\\nio\\1.csv", "rw");
        FileChannel fromChannel = from.getChannel();

        RandomAccessFile to = new RandomAccessFile("E:\\技术资料\\1.java\\nio\\2.csv", "rw");
        FileChannel toChannel = to.getChannel();

        long position = toChannel.position();
        System.out.println("position: " + position);
        long size = fromChannel.size();
        System.out.println("size: " + size);

        toChannel.transferFrom(fromChannel, position, size);
    }
}
