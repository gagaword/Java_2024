package CTF.ISCC.ChallengeMobile;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
	private static int MX(int i, int i2, int i3, int i4, int i5, int[] iArr) {
		return (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4))) ^ ((i ^ i2) + (iArr[(i4 & 3) ^ i5] ^ i3));
	}

	private static byte[] fixKey(byte[] bArr) {
		if (bArr.length != 16) {
			byte[] bArr2 = new byte[16];
			if (bArr.length < 16) {
				System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
			} else {
				System.arraycopy(bArr, 0, bArr2, 0, 16);
			}
			return bArr2;
		}
		return bArr;
	}

	private static int[] toIntArray(byte[] bArr, boolean z) {
		int[] iArr;
		int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
		if (z) {
			iArr = new int[length + 1];
			iArr[length] = bArr.length;
		} else {
			iArr = new int[length];
		}
		int length2 = bArr.length;
		for (int i = 0; i < length2; i++) {
			int i2 = i >>> 2;
			iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
		}
		return iArr;
	}

	private static byte[] toByteArray(int[] iArr, boolean z) {
		int i;
		int length = iArr.length << 2;
		if (z) {
			i = iArr[iArr.length - 1];
			int i2 = length - 4;
			if (i < i2 - 3 || i > i2) {
				return null;
			}
		} else {
			i = length;
		}
		byte[] bArr = new byte[i];
		for (int i3 = 0; i3 < i; i3++) {
			bArr[i3] = (byte) (iArr[i3 >>> 2] >>> ((i3 & 3) << 3));
		}
		return bArr;
	}

	private static int[] decrypt(int[] iArr, int[] iArr2) {
		int length = iArr.length - 1;
		if (length >= 1) {
			int i = (52 / (length + 1)) + 6;
			int i3 = 0;
			for (int j = 0; j < i; ++j)
				i3 -= 0x61c88647;

			for (int j = 0; j < i; ++j) {
				int i6 = length;
				int i2 = iArr[length - 1];
				int i5 = (i3 >>> 2) & 3;
				iArr[length] = iArr[length] - MX(i3, iArr[0], i2, i6, i5, iArr2);
				while (i6 > 0) {
					--i6;
					i2 = iArr[i6 - 1 < 0 ? length : i6 - 1];
					iArr[i6] = iArr[i6] - MX(i3, iArr[i6 + 1], i2, i6, i5, iArr2);
				}
				i3 += 0x61c88647;
			}
		}
		return iArr;
	}

	public static void main(String[] args) {
		int[] encryptIntArray = toIntArray(Base64.getDecoder().decode("Ckh/PFCSS/i4kMVw1lswyghOZbIg+W5SymREHNcRg721Tm9w"), false);
//		System.out.println(Arrays.toString(encryptIntArray));
		int[] keyIntArray = toIntArray(fixKey("oM51I504n137gp2~".getBytes(StandardCharsets.UTF_8)), true);
		byte[] decryptBytes = toByteArray(decrypt(encryptIntArray, keyIntArray), true);
		assert decryptBytes != null;
		String str = new String(decryptBytes, StandardCharsets.UTF_8);
		System.out.printf("ISCC{%s}\n", str);
	}
}
