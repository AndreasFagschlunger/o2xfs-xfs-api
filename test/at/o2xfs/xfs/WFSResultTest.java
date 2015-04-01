package at.o2xfs.xfs;

import at.o2xfs.common.Hex;
import at.o2xfs.win32.Buffer;
import at.o2xfs.win32.BufferFactory;

import org.junit.Test;

public class WFSResultTest {

	@Test
	public final void test() {
		byte[] bytes = Hex.decode("020000000200dd07090006000700100025003500da00000000000104000000000000");
		Buffer buffer = BufferFactory.getInstance().createBuffer(bytes.length);
		buffer.put(bytes);
		WFSResult wfsResult = new WFSResult(null);
		System.out.println(wfsResult);

	}

}
