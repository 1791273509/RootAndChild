package thrift.demo;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/3/26 下午6:25
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runterminal {

    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("ping www.stackabuse.com");
        printResults(process);
        /*Process process1 = Runtime.getRuntime().exec("thrift -r -gen java");
        InputStream outputStream = process1.getInputStream();*/
        // printResults(process1);
    }
    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println("te");

        String line ="";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            process.destroy();

        }
    }
}
    