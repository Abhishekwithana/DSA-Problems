
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = null;
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class FastWriter {
    PrintWriter pw;

    public FastWriter() {
        pw = new PrintWriter(System.out);
    }

    public void print(Object o) {
        pw.print(o);
    }

    public void println(Object o) {
        pw.println(o);
    }

    public void close() {
        pw.close();
    }

    public void flush() {
        pw.flush();
    }
}
public class SpiralNumber {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();

        long t = reader.nextLong();

        while(t-- > 0) {
            long r = reader.nextLong();
            long c = reader.nextLong();

            long ans = solve(r, c);
            writer.println(ans);
            writer.flush();
        }
        writer.flush();
        writer.close();
    }
    public static long solve(long r, long c) {
        long ans = 0;

        if(r >= c) {
            long start = r % 2 == 0 ? (r * r) : ((r - 1) * (r - 1)) + 1;

            if(r % 2 == 0) {
                ans = start - (c - 1);
            }else {
                ans = start + (c - 1);
            }
        }else {
            long start = c % 2 == 0 ? (c * c) : ((c - 1) * (c - 1)) + 1;

            if(c % 2 == 0) {
                ans = start + (r - 1);
            }else {
                ans = start - (r - 1);
            }
        }
        return ans;
    }
}
